package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rentacar.services.dtos.payment.responses.GetPaymentTypeResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentRequest addPaymentRequest){
        paymentService.add(addPaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@RequestBody @Valid UpdatePaymentRequest updatePaymentRequest){
        paymentService.update(updatePaymentRequest);
    }

    @GetMapping("dto")
    public List<GetListPaymentResponse> findPaymentByPrice(){
        return paymentService.findPaymentByPrice();
    }

    @GetMapping
    public GetPaymentTypeResponse findByPaymentTypeStartingWith(@RequestParam String paymentType){
        return paymentService.findByPaymentTypeStartingWith(paymentType);
    }
}
