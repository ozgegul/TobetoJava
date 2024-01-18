package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Rental> rentals;
}
