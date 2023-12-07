package com.tobeto.rentacar.services.dtos.company.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private int id;
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    private String email;
}
