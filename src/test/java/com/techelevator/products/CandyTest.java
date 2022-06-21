package com.techelevator.products;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {
    Product candyB1 = new Candy ("Moonpie", new BigDecimal("1.80"));
    Product candyB2 = new Candy ("Cowtales", new BigDecimal(("1.50")));
    Product candyB3 = new Candy ("Wonka Bar", new BigDecimal("1.50"));
    Product candyB4 = new Candy ("Crunchie", new BigDecimal("1.75"));


    @Test
    void get_Message_Test() {
        assertEquals("Munch Munch, Yum!", candyB1.getMessage());
        assertEquals("Munch Munch, Yum!", candyB2.getMessage());
        assertEquals("Munch Munch, Yum!", candyB3.getMessage());
        assertEquals("Munch Munch, Yum!", candyB4.getMessage());
    }

    @Test
    void get_Name_Test() {
        assertEquals("Moonpie", candyB1.getName());
        assertEquals("Cowtales", candyB2.getName());
        assertEquals("Wonka Bar", candyB3.getName());
        assertEquals("Crunchie", candyB4.getName());
    }

    @Test
    void get_Price_Test() {
        assertEquals(new BigDecimal("1.80"), candyB1.getPrice());
        assertEquals(new BigDecimal("1.50"), candyB2.getPrice());
        assertEquals(new BigDecimal("1.50"), candyB3.getPrice());
        assertEquals(new BigDecimal("1.75"), candyB4.getPrice());
    }




}