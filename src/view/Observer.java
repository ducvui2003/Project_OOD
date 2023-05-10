package view;

import java.util.Map;

import model.Discount;
import model.Product;

public interface Observer {
	public void update(Product product, int quantity, String updateType);

	public void update(Map<Product, Integer> listFiltered);

}
