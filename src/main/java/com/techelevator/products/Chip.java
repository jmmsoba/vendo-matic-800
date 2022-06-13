package com.techelevator.products;

public class Chip  extends Product {

    public Chip(String name, double price) {
        super(name, price);
    }   // Chip constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }     // Chip orders will output Crunch Crunch Yum!

}
