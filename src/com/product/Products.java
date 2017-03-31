package com.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import com.main.Main;
import com.main.Validation;

public class Products {
	Scanner scan = new Scanner(System.in);
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public ArrayList<Product> products=new ArrayList<Product>();
	public void addProductToList(Product prod)
	{
		products.add(prod);
	}
	public void addToCart() throws IOException {
	int id = 0;
	String shopkeeperId;
	
	String choice = "no";
	String product;
	int quantity;


	ArrayList<Product> products=new ArrayList<Product>();
		System.out.println("enter shopkeeper id");
		shopkeeperId = scan.next();
	

	 do{
		System.out.println("enter the product");
		product = scan.next().toLowerCase().trim();
		if( Product.productWithId.containsKey(product))
		{
			id= Product.productWithId.get(product);
		}
		else
			id = id + 1;
		System.out.println("enter the quantity you want to enter");
		quantity = scan.nextInt();
		
		Product productObj = new Product(id, product, quantity);
		products.add(productObj);
         Product.productWithId.put(product,id);
		System.out.println("do you want to enter any product(yes/no)");
		choice = new Validation().inputCheck();
		if (choice.equalsIgnoreCase("no"))
			new Validation().checkForId(shopkeeperId, products);
	}while (choice.equalsIgnoreCase("yes"));

}
	public void deleteProduct() throws IOException {
		String shopkeeperId;
		int flag = 0;
		int productId;
		Product product;
		Collection<Product> productObjects;

		System.out.println("enter the shopkeepersid");
		shopkeeperId = reader.readLine();
		if (Main.shopKeeperList.containsKey(shopkeeperId)) {
			System.out.println("enter the id of products to delete ");
			productId = scan.nextInt();
			// System.out.println(productId);
			productObjects = Main.shopKeeperList.get(shopkeeperId);
			Iterator<Product> iterator = productObjects.iterator();
			while (iterator.hasNext()) {
				product = iterator.next();
				if (product.id == productId) {
					iterator.remove();
					flag = 1;
				}
			}
			if (flag == 0)
				System.out.println("such id is not present");

		} else
			System.out.println("shoppkeeperid is not valid");
	}

	public void retrieveDetails()
	{
		String shopkeeperId;
		int flag = 0;
		int productId;
		Product product;
		Collection<Product> productObjects;
		System.out.println("enter the shopkeepersid");
		shopkeeperId = scan.next();
		if (Main.shopKeeperList.containsKey(shopkeeperId)) {
			System.out.println("enter the id of products to get the details ");
			productId = scan.nextInt();
			// System.out.println(productId);
			productObjects = Main.shopKeeperList.get(shopkeeperId);
			Iterator<Product> iterator = productObjects.iterator();
			while (iterator.hasNext()) {
				product = iterator.next();
				if (product.id == productId) {
					System.out.println("id of the product is "+product.getId());
					System.out.println("name of the product is"+product.getProductName());
					System.out.println("quantity of the product is"+product.getQuantity());
					flag = 1;
				}
			}
			if (flag == 0)
				System.out.println("such id is not present");

		} else
			System.out.println("shoppkeeperid is not valid");
	}





	
}