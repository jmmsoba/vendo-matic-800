package com.techelevator.products;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ChipTest {
    Product chipA1 = new Chip ("Potato Crisps", new BigDecimal("3.05"));
    Product chipA2 = new Chip ("Stackers", new BigDecimal(("1.45")));
    Product chipA3 = new Chip ("Grain Waves", new BigDecimal("2.75"));
    Product chipA4 = new Chip ("Cloud Popcorn", new BigDecimal("3.65"));


    @Test
    public void get_Message_Test() {
        assertEquals("Crunch Crunch, Yum!", chipA1.getMessage());
        assertEquals("Crunch Crunch, Yum!", chipA2.getMessage());
        assertEquals("Crunch Crunch, Yum!", chipA3.getMessage());
        assertEquals("Crunch Crunch, Yum!", chipA4.getMessage());
    }

    @Test
    public void get_Name_Test() {
        assertEquals("Potato Crisps", chipA1.getName());
        assertEquals("Stackers", chipA2.getName());
        assertEquals("Grain Waves", chipA3.getName());
        assertEquals("Cloud Popcorn", chipA4.getName());
    }

    @Test
    public void get_Price_Test() {
        assertEquals(new BigDecimal("3.05"), chipA1.getPrice());
        assertEquals(new BigDecimal("1.45"), chipA2.getPrice());
        assertEquals(new BigDecimal("2.75"), chipA3.getPrice());
        assertEquals(new BigDecimal("3.65"), chipA4.getPrice());

    }

}