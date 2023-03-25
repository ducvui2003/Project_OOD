package model;

import java.util.ArrayList;

public class Store {
	private ArrayList<Product> listProducts = new ArrayList<>();

	public Store() {
		
	}

	public void addProduct(Product product) {
		if (!listProducts.contains(product)) {
			listProducts.add(product);
		}
	}

	public ArrayList<Product> getListProducts() {
		return listProducts;
	}

	public void setListPorducts(ArrayList<Product> listPorducts) {
		this.listProducts = listPorducts;
	}

}
