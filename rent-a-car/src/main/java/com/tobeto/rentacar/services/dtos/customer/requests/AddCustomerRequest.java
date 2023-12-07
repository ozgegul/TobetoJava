package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddCustomerRequest {
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    private String address;
}
