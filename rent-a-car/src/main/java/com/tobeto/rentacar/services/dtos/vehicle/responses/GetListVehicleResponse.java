package com.tobeto.rentacar.services.dtos.vehicle.responses;

import com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListVehicleResponse {
    private int id;
    private String model;
    private int licensePlate;
    private GetListCompanyResponse company;
}
