package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// ORM => Object Relation Mapping
@Table(name = "vehicles")
@Entity
@Getter
@Setter
public class Vehicle
{
   @Id
   @Column(name = "id") // name = kolon_adı
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id; // classın içindeki alanın adı

   @Column(name = "model")
   private String model;

   @Column(name = "license_plate")
   private int licensePlate;

   @ManyToOne
   @JoinColumn(name="company_id")
   private Company company;

   // Sonsuz döngüden kaçınmak için listeleri JSON'da göstermiyoruz.
   // JSON Infinite Recursion
   @OneToMany(mappedBy = "vehicle")
   @JsonIgnore
   private List<Rental> rentals;

}
