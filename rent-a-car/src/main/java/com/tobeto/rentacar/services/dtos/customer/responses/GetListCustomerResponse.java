package com.tobeto.rentacar.services.dtos.customer.responses;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    @NotNull(message = "Id cannot be null.")
    private int id;
    private String address;
    @NotNull(message = "Age cannot be empty.")
    private int age;
}
