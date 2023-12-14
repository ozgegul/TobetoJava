package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Vehicle;
import com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>
{
    @Query("SELECT com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse" +
            "(v.id, v.model, v.licensePlate, com.tobeto.rentacar.services.dtos.company.responses.GetListCompanyResponse(c.id, c.name))" +
            "FROM Vehicle v INNER JOIN v.company c WHERE v.model = :model AND c.name = :name")
    List<GetListVehicleResponse> findByModelAndCompanyName(String model, String name);
    Vehicle findVehicleByLicensePlate(int licensePlate);
    Vehicle findByModelLike(String model);
    boolean existsByModelLike(String model);
}
