package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    @Query("SELECT new com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.name, c.age)"
            + "FROM Customer c WHERE c.age > :age")
    List<GetListCustomerResponse> findCustomerByAge(int age);

    List<Customer> findByAgeIsNull();
}
