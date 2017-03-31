package com.customer;

import java.util.ArrayList;

import com.product.Product;

public class Customer {
	String customerName;
	
	ArrayList<Product> products;
  Customer( String name,ArrayList<Product>products) {
	  
		customerName=name;
		this.products=products;
	}

  public String getCustomerName() {
		return customerName;
	}
  public String toString()
  {
	  return customerName +"\n"+products.toString();
  }
}
