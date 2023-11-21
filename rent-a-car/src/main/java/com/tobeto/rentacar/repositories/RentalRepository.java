package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer>
{

}
