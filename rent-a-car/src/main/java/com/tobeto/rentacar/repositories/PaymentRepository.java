package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rentacar.services.dtos.payment.responses.GetPaymentTypeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
    @Query("SELECT new com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse(p.id,p.price,p.paymentType)"
            + "FROM Payment p WHERE p.price > 500")
    List<GetListPaymentResponse> findPaymentByPrice();
    GetPaymentTypeResponse findByPaymentTypeStartingWith(String paymentType);

    boolean existsByPaymentTypeStartingWith(String paymentType);
}
