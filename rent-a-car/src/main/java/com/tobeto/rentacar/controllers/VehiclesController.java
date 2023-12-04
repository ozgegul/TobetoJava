package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.services.abstracts.VehicleService;
import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {
    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public void add(@RequestBody AddVehicleRequest addVehicleRequest){
        vehicleService.add(addVehicleRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        vehicleService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdateVehicleRequest updateVehicleRequest){
        vehicleService.update(updateVehicleRequest);
    }

    @GetMapping
    public Vehicle findByModelLike(@RequestParam String model){
        return vehicleService.findByModelLike(model);
    }
}
