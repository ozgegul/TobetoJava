package com.tobeto.rentacar.services.dtos.payment.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPaymentResponse {
    private int id;
    private int price;
    private String paymentType;
}
