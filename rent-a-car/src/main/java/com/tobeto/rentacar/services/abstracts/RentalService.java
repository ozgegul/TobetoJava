package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;

import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);
    void update(UpdateRentalRequest updateRentalRequest);
    void delete(int id);

    GetByIdRentalResponse getById(int id);
    List<GetAllRentalsResponse> getAll();
    Rental getByDate(LocalDate date);
    List<Rental> getByOrderByCustomerDesc();
    List<GetListRentalResponse> getByCustomerNameAndVehicleModel(String customer, String vehicle);
}
