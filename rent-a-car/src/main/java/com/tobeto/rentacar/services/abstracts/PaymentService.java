package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;

public interface PaymentService {
    void add(AddPaymentRequest addPaymentRequest);
    void update(UpdatePaymentRequest updatePaymentRequest);
    void delete(int id);
}
