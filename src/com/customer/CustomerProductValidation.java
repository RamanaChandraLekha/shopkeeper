package com.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.main.Main;
import com.product.Product;

public class CustomerProductValidation {
	Collection<ArrayList<Product>> productObjs;
	
	Product prod;
	int quantity = 0;
	String shopkeeperId;
	int requiredQuantity;
	ArrayList<Product> productsList;

	public int checkForProduct(int id, int quantity) {
		boolean flag = false;
		
		requiredQuantity = quantity;
		Set<Map.Entry<String, ArrayList<Product>>> productsSet = Main.shopKeeperList.entrySet();
		Iterator iter = productsSet.iterator();
		while (iter.hasNext()) {

			Map.Entry entry = (Map.Entry) iter.next();
			shopkeeperId = (String) entry.getKey();
			ArrayList<Product> products = (ArrayList<Product>) entry.getValue();
			Iterator<Product> iterateProducts = products.iterator();
			while (iterateProducts.hasNext()) {

				prod = iterateProducts.next();
				System.out.println(prod.getId());
				if (prod.getId().equals(id)) {

					flag = true;
					quantity = prod.getQuantity();
					
					break;
				}
			}
		}

		if (flag)
			return quantity;
		else
			return 0;

	}

	public void updatingProductList(String shopkeeperId, Product prod) {
		prod.quantity = prod.quantity - requiredQuantity;

		Product produc = new Product(prod.getId(), prod.getProductName(), prod.getQuantity());
		productsList = Main.shopKeeperList.get(shopkeeperId);
		productsList.remove(prod);
		productsList.add(produc);
	}
	public String  getShopkeeperId()
	{
		return shopkeeperId;
	}

	public Product getProduct()
	{
		//prod=product;
		return prod;
	}
}
