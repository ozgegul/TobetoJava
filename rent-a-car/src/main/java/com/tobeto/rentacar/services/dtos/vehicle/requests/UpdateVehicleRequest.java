package com.tobeto.rentacar.services.dtos.vehicle.requests;

import lombok.Data;

@Data
public class UpdateVehicleRequest {
    private int id;
    private String model;
    private int license_plate;
}
