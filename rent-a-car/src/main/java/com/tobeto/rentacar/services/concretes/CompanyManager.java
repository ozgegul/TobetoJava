package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.repositories.CompanyRepository;
import com.tobeto.rentacar.services.abstracts.CompanyService;
import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyManager(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void add(AddCompanyRequest addCompanyRequest){
        Company company = new Company();
        company.setName(addCompanyRequest.getName());
        companyRepository.save(company);
    }

    @Override
    public void update(UpdateCompanyRequest updateCompanyRequest){
        Company companyToUpdate = companyRepository.findById(updateCompanyRequest.getId()).orElseThrow();
        companyToUpdate.setName(updateCompanyRequest.getName());
        companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(int id){
        Company companyToDelete = companyRepository.findById(id).orElseThrow();
        companyRepository.delete(companyToDelete);
    }

    @Override
    public List<Company> getByName(String name) {
        return companyRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Company> getById(String name) {
        return null;
    }

    @Override
    public List<GetListCompanyResponse> getByNameDto(String name) {
        return companyRepository.findByName(name);
    }
}
