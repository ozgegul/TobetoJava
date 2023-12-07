package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    @NotBlank(message = "Name cannot be empty.")
    private String name;
    private String address;
}
