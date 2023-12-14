package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotEmpty(message = "Name cannot be empty.")
    private String name;
    @NotNull(message = "Age cannot be empty.")
    private int age;
    private String address;
}
