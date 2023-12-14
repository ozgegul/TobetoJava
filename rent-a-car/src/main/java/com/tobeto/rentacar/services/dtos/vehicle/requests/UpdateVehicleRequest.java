package com.tobeto.rentacar.services.dtos.vehicle.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleRequest {
    private int id;
    @NotNull(message = "Model cannot be empty.")
    private String model;
    @Min(value = 1, message = "License plate must be a positive integer.")
    private int licensePlate;
    @NotNull(message = "Company ID cannot be empty.")
    private int company_id;
}
