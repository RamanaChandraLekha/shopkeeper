package com.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.product.Product;


public class Validation {
	
	String choice,choice1;
	ArrayList<Product>products;
	BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	public String inputCheck() throws IOException {

		String choice1 = read.readLine();
		do{
		switch (choice1) {
		case "yes":
		choice = choice1;
		break;
		case "no":choice=choice1;
		break;
		default:
		System.out.println("enter valid input(yes/no)");
		choice = read.readLine();
		break;
		}}while(!(choice.equalsIgnoreCase("yes"))&&!(choice.equalsIgnoreCase("no")));

		return choice;
		}
	public void checkForId(String shopkeeperId, ArrayList<Product> productsOfList)
	{
		if(Main.shopKeeperList.containsKey(shopkeeperId))
		{
			
			products=Main.shopKeeperList.get(shopkeeperId);
			products.addAll(productsOfList);
			Main.shopKeeperList.put(shopkeeperId,products);
		}
		else
		Main.shopKeeperList.put(shopkeeperId,productsOfList);
	}
	
	
}

