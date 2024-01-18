package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    List<Customer> findByAgeIsNull();
    @Query("SELECT new com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.name, c.age)"
            + "FROM Customer c WHERE c.age > :age")
    List<GetListCustomerResponse> findCustomerByAge(int age);
    boolean existsCustomerByAge(Integer age);

    //boolean existsCustomerByAge(int age);
}
