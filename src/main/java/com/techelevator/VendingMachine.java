package com.techelevator;

import com.techelevator.products.*;
import com.techelevator.view.VMLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private static BigDecimal balance = new BigDecimal("0.00");                                                             // balance variable to keep track of funds (will use later)
    Scanner input = new Scanner(System.in);
    private Map<String, Product> inventoryMap = new LinkedHashMap<>();

    public static BigDecimal getBalance() {
        return balance;
    }
    public Map<String, Product> getInventoryMap() { return inventoryMap; }

    public VendingMachine()  throws FileNotFoundException {
        this.inventoryMap = createInventory(getInputFile());
    }

    public File getInputFile() {                                                            // Gets the csv file and creates a File object
        File input = new File("vendingmachine.csv");
        if (!input.exists()) {                                                              // Confirms there IS a .csv file
            System.out.println("vendingmachine.csv does not exist.");
            System.exit(1);
        }
        else if (!input.isFile()) {                                                         // Confirms it is a valid file
            System.out.println("vendingmachine.csv is not a valid file.");
            System.exit(1);
        }
        return input;
    }

    public Map<String, Product> createInventory(File input)  throws FileNotFoundException {
//        Map<String, Product> inventoryMap = new LinkedHashMap<>();                        // Declares the inventory map we're about to make
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {                                                 // Runs through each line of the .csv file
                String line = scanner.nextLine();                                           // Saves the line as a String
                String[] value = line.split("\\|");                                   // Splits the line into an array of Strings at each "|"

                if (value[3].equals("Candy")) {                                             // Is the last index of the array "Candy"?
                    Product product = new Candy(value[1], new BigDecimal(value[2]));        // Construct a Candy object with the product name and price ("Moonpie", 1.80)
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier ("B1")
                }
                if(value[3].equals("Chip")) {                                               // Is the last index of the array "Chip"?
                    Product product = new Chip(value[1], new BigDecimal(value[2]));         // Construct a Chip object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
                if (value[3].equals("Drink")) {                                             // Is the last index of the array "Drink"?
                    Product product = new Drink(value[1], new BigDecimal(value[2]));        // Construct a Drink object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
                if (value[3].equals("Gum")) {                                               // Is the last index of the array "Gum"?
                    Product product = new Gum(value[1], new BigDecimal(value[2]));          // Construct a Gum object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
            }
        }
        catch (FileNotFoundException e) {                                                   // Catches an error in case getInputFile() fails
            System.out.println("Inventory file not found.");
        }
        return inventoryMap;
    }

    public void displayProducts(Map<String, Product> inventoryMap) {
        for (Map.Entry<String, Product> kvp : inventoryMap.entrySet() ) {
            if (kvp.getValue().getStock() == 0) {
                System.out.println(kvp.getKey() + " : " + kvp.getValue().getName() + "   SOLD OUT" );
            }
            else {
                System.out.println(kvp.getKey() + " : " + kvp.getValue().getName() + "   $" + kvp.getValue().getPrice());
            }
        }
    }

    public BigDecimal feedMoney(InputStream in, PrintStream out) {
        BigDecimal startBalance = getBalance();
        input = new Scanner(in);

        System.out.println("Please insert cash in whole dollar amounts:");
        String value = input.nextLine();

        while (!value.matches("^\\d*$") || value.isEmpty()) {
            System.out.println("Invalid input.\nPlease insert cash in whole dollar amounts:");
            value = input.nextLine();
        }

        int intMoney = Integer.parseInt(value);
        BigDecimal money = new BigDecimal(intMoney);
        balance = balance.add(money);
        System.out.println("Current Money Provided: $" + getBalance());

        VMLog.log("FEED MONEY", money, getBalance());
        return balance;
    }

    public void selectProduct(Map<String, Product> map) {
        BigDecimal startBalance = getBalance();
        displayProducts(map);

        System.out.println("Please enter a product code: ");
        String value = input.nextLine().toUpperCase();

        if (map.containsKey(value)) {
            if (map.get(value).getStock() == 0) {
                System.out.println(map.get(value).getName() + " is sold out.");
            }
            else if (map.get(value).getPrice().doubleValue() > balance.doubleValue()) {
                System.out.println("Insufficient funds.");
            }
            else {
                map.get(value).purchaseItem();
//                System.out.println("remaining stock: " + map.get(value).getStock());
                balance = balance.subtract(map.get(value).getPrice());
                System.out.println(map.get(value).getName() + "  $" + map.get(value).getPrice() + "  Remaining balance: $" + getBalance());
                map.get(value).getMessage();

                //totalSales = totalSales.add(map.get(value).getPrice();
                VMLog.log(map.get(value).getName() + " " + value, startBalance, getBalance());
            }
        }

        else System.out.println("Invalid input. Returning to Purchase menu.");
    }

    public void refundBalance() {
        final BigDecimal QUARTER = new BigDecimal("0.25");
        final BigDecimal DIME = new BigDecimal("0.10");
        final BigDecimal NICKEL = new BigDecimal("0.05");

        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;

        BigDecimal startBalance = getBalance();

        while (balance.doubleValue() >= QUARTER.doubleValue()) {
            balance = balance.subtract(QUARTER);
            quarterCounter++;
        }
        while (balance.doubleValue() >= DIME.doubleValue()) {
            balance = balance.subtract(DIME);
            dimeCounter++;
        }
        while (balance.doubleValue() >= NICKEL.doubleValue()) {
            balance = balance.subtract(NICKEL);
            nickelCounter++;
        }

        System.out.println("Change due: " + quarterCounter + " quarters, " + dimeCounter + " dimes, and " + nickelCounter + " nickels.");
        VMLog.log("GIVE CHANGE", startBalance, getBalance());
    }

//    public static void main(String[] args)   throws FileNotFoundException {
//        VendingMachine vend = new VendingMachine();
//        File input = vend.getInputFile();
//        vend.displayProducts(inventoryMap);
//    }
}
