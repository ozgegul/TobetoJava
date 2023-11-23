package com.tobeto.rentacar.services.dtos.rental.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddRentalRequest {
    private LocalDate date;
}
