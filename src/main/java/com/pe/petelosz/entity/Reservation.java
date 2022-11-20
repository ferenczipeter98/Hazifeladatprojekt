package com.pe.petelosz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="ser_res", joinColumns={@JoinColumn(name="res_id")}, inverseJoinColumns={@JoinColumn(name="ser_id")})

    private Set<Service> services;






}
