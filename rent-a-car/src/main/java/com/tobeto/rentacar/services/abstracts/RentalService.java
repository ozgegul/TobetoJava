package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.rental.requests.UpdateRentalRequest;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);
    void update(UpdateRentalRequest updateRentalRequest);
    void delete(int id);
}
