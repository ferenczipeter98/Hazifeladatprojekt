package com.pe.petelosz.controller;


import com.pe.petelosz.dto.request.ServiceSaveRequest;
import com.pe.petelosz.dto.response.ServiceResponse;
import com.pe.petelosz.entity.Service;

import com.pe.petelosz.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service/")
public class ServiceController {

    private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping
    public List<ServiceResponse> getAll() {
        return serviceService.getAll();
    }

    @GetMapping("/{serviceId}")
    public ServiceResponse findById(@PathVariable Long serviceId) {
        return serviceService.getById(serviceId);
    }

    @PostMapping
    public Service createServiceDetails(@RequestBody @Valid ServiceSaveRequest saveRequest) {
        return serviceService.save(saveRequest.toService());

    }

    @PutMapping("/{serviceId}")
    public Service updateServiceDetails(@PathVariable Long serviceId, @RequestBody @Valid ServiceSaveRequest saveRequest) {
        Service service = saveRequest.toService();
        service.setId(serviceId);
        return serviceService.save(service);
    }

    @DeleteMapping("/{serviceId}")
    public void deleteById(@PathVariable Long serviceId) {
        serviceService.deleteById(serviceId);

    }
}
