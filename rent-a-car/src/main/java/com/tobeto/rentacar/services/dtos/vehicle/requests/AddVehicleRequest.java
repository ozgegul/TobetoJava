package com.tobeto.rentacar.services.dtos.vehicle.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVehicleRequest {
    @NotBlank
    private String model;
    private int licensePlate;
    private int company_id;
}
