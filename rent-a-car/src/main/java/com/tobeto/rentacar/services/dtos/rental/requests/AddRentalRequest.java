package com.tobeto.rentacar.services.dtos.rental.requests;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.Vehicle;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    @NotNull(message = "Date cannot be empty")
    private LocalDate date;
    private Customer customer;
    private Vehicle vehicle;
}
