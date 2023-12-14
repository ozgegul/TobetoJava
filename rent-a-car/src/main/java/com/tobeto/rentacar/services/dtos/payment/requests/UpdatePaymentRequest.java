package com.tobeto.rentacar.services.dtos.payment.requests;

import com.tobeto.rentacar.entities.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private int id;
    private String paymentType;
    private int cardNo;
    @NotNull(message = "Price cannot be empty.")
    private int price;
    private Customer customer;
}
