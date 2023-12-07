package com.tobeto.rentacar.services.dtos.company.responses;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCompanyResponse {
    private int id;
    @NotBlank(message = "Name cannot be empty.")
    private String name;
}
