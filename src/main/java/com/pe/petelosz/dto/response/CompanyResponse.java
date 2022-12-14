package com.pe.petelosz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private String name;
    private String address;
    private Integer open;
    private Integer close;
    private List<Long> serviceIds;
}
