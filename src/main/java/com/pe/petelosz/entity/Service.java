package com.pe.petelosz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@EqualsAndHashCode(exclude={"companies","reservations"})
@ToString(exclude = {"companies","reservations"})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Long duration;


    @ManyToMany(mappedBy = "services",fetch = FetchType.LAZY)
    private Set<Reservation> reservations;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comp_id", nullable=false)
    @JsonIgnore
    private Company company;


}
