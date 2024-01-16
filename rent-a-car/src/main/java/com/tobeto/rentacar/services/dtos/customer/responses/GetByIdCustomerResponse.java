package com.tobeto.rentacar.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCustomerResponse {
    private int id;
    private String email;
    private String password;
}
