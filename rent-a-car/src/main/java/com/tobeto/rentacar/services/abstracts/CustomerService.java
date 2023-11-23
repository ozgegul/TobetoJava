package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);
}
