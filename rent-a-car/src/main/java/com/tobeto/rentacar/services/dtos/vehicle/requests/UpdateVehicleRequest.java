package com.tobeto.rentacar.services.dtos.vehicle.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateVehicleRequest {
    private int id;
    @NotBlank(message = "Model cannot be empty")
    private String model;
    private int license_plate;
}
