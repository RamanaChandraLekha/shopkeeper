package com.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.main.Main;

public class CustomerChoice {
	boolean flag=true;
	String usersChoice;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void menu() {
		System.out.println("1.Available Products\n 2.products to buy \n "+"3.exit");
	}

	public void display() throws IOException {
		CustomerHelper item = new CustomerHelper();
		while (flag) {

			System.out.println("enter your choice");
             menu();
			usersChoice = br.readLine();

			switch (usersChoice.trim()) {
			case "1":

				System.out.println(Main.shopKeeperList);

				break;
			case "2":
				System.out.println(Main.shopKeeperList);
				// choice.requestForProducts();
				//addProduct();
				
				item.addProducts();
				System.out.println("Thanks for shopping..Visit again!");
						
				break;
			
			case "3":
                 
				flag = false;
				break;
			default:
				System.out.println("enter the valid input");

			}

		}
	}
}
