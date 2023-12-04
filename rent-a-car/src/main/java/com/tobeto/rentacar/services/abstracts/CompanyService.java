package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;

import java.util.List;

public interface CompanyService {
    void add(AddCompanyRequest addCompanyRequest);
    void update(UpdateCompanyRequest updateCompanyRequest);
    void delete(int id);

    List<Company> getByName(String name);

    List<Company> getById(String name);

    List<GetListCompanyResponse> getByNameDto(String name);
}
