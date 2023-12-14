package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer>
{
    List<Rental> findByOrderByCustomerDesc();

    @Query("SELECT r FROM Rental r Where r.date = :date")
    Rental findByDate(LocalDate date);

    @Query("SELECT new com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse" +
            "(r.id, r.date, new com.tobeto.rentacar.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.name), " +
            " new com.tobeto.rentacar.services.dtos.vehicle.responses.GetListVehicleResponse(v.id, v.model)) " +
            "FROM Rental r " +
            "INNER JOIN r.customer c " +
            "INNER JOIN r.vehicle v " +
            "WHERE c.name = :customer AND v.model = :vehicle")
    List<GetListRentalResponse> findByCustomerNameAndVehicleModel(String customer, String vehicle);
}
