package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.customer.responses.GetByIdCustomerResponse;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

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
    public GetByIdCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
    }

    @Override
    public GetByIdCustomerResponse getByEmail(String email){
        Customer customer = customerRepository.findByEmail(email).orElseThrow();
        GetByIdCustomerResponse response = this.modelMapperService.forResponse().map(customer, GetByIdCustomerResponse.class);
        return response;
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
