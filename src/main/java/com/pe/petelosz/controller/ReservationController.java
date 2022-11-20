package com.pe.petelosz.controller;



import com.pe.petelosz.dto.request.ReservationSaveRequest;
import com.pe.petelosz.entity.Reservation;
import com.pe.petelosz.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservationDetails(@RequestBody @Valid ReservationSaveRequest saveRequest) {
        return reservationService.save(saveRequest);

    }
    @DeleteMapping("/{reservationId}")
    public void deleteById(@PathVariable Long reservationId) {
        reservationService.deleteById(reservationId);

    }

}
