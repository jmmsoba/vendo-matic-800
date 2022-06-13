package com.techelevator.products;

public class Drink  extends Product {

    public Drink(String name, double price) {
        super(name, price);
    }   // Drink constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Glug Glug, Yum!";
    }          // Drink orders will output Glug Glug Yum!

}
