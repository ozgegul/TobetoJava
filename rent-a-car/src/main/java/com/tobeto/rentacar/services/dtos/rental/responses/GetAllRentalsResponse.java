package com.tobeto.rentacar.services.dtos.rental.responses;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalsResponse {
    private int id;
    private LocalDate date;
    private Customer customer;
    private Vehicle vehicle;
}
