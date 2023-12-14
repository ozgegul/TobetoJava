package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest addCustomerRequest){
        if (customerRepository.existsCustomerByAge(addCustomerRequest.getAge())){
            throw new RuntimeException("Age cannot be empty");
        }
        Customer customer = new Customer();
        customer.setName(addCustomerRequest.getName());
        customer.setAge(addCustomerRequest.getAge());
        customer.setAddress(addCustomerRequest.getAddress());
        customerRepository.save(customer);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest){
        if(customerRepository.existsById(updateCustomerRequest.getId())){
            throw new RuntimeException("Id cannot be empty");
        }
        Customer customerToUpdate = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        customerToUpdate.setName(updateCustomerRequest.getName());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void delete(int id){
        if(!customerRepository.existsById(id)){
            throw new RuntimeException("Invalid id");
        }
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public List<Customer> getByAgeIsNull() {
        return customerRepository.findByAgeIsNull();
    }

    @Override
    public List<GetListCustomerResponse> findCustomerByAge(int age) {
        return customerRepository.findCustomerByAge(age).stream().map((customer) ->
                new GetListCustomerResponse()).toList();
    }
}
