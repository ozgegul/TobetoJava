package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

// Generic
// Generic Type, Reference Type olarak belirtilmelidir.
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>
{
    Vehicle findByModelLike(String model);
}
