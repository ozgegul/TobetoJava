package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        customerService.add(addCustomerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.update(updateCustomerRequest);
    }
}
