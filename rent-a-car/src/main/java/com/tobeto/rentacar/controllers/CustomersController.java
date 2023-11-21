package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        // Exception fırlatması = bu satırın çalışmaması.
        customerRepository.delete(customerToDelete);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer customer){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setPayments(customer.getPayments());
        customerToUpdate.setRentals(customer.getRentals());
        customerRepository.save(customerToUpdate);
    }
}
