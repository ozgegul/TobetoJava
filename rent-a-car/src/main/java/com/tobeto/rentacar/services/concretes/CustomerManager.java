package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest addCustomerRequest){
        Customer customer = new Customer();
        customer.setName(addCustomerRequest.getName());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest){
        Customer customerToUpdate = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        customerToUpdate.setName(updateCustomerRequest.getName());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void delete(int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<Customer> getByAge() {
        return customerRepository.findByAgeIsNull();
    }

    @Override
    public List<GetListCustomerResponse> findCustomerByAge(int age) {
        return customerRepository.findCustomerByAge(age).stream().map((customer) ->
                new GetListCustomerResponse()).toList();
        //return customerRepository.findCustomerByAge();
    }

}
