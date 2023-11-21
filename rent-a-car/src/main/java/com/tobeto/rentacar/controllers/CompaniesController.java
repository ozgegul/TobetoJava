package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompaniesController {

    private final CompanyRepository companyRepository;

    public CompaniesController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAll(){
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @GetMapping("{id}")
    public Company getById(@PathVariable int id){
        return companyRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Company company){
        companyRepository.save(company);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Company companyToDelete = companyRepository.findById(id).orElseThrow();
        companyRepository.delete(companyToDelete);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Company company){
        Company companyToUpdate = companyRepository.findById(id).orElseThrow();
        companyToUpdate.setName(company.getName());
        companyToUpdate.setEmail(company.getEmail());
        companyToUpdate.setVehicles(company.getVehicles());
        companyRepository.save(companyToUpdate);
    }
}
