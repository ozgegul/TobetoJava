package com.tobeto.rentacar.services.dtos.payment.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddPaymentRequest {
    @NotBlank(message = "Payment type cannot be empty.")
    private String paymentType;
    private int cardNo;
    private int price;
}
