package com.techelevator.products;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {
    Product drinkC1 = new Drink ("Cola", new BigDecimal("1.25"));
    Product drinkC2 = new Drink ("Dr. Salt", new BigDecimal("1.50"));
    Product drinkC3 = new Drink ("Mountain Melter", new BigDecimal("1.50"));
    Product drinkC4 = new Drink ("Heavy", new BigDecimal("1.50"));

    @Test
    public void get_Message_Test() {
        assertEquals("Glug Glug, Yum!", drinkC1.getMessage());
        assertEquals("Glug Glug, Yum!", drinkC2.getMessage());
        assertEquals("Glug Glug, Yum!", drinkC3.getMessage());
        assertEquals("Glug Glug, Yum!", drinkC4.getMessage());
    }

    @Test
    public void get_Name_Test() {
        assertEquals("Cola", drinkC1.getName());
        assertEquals("Dr. Salt", drinkC2.getName());
        assertEquals("Mountain Melter", drinkC3.getName());
        assertEquals("Heavy", drinkC4.getName());
    }

    @Test
    public void get_Price_Test() {
        assertEquals(new BigDecimal("1.25"), drinkC1.getPrice());
        assertEquals(new BigDecimal("1.50"), drinkC2.getPrice());
        assertEquals(new BigDecimal("1.50"), drinkC3.getPrice());
        assertEquals(new BigDecimal("1.50"), drinkC4.getPrice());

    }

}