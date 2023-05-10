package model;

import java.util.Map;

import view.Observer;

public interface Subject {
	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver(Product product, int quantity, String updateType);

	public void notifyObserver(Map<Product, Integer> listFiltered);

}
