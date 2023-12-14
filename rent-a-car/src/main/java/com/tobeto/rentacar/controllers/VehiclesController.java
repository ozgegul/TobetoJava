package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.services.abstracts.VehicleService;
import com.tobeto.rentacar.services.dtos.vehicle.requests.AddVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.requests.UpdateVehicleRequest;
import com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
@AllArgsConstructor
public class VehiclesController {
    private final VehicleService vehicleService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddVehicleRequest addVehicleRequest){
        vehicleService.add(addVehicleRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateVehicleRequest updateVehicleRequest){
        vehicleService.update(updateVehicleRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        vehicleService.delete(id);
    }

    @GetMapping("/getByModelAndCompanyName")
    public List<GetListVehicleResponse> getByModelAndCompanyName(@RequestParam String model, @RequestParam String name){
        return vehicleService.findByModelAndCompanyName(model, name);
    }

    @GetMapping("/getByModelLike")
    public Vehicle getByModelLike(@RequestParam String model){
        return vehicleService.getByModelLike(model);
    }

    @GetMapping("/getVehicleByLicensePlate")
    public Vehicle getVehicleByLicensePlate(@RequestParam int licensePlate){
        return vehicleService.getVehicleByLicensePlate(licensePlate);
    }
}
