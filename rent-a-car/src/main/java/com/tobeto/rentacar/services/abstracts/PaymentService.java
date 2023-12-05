package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rentacar.services.dtos.payment.responses.GetPaymentTypeResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest addPaymentRequest);
    void update(UpdatePaymentRequest updatePaymentRequest);
    void delete(int id);

    List<GetListPaymentResponse> findPaymentByPrice();

    GetPaymentTypeResponse findByPaymentTypeStartingWith(String paymentType);
}
