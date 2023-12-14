package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.services.abstracts.CompanyService;
import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.responses.GetByIdCompanyResponse;
import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
public class CompaniesController {

    private final CompanyService companyService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCompanyRequest addCompanyRequest){
        companyService.add(addCompanyRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCompanyRequest updateCompanyRequest){
        companyService.update(updateCompanyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        companyService.delete(id);
    }

    @GetMapping("/getByName")
    public List<Company> getByName(@RequestParam String name){
        return companyService.getByName(name);
    }

    @GetMapping("/getById")
    public GetByIdCompanyResponse getById(@RequestParam int id){
        return companyService.getById(id);
    }

    @GetMapping("/getByNameDto")
    public List<GetListCompanyResponse> getByNameDto(@RequestParam String name){
        return companyService.getByNameDto(name);
    }
}
