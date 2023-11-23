package com.tobeto.rentacar.services.dtos.customer.requests;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String address;
}
