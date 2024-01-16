package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetByIdCustomerResponse;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCustomerRequest addCustomerRequest){
        customerService.add(addCustomerRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest){
        customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }

    @GetMapping("/getByAgeIsNull")
    public List<Customer> getByAgeIsNull(){
        return customerService.getByAgeIsNull();
    }

    @GetMapping("/findCustomerByAge")
    public List<GetListCustomerResponse> findCustomerByAge(@RequestParam int age){
        return customerService.findCustomerByAge(age);
    }

    @GetMapping("/getById")
    public GetByIdCustomerResponse getById(@RequestParam int id){
        return customerService.getById(id);
    }
}
