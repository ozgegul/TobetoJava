package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer>
{
    @Query("SELECT new com.tobeto.rentacar.services.dtos.rental.responses.GetListRentalResponse(r.id, r.date)"
            + "FROM Rental r WHERE r.id = :id")
    List<GetListRentalResponse>findById(int id);
    List<GetListRentalResponse>findAllByOrderByIdDesc();

    boolean existsById(int id);
}
