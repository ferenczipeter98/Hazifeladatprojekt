package com.pe.petelosz.controller;

import com.pe.petelosz.dto.request.CompanySaveRequest;
import com.pe.petelosz.dto.response.CompanyResponse;
import com.pe.petelosz.entity.Company;
import com.pe.petelosz.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company/")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{compId}")
    public CompanyResponse findById(@PathVariable Long compId) {
        return companyService.getById(compId);
    }

    @PostMapping
    public Company createCompanyDetails(@RequestBody @Valid CompanySaveRequest saveRequest) {
        return companyService.save(saveRequest.toCompany());

    }

    @PutMapping("/{compId}")
    public Company updateCompanyDetails(@PathVariable Long compId, @RequestBody @Valid CompanySaveRequest saveRequest) {
        Company company = saveRequest.toCompany();
        company.setId(compId);
        return companyService.save(company);
    }

    @DeleteMapping("/{compId}")
    public void deleteById(@PathVariable Long compId) {
        companyService.deleteById(compId);

    }
}
