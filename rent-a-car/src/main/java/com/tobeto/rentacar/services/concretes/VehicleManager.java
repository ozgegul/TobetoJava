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
    private final String errorMessage = "Invalid id";

    public VehicleManager(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void add(AddVehicleRequest addVehicleRequest){
        if(vehicleRepository.existsByModelLike(addVehicleRequest.getModel())){
            throw new RuntimeException("Invalid model");
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(addVehicleRequest.getModel());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(UpdateVehicleRequest updateVehicleRequest){
        if(!vehicleRepository.existsById(updateVehicleRequest.getId())){
            throw new RuntimeException(errorMessage);
        }
        Vehicle vehicleToUpdate = vehicleRepository.findById(updateVehicleRequest.getId()).orElseThrow();
        vehicleToUpdate.setModel(updateVehicleRequest.getModel());
        vehicleRepository.save(vehicleToUpdate);
    }

    @Override
    public void delete(int id){
        if(vehicleRepository.existsById(id)){
            throw new RuntimeException(errorMessage);
        }
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.delete(vehicleToDelete);
    }

    @Override
    public Vehicle findByModelLike(String model){
        return vehicleRepository.findByModelLike(model);
    }
}
