package com.pe.petelosz.dto.request;

import com.pe.petelosz.entity.Company;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CompanySaveRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotNull
    @Min(value=0)
    private Integer open;
    @NotNull
    @Max(value=24)
    private Integer close;
    public Company toCompany(){
        return Company.builder()
                .name(this.name)
                .address(this.address)
                .open(this.open)
                .close(this.close)
                .build();
    }
}
