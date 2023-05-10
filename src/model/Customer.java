package model;

import java.util.ArrayList;

public class Customer implements SubjectProduct, Buyer {

	private ArrayList<ObserverProduct> observers = new ArrayList<>();
	private Discount discountCurrent = null;

	public Customer() {

	}

//Buyer
	@Override
	public void addProduct(Product product, int quantity) {
		this.notifyObserver(product, quantity, "Add Product");

	}

	@Override
	public void removeProduct(Product product, int quantity) {
		this.notifyObserver(product, quantity, "Remove Product");

	}

	@Override
	public void filter(Category category) {
		this.notifyObserver(category);
	}

	@Override
	public void usingDiscount(String discount) {
		this.notifyObserver(discount);
	}

//SubjectProduct
	@Override
	public void addObserver(ObserverProduct observer) {
		this.observers.add(observer);

	}

	@Override
	public void removeObserver(ObserverProduct observer) {
		// TODO Auto-generated method stub
		this.observers.remove(observer);
	}

	@Override
	public void notifyObserver(Product product, int quantity, String updateType) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(product, quantity, updateType);
		}
	}

	@Override
	public void notifyObserver(Category category) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(category);
		}
	}

	@Override
	public void notifyObserver(String discount) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(discount);
		}
	}

	public ArrayList<ObserverProduct> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<ObserverProduct> observers) {
		this.observers = observers;
	}

	public Discount getDiscountCurrent() {
		return discountCurrent;
	}

	public void setDiscountCurrent(Discount discountCurrent) {
		this.discountCurrent = discountCurrent;
	}

}
