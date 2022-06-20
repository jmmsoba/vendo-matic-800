package com.techelevator;

import com.techelevator.products.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Before
    public void setUp() throws FileNotFoundException {
    }

    @Test
    public void get_Balance_Test() throws FileNotFoundException {
        VendingMachine vendingMachineTest = new VendingMachine();
        BigDecimal expected = BigDecimal.valueOf(0);
        //you can't call a method without creating an object (unless it's a static)
        assertEquals(expected, vendingMachineTest.getBalance());
    }

    @Test
    public void get_Input_File_Test() {
        File expectedInputFile = new File("vendingmachine.csv");
        assertTrue(expectedInputFile.exists());
        assertFalse(!expectedInputFile.exists());
    }

    @Test
    public void create_Inventory_Test() throws FileNotFoundException {
        VendingMachine vendingMachineTest = new VendingMachine();

        Map<String, Product> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", (Product) new Chip("Potato Crisps", new BigDecimal("3.05")));
        expectedMap.put("A2", (Product) new Chip("Stackers", new BigDecimal("1.45")));
        expectedMap.put("A3", (Product) new Chip("Grain Waves",  new BigDecimal("2.75")));
        expectedMap.put("A4", (Product) new Chip("Cloud Popcorn",  new BigDecimal("3.65")));

        expectedMap.put("B1", (Product) new Candy("Moonpie", new BigDecimal("1.80")));
        expectedMap.put("B2", (Product) new Candy("Cowtales", new BigDecimal("1.50")));
        expectedMap.put("B3", (Product) new Candy("Wonka Bar",new BigDecimal("1.50")));
        expectedMap.put("B4", (Product) new Candy("Crunchie",  new BigDecimal("1.75")));

        expectedMap.put("C1", (Product) new Drink("Cola",  new BigDecimal("1.25")));
        expectedMap.put("C2", (Product) new Drink("Dr. Salt",new BigDecimal("1.50")));
        expectedMap.put("C3", (Product) new Drink("Mountain Melter",new BigDecimal("1.50")));
        expectedMap.put("C4", (Product) new Drink("Heavy",new BigDecimal("1.50")));

        expectedMap.put("D1", (Product) new Gum("U-Chews", new BigDecimal("0.85")));
        expectedMap.put("D2", (Product) new Gum("Little League Chew", new BigDecimal("0.95")));
        expectedMap.put("D3", (Product) new Gum("Chiclets",  new BigDecimal("0.75")));
        expectedMap.put("D4", (Product) new Gum("Triplemint",  new BigDecimal("0.75")));

        Map<String, Product> actualMap =  vendingMachineTest.createInventory(vendingMachineTest.getInputFile());
        for(String key :actualMap.keySet()){
            Product expectedProduct = expectedMap.get(key);
            Product actualProduct = actualMap.get(key);
            assertEquals(expectedProduct.getName(), actualProduct.getName());
            assertEquals(expectedProduct.getPrice(), actualProduct.getPrice());
        }

    }

    @Test
    public void feed_Money_Test() throws FileNotFoundException {
        VendingMachine vendingMachineTest = new VendingMachine();

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
        BigDecimal actual = vendingMachineTest.feedMoney(in, System.out);
        System.setIn(in);

        BigDecimal expectedInputValue = new BigDecimal("10");
        assertEquals(expectedInputValue,actual);
    }
}