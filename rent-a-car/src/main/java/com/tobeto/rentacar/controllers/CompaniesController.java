package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CompanyService;
import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {

    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public void add(@RequestBody AddCompanyRequest addCompanyRequest){
        companyService.add(addCompanyRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        companyService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCompanyRequest updateCompanyRequest){
       companyService.update(updateCompanyRequest);
    }
}
