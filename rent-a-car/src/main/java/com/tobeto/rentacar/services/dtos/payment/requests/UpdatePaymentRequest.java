package com.tobeto.rentacar.services.dtos.payment.requests;

import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private int id;
    private String paymentType;
    private int cardNo;
    private String price;
}
