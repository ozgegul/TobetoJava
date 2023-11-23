package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest addPaymentRequest){
        paymentService.add(addPaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentRequest updatePaymentRequest){
        paymentService.update(updatePaymentRequest);
    }
}
