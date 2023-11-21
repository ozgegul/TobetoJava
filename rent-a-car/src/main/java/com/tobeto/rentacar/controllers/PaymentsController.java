package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    // update
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Payment payment){
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setPaymentType(payment.getPaymentType());
        paymentToUpdate.setCardNo(payment.getCardNo());
        paymentToUpdate.setPrice(payment.getPrice());
        paymentToUpdate.setCustomer(payment.getCustomer());
        paymentRepository.save(paymentToUpdate);
    }
}
