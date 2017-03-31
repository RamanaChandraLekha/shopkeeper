package com.shopkeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.main.Main;
//import com.product.DeleteProduct;
import com.product.Products;
//import com.product.RetrieveProductDetails;

public class ShopKeeperMenu {
	boolean flag = true;
	String choice;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public void display() {
		System.out.println("1.addProducts" + "\n" + "2.view products" + "\n" + "3.todelete a product"
				+ "\n"+"4.retrieve product details" + "\n" + "5.exit");

	}

	public void selectOption() throws IOException

	{
		Products products = new Products();

		while (flag) {
			display();
			System.out.println("enter the choice");
			choice = reader.readLine();

			switch (choice) {
			case "1":
				try {
					products.addToCart();
				} catch (Exception e) {
					System.out.println(e);
				}

				break;
			case "2":
				if(Main.shopKeeperList.values().isEmpty())
					
				{ 
					System.out.println("hi");
					System.out.println(Main.shopKeeperList.values());
					System.out.println("list is empty");
					flag=false;
					break;
				}
				
					System.out.println(Main.shopKeeperList);
				break;
			case "3":
               if(Main.shopKeeperList.values().isEmpty())
					
				{ 
					System.out.println(Main.shopKeeperList.values());
					System.out.println("list is empty");
					flag=false;
					break;
				}  
               
				try{
				products.deleteProduct();}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case "4":
                 if(Main.shopKeeperList.values().isEmpty())
					
				{ 
					System.out.println(Main.shopKeeperList.values());
					System.out.println("list is empty");
					flag=false;
					break;
				}  
				
				try{
					products.retrieveDetails();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				
				break;
			case "5":
				flag = false;
				break;
			default:
				System.out.println("enter the valid input");

			}

		}

	}
}
