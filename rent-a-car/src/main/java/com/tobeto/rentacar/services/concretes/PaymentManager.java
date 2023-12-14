package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.repositories.PaymentRepository;
import com.tobeto.rentacar.services.abstracts.PaymentService;
import com.tobeto.rentacar.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rentacar.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rentacar.services.dtos.payment.responses.GetPaymentTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public void add(AddPaymentRequest addPaymentRequest){
        Payment payment = new Payment();
        payment.setPaymentType(addPaymentRequest.getPaymentType());
        payment.setCustomer(addPaymentRequest.getCustomer());
        paymentRepository.save(payment);
    }

    @Override
    public void update(UpdatePaymentRequest updatePaymentRequest){
        if(paymentRepository.existsPaymentByPrice(updatePaymentRequest.getPrice())){
            throw new RuntimeException("Price cannot be empty.");
        }
        Payment paymentToUpdate = paymentRepository.findById(updatePaymentRequest.getId()).orElseThrow();
        paymentToUpdate.setPaymentType((updatePaymentRequest.getPaymentType()));
        paymentRepository.save(paymentToUpdate);
    }

    @Override
    public void delete(int id){
        if(!paymentRepository.existsById(id)){
            throw new RuntimeException("Invalid id");
        }
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @Override
    public List<GetListPaymentResponse> findPaymentByPrice(){
        return paymentRepository.findPaymentByPrice();
    }

    @Override
    public GetPaymentTypeResponse findByPaymentTypeStartingWith(String paymentType) {
        return paymentRepository.findByPaymentTypeStartingWith(paymentType);
    }
}
