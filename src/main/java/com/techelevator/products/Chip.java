package com.techelevator.products;

import java.math.BigDecimal;

public class Chip  extends Product {

    public Chip(String name, BigDecimal price) {
        super(name, price);
    }   // Chip constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }     // Chip orders will output Crunch Crunch Yum!

}
