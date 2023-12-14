package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rentacar.services.dtos.payment.responses.GetPaymentTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddPaymentRequest addPaymentRequest){
        paymentService.add(addPaymentRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdatePaymentRequest updatePaymentRequest){
        paymentService.update(updatePaymentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }

    @GetMapping("/findPaymentByPrice")
    public List<GetListPaymentResponse> findPaymentByPrice(){
        return paymentService.findPaymentByPrice();
    }

    @GetMapping("/findByPaymentTypeStartingWith")
    public GetPaymentTypeResponse findByPaymentTypeStartingWith(@RequestParam String paymentType){
        return paymentService.findByPaymentTypeStartingWith(paymentType);
    }
}
