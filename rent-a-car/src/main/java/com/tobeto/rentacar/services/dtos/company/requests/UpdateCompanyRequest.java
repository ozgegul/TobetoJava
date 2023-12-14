package com.tobeto.rentacar.services.dtos.company.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {
    private int id;
    @NotBlank(message = "Company name cannot be empty!")
    private String name;
    @NotNull(message = "Email cannot be null!")
    private String email;
}
