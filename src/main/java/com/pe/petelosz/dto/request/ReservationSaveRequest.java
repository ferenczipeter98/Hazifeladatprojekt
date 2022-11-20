package com.pe.petelosz.dto.request;
import com.pe.petelosz.entity.Reservation;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ReservationSaveRequest {


    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNumber;
    //@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'+/=?^_`{|}~-]+)|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])")@(?:(?:[a-z0-9](?:[a-z0-9-][a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-][a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])")
    @NotEmpty
    private String email;
    @NotNull
    private Long serviceId;
    public Reservation toReservation(){
        return Reservation.builder()
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}
