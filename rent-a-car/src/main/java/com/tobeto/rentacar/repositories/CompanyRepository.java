package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Company;
import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer>
{
    List<Company> findByNameStartingWith(String name);
    @Query("Select new com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse(b.name)"
            + "FROM Company b WHERE b.name = :name")
    List<GetListCompanyResponse> findByName(String name);

    boolean existsByNameStartingWith(String name);
    boolean existsByName(String name);
}
