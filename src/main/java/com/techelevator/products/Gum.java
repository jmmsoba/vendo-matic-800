package com.techelevator.products;

import java.math.BigDecimal;

public class Gum  extends Product {

    public Gum(String name, BigDecimal price) {
        super(name, price);
    }   // Gum constructor using the Product constructor

    @Override
    public String getMessage() {
        return "Chew Chew, Yum!";
    }        // Gum orders will output Chew Chew Yum!

}
