package com.pe.petelosz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@EqualsAndHashCode(exclude="services")
@ToString(exclude = "services")
@Getter
@Setter
@Builder
@Entity
@Table(name="companies")
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    private String name;
    private String address;
    private Integer open;
    private Integer close;


    @OneToMany(mappedBy="company")
    @JsonIgnore
    private List<Service> services;



}
