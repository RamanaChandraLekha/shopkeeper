package com.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.main.Validation;
import com.product.Product;
import com.product.Products;

public class CustomerHelper {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Product> customersProducts;
	
	Scanner scan = new Scanner(System.in);

	public void addProducts() throws IOException {
		String product;
		int id;
		int quantity;
		String customerName;
		Customer customer;
		Products listOfProducts = new Products();
		String choice;
		CustomerProductValidation validation = new CustomerProductValidation();
		do {
			System.out.println("enter the id of the product");
			id = scan.nextInt();
			System.out.println("enter the quantity");
			quantity = scan.nextInt();
			int availabilty = validation.checkForProduct(id, quantity);
			if (availabilty != 0) {
				System.out.println("enter the product name");
				product = br.readLine();

				if (quantity <= availabilty) {
					Product prod = new Product(id, product, quantity);
					listOfProducts.addProductToList(prod);
					String shopkeeperId = validation.getShopkeeperId();
					Product productBought = validation.getProduct();
					validation.updatingProductList(shopkeeperId, productBought);

				} else
					System.out.print("out of stock");
			} else
				System.out.println("enter the correct id");

			System.out.println("do you want any other product");
			choice = new Validation().inputCheck();
		} while (choice.equalsIgnoreCase("yes"));
		if (choice.equalsIgnoreCase("no")) {
			System.out.println("enter your name");
			customerName = br.readLine();
			customer = new Customer(customerName, listOfProducts.products);
			System.out.println(customer);

		}

	}

}
