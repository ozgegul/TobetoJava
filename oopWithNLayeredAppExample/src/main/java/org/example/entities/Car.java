package org.example.entities;

public class Car { // Class Definition
    private String brand;
    private String model;
    private String color;
    private String gearType;
    private double price;

    public Car(String brand, String model, String color, double price){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        gearType = "automatic";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

