package com.techelevator;

import com.techelevator.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {
    private double balance = 0;                                                             // balance variable to keep track of funds (will use later)

    public File getInputFile() {                                                            // Gets the csv file and creates a File object
        File inventoryFile = new File("vendingmachine.csv");
        if (!inventoryFile.exists()) {                                                      // Confirms there IS a .csv file
            System.out.println("vendingmachine.csv does not exist.");
            System.exit(1);
        }
        else if (!inventoryFile.isFile()) {                                                 // Confirms it is a valid file
            System.out.println("vendingmachine.csv is not a valid file.");
            System.exit(1);
        }
        return inventoryFile;
    }

    public Map<String, Product> createInventory()  throws FileNotFoundException {
        Map<String, Product> inventoryMap = new LinkedHashMap<>();                          // Declares the inventory map we're about to make
        File input = getInputFile();                                                        // Runs getInputFile() to get the .csv
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {                                                 // Runs through each line of the .csv file
                String line = scanner.nextLine();                                           // Saves the line as a String
                String[] value = line.split("|");                                     // Splits the line into an array of Strings at each "|"

                if (value[3].equals("Candy")) {                                             // Is the last index of the array "Candy"?
                    Product product = new Candy(value[1], Double.parseDouble(value[2]));    // Construct a Candy object with the product name and price ("Moonpie", 1.80)
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier ("B1")
                }
                if(value[3].equals("Chip")) {                                               // Is the last index of the array "Chip"?
                    Product product = new Chip(value[1], Double.parseDouble(value[2]));     // Construct a Chip object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
                if (value[3].equals("Drink")) {                                             // Is the last index of the array "Drink"?
                    Product product = new Drink(value[1], Double.parseDouble(value[2]));    // Construct a Drink object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
                if (value[4].equals("Gum")) {                                               // Is the last index of the array "Gum"?
                    Product product = new Gum(value[1], Double.parseDouble(value[2]));      // Construct a Gum object with the product name and price
                    inventoryMap.put(value[0], product);                                    // Adds the item to the inventoryMap at the key of its slot identifier
                }
            }
        }
        catch (FileNotFoundException e) {                                                   // Catches an error in case getInputFile() fails
            System.out.println("Inventory file not found.");
        }
        return inventoryMap;
    }
}
