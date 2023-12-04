package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.repositories.VehicleRepository;
import com.tobeto.rentacar.services.abstracts.VehicleService;
import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;
import org.springframework.stereotype.Service;

@Service
public class VehicleManager implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleManager(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void add(AddVehicleRequest addVehicleRequest){
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(addVehicleRequest.getModel());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(UpdateVehicleRequest updateVehicleRequest){
        Vehicle vehicleToUpdate = vehicleRepository.findById(updateVehicleRequest.getId()).orElseThrow();
        vehicleToUpdate.setModel(updateVehicleRequest.getModel());
        vehicleRepository.save(vehicleToUpdate);
    }

    @Override
    public void delete(int id){
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.delete(vehicleToDelete);
    }

    @Override
    public Vehicle findByModelLike(String model){
        return vehicleRepository.findByModelLike(model);
    }
}
