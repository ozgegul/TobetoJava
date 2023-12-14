package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.repositories.VehicleRepository;
import com.tobeto.rentacar.services.abstracts.VehicleService;
import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleManager implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public void add(AddVehicleRequest addVehicleRequest){
        if(vehicleRepository.existsByModelLike(addVehicleRequest.getModel())){
            throw new RuntimeException("This is not a valid model");
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(addVehicleRequest.getModel());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(UpdateVehicleRequest updateVehicleRequest){
        if(!vehicleRepository.existsById(updateVehicleRequest.getId())){
            throw new RuntimeException("Invalid model!");
        }
        Vehicle vehicleToUpdate = vehicleRepository.findById(updateVehicleRequest.getId()).orElseThrow();
        vehicleToUpdate.setModel(updateVehicleRequest.getModel());
        vehicleToUpdate.setLicensePlate(updateVehicleRequest.getLicensePlate());
        vehicleRepository.save(vehicleToUpdate);
    }

    @Override
    public void delete(int id){
        if(vehicleRepository.existsById(id)){
            throw new RuntimeException("Invalid id!");
        }
        Vehicle vehicleToDelete = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with ID: " + id));
        vehicleRepository.delete(vehicleToDelete);
    }

    @Override
    public List<GetListVehicleResponse> findByModelAndCompanyName(String model, String name) {
        return vehicleRepository.findByModelAndCompanyName(model, name);
    }

    @Override
    public Vehicle getByModelLike(String model) {
        Vehicle vehicle = vehicleRepository.findByModelLike(model);

        if(vehicle == null){
            throw new EntityNotFoundException("Model not found");
        }

        return vehicle;
    }

    @Override
    public Vehicle getVehicleByLicensePlate(int licensePlate) {
        Vehicle vehicle = vehicleRepository.findVehicleByLicensePlate(licensePlate);
        if(vehicle == null){
            throw new EntityNotFoundException("Vehicle not found");
        }
        return vehicle;
    }
}
