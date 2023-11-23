package com.tobeto.rentacar.services.dtos.payment.requests;

import lombok.Data;

@Data
public class AddPaymentRequest {
    private String paymentType;
    private int cardNo;
    private int price;
}
