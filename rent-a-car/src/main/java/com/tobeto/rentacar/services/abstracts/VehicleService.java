package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse;

import java.util.List;

public interface VehicleService {
    void add(AddVehicleRequest addVehicleRequest);
    void update(UpdateVehicleRequest updateVehicleRequest);
    void delete(int id);

    List<GetListVehicleResponse> findByModelAndCompanyName(String model, String companyName);
    Vehicle getByModelLike(String model);
    Vehicle getVehicleByLicensePlate(int licensePlate);
}
