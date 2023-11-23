package com.tobeto.rentacar.services.dtos.customer.requests;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String name;
    private String address;
}
