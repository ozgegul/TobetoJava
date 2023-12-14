package com.tobeto.rentacar.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    @NotNull(message = "Id cannot be empty")
    private int id;
    @NotNull(message = "Date cannot be empty")
    private LocalDate date;
}
