package com.tobeto.rentacar.services.dtos.customer.responses;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    private int id;
    private String name;
    private int age;
}
