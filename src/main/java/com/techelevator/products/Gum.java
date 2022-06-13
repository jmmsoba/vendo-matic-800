package com.techelevator.products;

public class Gum  extends Product {

    public Gum(String name, double price) {
        super(name, price);
    }   // Gum constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Chew Chew, Yum!";
    }        // Gum orders will output Chew Chew Yum!

}
