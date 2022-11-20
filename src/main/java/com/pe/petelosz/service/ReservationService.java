package com.pe.petelosz.service;



import com.pe.petelosz.dto.request.ReservationSaveRequest;
import com.pe.petelosz.entity.Reservation;
import com.pe.petelosz.exception.CustomMessageException;


import com.pe.petelosz.repository.ReservationRepository;
import com.pe.petelosz.repository.ServiceRepository;
import com.pe.petelosz.entity.Service;
import org.springframework.http.HttpStatus;


import java.util.*;

@org.springframework.stereotype.Service
public class ReservationService {
    private ServiceRepository serviceRepository;


    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository,ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(RuntimeException::new);

    }

    public Reservation save(ReservationSaveRequest reservationSaveRequest) {

        Optional<Service> service= serviceRepository.findById(reservationSaveRequest.getServiceId());
        if(!service.isPresent()){
            throw new CustomMessageException("Nem letezik a szolgaltatas", HttpStatus.FORBIDDEN);
        }
        Reservation reservation = reservationSaveRequest.toReservation();
        reservation.setServices(new HashSet<>(Arrays.asList(service.get())));
        return reservationRepository.save(reservation);

    }
    public void deleteById(Long reservationId) {
        Reservation currentReservation = reservationRepository.findById(reservationId).orElseThrow(RuntimeException::new);

        reservationRepository.deleteById(reservationId);


    }
}
