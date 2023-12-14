package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.repositories.CompanyRepository;
import com.tobeto.rentacar.services.abstracts.CompanyService;
import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.responses.GetByIdCompanyResponse;
import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public void add(AddCompanyRequest addCompanyRequest){
        if (companyRepository.existsByName(addCompanyRequest.getName())){
            throw new RuntimeException("There is another company with the same name!");
        }
        Company company = new Company();
        company.setName(addCompanyRequest.getName());
        company.setEmail(addCompanyRequest.getEmail());
        companyRepository.save(company);
    }

    @Override
    public void update(UpdateCompanyRequest updateCompanyRequest){
        if (!companyRepository.existsByName(updateCompanyRequest.getName())){
            throw new RuntimeException("There is no company with this name!");
        }
        Company companyToUpdate = companyRepository.findById(updateCompanyRequest.getId()).orElseThrow();
        companyToUpdate.setName(updateCompanyRequest.getName());
        companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(int id){
        if(companyRepository.existsById(id)){
            throw new RuntimeException("Invalid id");
        }
        Company companyToDelete = companyRepository.findById(id).orElseThrow();
        companyRepository.delete(companyToDelete);
    }

    @Override
    public List<Company> getByName(String name) {
        return companyRepository.findByNameStartingWith(name);
    }

    @Override
    public GetByIdCompanyResponse getById(int id) {
        Company company = companyRepository.findById(id).orElseThrow();
        GetByIdCompanyResponse getByIdCompanyResponse = new GetByIdCompanyResponse();
        getByIdCompanyResponse.setId(company.getId());
        getByIdCompanyResponse.setName(company.getName());
        getByIdCompanyResponse.setEmail(company.getEmail());
        return getByIdCompanyResponse;
    }

    @Override
    public List<GetListCompanyResponse> getByNameDto(String name) {

        return companyRepository.findByNameStartingWith(name).stream().map(company ->
                new GetListCompanyResponse(company.getId(), company.getName())).toList();
    }
}
