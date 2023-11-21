package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

}
