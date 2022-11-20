package com.pe.petelosz.service;

import com.pe.petelosz.dto.response.ServiceResponse;
import com.pe.petelosz.entity.Service;
import com.pe.petelosz.exception.CustomMessageException;
import com.pe.petelosz.repository.ServiceRepository;
import com.pe.petelosz.utils.ObjectMapperUtils;
import org.springframework.http.HttpStatus;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceResponse> getAll() {
        return ObjectMapperUtils.mapAll(serviceRepository.findAll(),ServiceResponse.class);
    }

    public ServiceResponse getById(Long serviceId) {
        return ObjectMapperUtils.map(serviceRepository.findById(serviceId).orElseThrow(RuntimeException::new),ServiceResponse.class);

    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }


    public void deleteById(Long serviceId) {
       Service currentService = serviceRepository.findById(serviceId).orElseThrow(RuntimeException::new);
        if (currentService.getReservations().isEmpty()) {
            serviceRepository.deleteById(serviceId);
        }
        else {
            throw new CustomMessageException("Service Not Deletable", HttpStatus.BAD_REQUEST);
        }
    }
}
