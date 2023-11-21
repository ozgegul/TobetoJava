package com.tobeto.rentacar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "payments")
@Entity
@Getter
@Setter
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "card_no")
    private int cardNo;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
