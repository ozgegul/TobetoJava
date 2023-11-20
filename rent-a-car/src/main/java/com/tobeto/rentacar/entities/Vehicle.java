package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

// ORM => Object Relation Mapping
@Table(name = "vehicles")
@Entity
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

   @OneToMany(mappedBy = "vehicle")
   private List<Rental> rentals;

}
