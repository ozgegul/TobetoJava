package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public GetByIdRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalsResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/getByDate")
    public Rental getByDate(@RequestParam LocalDate date){
        return rentalService.getByDate(date);
    }

    @GetMapping("/getByOrderByCustomerDesc")
    public List<Rental> getByOrderByCustomerDesc(){
        return rentalService.getByOrderByCustomerDesc();
    }

    @GetMapping("/getByCustomerNameAndVehicleModel")
    public List<GetListRentalResponse> getByCustomerNameAndVehicleModel(@RequestParam String customer, @RequestParam String vehicle){
        return rentalService.getByCustomerNameAndVehicleModel(customer,vehicle);
    }
}
