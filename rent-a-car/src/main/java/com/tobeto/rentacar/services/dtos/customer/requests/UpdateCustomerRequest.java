package com.tobeto.rentacar.services.dtos.customer.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotNull(message = "Id cannot be null.")
    private int id;
    @NotEmpty(message = "Name cannot be empty.")
    private String name;
    private String address;
    @NotNull(message = "Age cannot be empty.")
    private int age;
}
