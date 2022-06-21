package com.techelevator.products;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class GumTest {
    Product gumD1 = new Gum("U-Chews", new BigDecimal("0.85"));
    Product gumD2 = new Gum("Little League Chew", new BigDecimal("0.95"));
    Product gumD3 = new Gum("Chiclets", new BigDecimal("0.75"));
    Product gumD4 = new Gum("Triplemint", new BigDecimal("0.75"));

    @Test
    public void get_Message_Test() {
        assertEquals("Chew Chew, Yum!", gumD1.getMessage());
        assertEquals("Chew Chew, Yum!", gumD2.getMessage());
        assertEquals("Chew Chew, Yum!", gumD3.getMessage());
        assertEquals("Chew Chew, Yum!", gumD4.getMessage());
    }

    @Test
    public void get_Name_Test() {
        assertEquals("U-Chews", gumD1.getName());
        assertEquals("Little League Chew", gumD2.getName());
        assertEquals("Chiclets", gumD3.getName());
        assertEquals("Triplemint", gumD4.getName());

    }

    @Test
    public void get_Price_Test() {
        assertEquals(new BigDecimal("0.85"), gumD1.getPrice());
        assertEquals(new BigDecimal("0.95"), gumD2.getPrice());
        assertEquals(new BigDecimal("0.75"), gumD3.getPrice());
        assertEquals(new BigDecimal("0.75"), gumD4.getPrice());

    }

    }