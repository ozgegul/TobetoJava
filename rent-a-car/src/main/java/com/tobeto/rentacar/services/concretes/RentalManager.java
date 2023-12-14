package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;

    @Override
    public void add(AddRentalRequest addRentalRequest){
        Rental rental = new Rental();
        rental.setDate(addRentalRequest.getDate());
        rental.setCustomer(addRentalRequest.getCustomer());
        rental.setVehicle(addRentalRequest.getVehicle());
        rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest){
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setDate(updateRentalRequest.getDate());
        rentalRepository.save(rentalToUpdate);
    }

    @Override
    public void delete(int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public GetByIdRentalResponse getById(int id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        GetByIdRentalResponse getByIdRentalResponse = new GetByIdRentalResponse();
        getByIdRentalResponse.setDate(rental.getDate());
        getByIdRentalResponse.setCustomer(rental.getCustomer());
        getByIdRentalResponse.setVehicle(rental.getVehicle());
        return getByIdRentalResponse;
    }

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<GetAllRentalsResponse> getAllRentalsResponseList = new ArrayList<>();
        for (Rental rental : rentals) {
            GetAllRentalsResponse getAllRentalsResponse = new GetAllRentalsResponse();
            getAllRentalsResponse.setId(rental.getId());
            getAllRentalsResponse.setDate(rental.getDate());
            getAllRentalsResponse.setCustomer(rental.getCustomer());
            getAllRentalsResponse.setVehicle(rental.getVehicle());
            getAllRentalsResponseList.add(getAllRentalsResponse);
        }
        return getAllRentalsResponseList;
    }

    @Override
    public Rental getByDate(LocalDate date){
        return rentalRepository.findByDate(date);
    }

    @Override
    public List<Rental> getByOrderByCustomerDesc(){
        return rentalRepository.findByOrderByCustomerDesc();
    }

    @Override
    public List<GetListRentalResponse> getByCustomerNameAndVehicleModel(String customer, String vehicle){
        return rentalRepository.findByCustomerNameAndVehicleModel(customer, vehicle);
    }
}
