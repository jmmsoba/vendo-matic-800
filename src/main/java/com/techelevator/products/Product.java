package com.techelevator.products;

import java.math.BigDecimal;

public abstract class Product {                         // Abstract class will be implemented by the child classes
    private String name;
    private BigDecimal price;
    private int stock = 5;                              // Each item is restocked to 5 on start

    public Product(String name, BigDecimal price) {         // Product constructor
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }            // Product getters
    public BigDecimal getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    public boolean isAvailable() {                      // If the stock is greater than 0, stock is available
        return this.stock > 0;
    }

    public void purchaseItem() {
        if (getStock() > 0) { stock--; }  }             // When an item is purchased, reduce stock by 1

    public abstract String getMessage();                // Abstract method will be defined by each specific class
}