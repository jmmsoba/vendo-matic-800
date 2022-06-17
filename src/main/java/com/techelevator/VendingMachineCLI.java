package com.techelevator;

import com.techelevator.products.Product;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";			// Purchase menu options
	private static final String PURCHASE_MENU_SELECT = "Select Product";			// Purchase menu options
	private static final String PURCHASE_MENU_FINISH = "Finish Transaction";		// Purchase menu options
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT, PURCHASE_MENU_FINISH};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run()  throws FileNotFoundException {
		VendingMachine vendomatic = new VendingMachine();
//		Map<String, Product> productMap = vendomatic.createInventory(vendomatic.getInputFile());

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendomatic.displayProducts(vendomatic.getInventoryMap());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
						vendomatic.feedMoney();
					} else if (choice.equals(PURCHASE_MENU_SELECT)) {
						vendomatic.selectProduct(vendomatic.getInventoryMap());
					} else if (choice.equals(PURCHASE_MENU_FINISH)) {
						vendomatic.refundBalance();
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(1); // exit
			}
		}
	}

	public static void main(String[] args)  throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
