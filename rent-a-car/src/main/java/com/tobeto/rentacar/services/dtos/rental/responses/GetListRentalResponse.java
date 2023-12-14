package com.tobeto.rentacar.services.dtos.rental.responses;

import com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private int id;
    private LocalDate date;
    private GetListCustomerResponse customer;
    private GetListVehicleResponse vehicle;
}
