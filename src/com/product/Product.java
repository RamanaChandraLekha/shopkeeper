package com.product;
import java.util.HashMap;

public class Product {
	static HashMap<String, Integer> productWithId = new HashMap<String, Integer>();
	public String productName;
	public int quantity;
	public int id;

	String shopKeeperId;

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(int id, String productName, int quantity) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;

	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString() {
		return " id:"+ id + "[" + productName + "=" + quantity + "]";
	}

}
