package com.techelevator;

import com.techelevator.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {
    private double balance = 0;                                                             // balance variable to keep track of funds (will use later)
    Scanner input = new Scanner(System.in);

//    private Map<String, Product> inventory = new LinkedHashMap<>();
//
//    public static void
//    private File input = new File("vendingmachine.csv");

    public double getBalance() {
        return balance;
    }
//    public Map<String, Product> getInventory() {
//        return inventory;
//    }
//    public void setInventory(Map<String, Product> inventory) {
//        this.inventory = createInventory(getInputFile());
//    }

//    private File inventory = getInputFile();

//    public VendingMachine() {
//        this.inventoryMap = createInventory(getInputFile());
//    }

//    VendingMachine vend = new VendingMachine();

    public File getInputFile() {                                                            // Gets the csv file and creates a File object
        File input = new File("vendingmachine.csv");
        if (!input.exists()) {                                                      // Confirms there IS a .csv file
            System.out.println("vendingmachine.csv does not exist.");
            System.exit(1);
        }
        else if (!input.isFile()) {                                                 // Confirms it is a valid file
            System.out.println("vendingmachine.csv is not a valid file.");
            System.exit(1);
        }
        return input;
    }

    public Map<String, Product> createInventory(File input)  throws FileNotFoundException {
        Map<String, Product> inventoryMap = new LinkedHashMap<>();                          // Declares the inventory map we're about to make
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {                                                 // Runs through each line of the .csv file
                String line = scanner.nextLine();                                           // Saves the line as a String
                String[] value = line.split("\\|");                                     // Splits the line into an array of Strings at each "|"
//                for (String v : value)

                if (value[3].equals("Candy")) {                                             // Is the last index of the array "Candy"?
                    Product product = new Candy(value[1], Double.parseDouble(value[2]));    // Construct a Candy object with the product name and price ("Moonpie", 1.80)
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier ("B1")
                    System.out.println("We found candy!");
                }
                if(value[3].equals("Chip")) {                                               // Is the last index of the array "Chip"?
                    Product product = new Chip(value[1], Double.parseDouble(value[2]));     // Construct a Chip object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                    System.out.println("We found chips!");
                }
                if (value[3].equals("Drink")) {                                             // Is the last index of the array "Drink"?
                    Product product = new Drink(value[1], Double.parseDouble(value[2]));    // Construct a Drink object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                    System.out.println("We found a drink!");
                }
                if (value[3].equals("Gum")) {                                               // Is the last index of the array "Gum"?
                    Product product = new Gum(value[1], Double.parseDouble(value[2]));      // Construct a Gum object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                    System.out.println("We found some gum!");
                }
            }
        }
        catch (FileNotFoundException e) {                                                   // Catches an error in case getInputFile() fails
            System.out.println("Inventory file not found.");
        }
        return inventoryMap;
    }

    public void displayProducts(Map<String, Product> inventoryMap)  throws FileNotFoundException {
//        Map<String, Product> inventoryMap = createInventory();
//        String[] productList = new String[inventoryMap.size()];
        for (Map.Entry<String, Product> kvp : inventoryMap.entrySet() ) {
            if (kvp.getValue().getStock() == 0) {
                System.out.println(kvp.getKey() + " : " + kvp.getValue().getName() + "   SOLD OUT" );
            }
            else {
                System.out.println(kvp.getKey() + " : " + kvp.getValue().getName() + "   $" + kvp.getValue().getPrice());
            }
        }
    }

    public double feedMoney() {
        System.out.println("Please insert cash in whole dollar amounts:");
        String value = input.nextLine();
        while (!value.matches("^\\d*$") || value.isEmpty()) {
            System.out.println("Invalid input.\nPlease insert cash in whole dollar amounts:");
            value = input.nextLine();
        }
        int money = Integer.parseInt(value);
        balance += money;
        return balance;
    }

    public void selectProduct(Map<String, Product> map)   throws FileNotFoundException {
        displayProducts(map);
        System.out.println("Please enter a product code: ");
        String value = input.nextLine();
        if (map.containsKey(value)) {
            if (map.get(value).getStock() == 0) {
                System.out.println(map.get(value).getName() + " is sold out.");
            }
            else if (map.get(value).getPrice() > balance) {
                System.out.println("Insufficient funds.");
            }
            else {
                map.get(value).purchaseItem();
                System.out.println("remaining stock: " + map.get(value).getStock());
                balance -= map.get(value).getPrice();
                System.out.println(map.get(value).getName() + "  $" + map.get(value).getPrice() + "  Remaining balance: $" + getBalance());
                map.get(value).getMessage();
            }
        }
        else System.out.println("Invalid input. Returning to Purchase menu.");
    }

//    public static void main(String[] args)   throws FileNotFoundException {
//        VendingMachine vend = new VendingMachine();
//        File input = vend.getInputFile();
//        vend.displayProducts(inventoryMap);
//    }
}
