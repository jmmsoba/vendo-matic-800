package com.techelevator.products;

public class Candy  extends Product {

    public Candy(String name, double price) {
        super(name, price);
    }   // Candy constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }        // Candy orders will output Munch Munch Yum!
}
