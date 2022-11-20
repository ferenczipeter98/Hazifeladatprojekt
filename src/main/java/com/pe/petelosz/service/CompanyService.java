package com.pe.petelosz.service;


import com.pe.petelosz.dto.response.CompanyResponse;
import com.pe.petelosz.entity.Company;
import com.pe.petelosz.entity.Service;
import com.pe.petelosz.exception.CustomMessageException;
import com.pe.petelosz.repository.CompanyRepository;
import com.pe.petelosz.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Service
public class CompanyService {


    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyResponse> getAll() {
        List<CompanyResponse> responseList = new ArrayList<>();
        companyRepository.findAll().forEach(x -> {
            CompanyResponse response = ObjectMapperUtils.map(x, CompanyResponse.class);
            response.setServiceIds(x.getServices().stream().map(Service::getId).collect(Collectors.toList()));
            responseList.add(response);
        });
        return responseList;
    }

    public CompanyResponse getById(Long compId) {
       Company company= companyRepository.findById(compId).orElseThrow(RuntimeException::new);;
        CompanyResponse response = ObjectMapperUtils.map(company, CompanyResponse.class);
        response.setServiceIds(company.getServices().stream().map(Service::getId).collect(Collectors.toList()));
        return response;

    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }


    public void deleteById(Long compId) {
        Company currentCompany = companyRepository.findById(compId).orElseThrow(RuntimeException::new);
        if (currentCompany.getServices().isEmpty()) {
            companyRepository.deleteById(compId);
        } else {
            throw new CustomMessageException("Company Not Deletable", HttpStatus.BAD_REQUEST);
        }
    }
}
