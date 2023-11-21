package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.repositories.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {
    // final => Sadece ctor'da ilgili değerin ataması yapılabilir.
    private final VehicleRepository vehicleRepository;

    public VehiclesController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    // Dependency Injection


    @GetMapping
    public List<Vehicle> getAll(){
        // findAll => Hazır bir JPArepository fonksiyonu.
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    @GetMapping("{id}")
    public Vehicle getById(@PathVariable int id){
        // Optional => Opsiyonel olarak Vehicle
        // Verilen id ile bir veri varsa onu dön, yoksa exception fırlat.
        return vehicleRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow();
        // Exception fırlatması = bu satırın çalışmaması.
        vehicleRepository.delete(vehicleToDelete);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Vehicle vehicle){
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).orElseThrow();
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setLicensePlate(vehicle.getLicensePlate());
        vehicleToUpdate.setCompany(vehicle.getCompany());
        vehicleToUpdate.setRentals(vehicle.getRentals());
        vehicleRepository.save(vehicleToUpdate);
    }
}
