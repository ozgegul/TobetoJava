package com.tobeto.rentacar.services.dtos.company.requests;

import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private int id;
    private String name;
    private String email;
}
