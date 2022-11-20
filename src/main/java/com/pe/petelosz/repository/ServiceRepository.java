package com.pe.petelosz.repository;


import com.pe.petelosz.entity.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    List<Service> findAll();
    Optional<Service> findById(Long serviceId);
}
