package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);
    void update(UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);

    List<Customer> getByAge();

    List<GetListCustomerResponse> findCustomerByAge();
}
