package com.tobeto.rentacar.services.dtos.company.requests;

import lombok.Data;

@Data
public class AddCompanyRequest {
    private String name;
    private String email;
}
