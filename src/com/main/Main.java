package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.customer.CustomerChoice;
import com.product.Product;
import com.shopkeeper.ShopKeeperMenu;

public class Main {

	public static HashMap<String, ArrayList<Product>> shopKeeperList = new HashMap<String, ArrayList<Product>>();

	public static void main(String[] args) throws IOException {
		String choice;
		boolean flag = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (flag) {
			System.out.println("1.Shopkeeper" + "\n" + "2.Customer"+"\n"+"3.exit");
			System.out.println("enter the choice");
			choice = reader.readLine();

			switch (choice) {
			case "1":

				ShopKeeperMenu menu = new ShopKeeperMenu();

				menu.selectOption();

				break;
			case "2":
               CustomerChoice customer = new CustomerChoice();
               customer.display();
				break;
			case "3":
				System.exit(0);

			default:
				System.out.println("enter the valid input");

			}

		}
	}
}
