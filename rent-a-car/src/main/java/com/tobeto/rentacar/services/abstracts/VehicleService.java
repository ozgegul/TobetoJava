package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;

public interface VehicleService {
    void add(AddVehicleRequest addVehicleRequest);
    void update(UpdateVehicleRequest updateVehicleRequest);
    void delete(int id);
}
