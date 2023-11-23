package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.company.requests.AddCompanyRequest;
import com.tobeto.rentacar.services.dtos.company.requests.UpdateCompanyRequest;

public interface CompanyService {
    void add(AddCompanyRequest addCompanyRequest);
    void update(UpdateCompanyRequest updateCompanyRequest);
    void delete(int id);
}
