package com.pe.petelosz.dto.request;

import com.pe.petelosz.entity.Service;
import lombok.Data;
import org.hibernate.validator.constraints.time.DurationMin;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ServiceSaveRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @Min(value=5)
    @NotNull
    private Long duration;
    public Service toService(){
        return Service.builder()
                .name(this.name)
                .description(this.description)
                .duration(this.duration)
                .build();
    }
}
