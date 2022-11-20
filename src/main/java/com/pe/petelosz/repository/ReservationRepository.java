package com.pe.petelosz.repository;

import com.pe.petelosz.entity.Company;
import com.pe.petelosz.entity.Reservation;
import com.pe.petelosz.entity.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();
    Optional<Reservation> findById(Long reservationId);
}
