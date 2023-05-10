package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import view.Observer;

public class Store implements ObserverProduct, Subject {
	private Customer customer;
	private Map<Product, Integer> listProductsStore = new HashMap<>();
	private Map<Product, Integer> listProductsCustomer = new HashMap<>();
	private ArrayList<Observer> observers = new ArrayList<>();
	private Map<Discount, Integer> discounts = new HashMap<>();

	public Store(Customer customer) {
		this.customer = customer;
		this.customer.addObserver(this);
	}

//Subject: notify for view when Store update data

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);

	}

	@Override
	public void notifyObserver(Product product, int quantity, String updateType) {
		for (Observer observer : observers) {
			observer.update(product, quantity, updateType);
		}
	}

	@Override
	public void notifyObserver(Map<Product, Integer> listFiltered) {
		for (Observer observer : observers) {
			observer.update(listFiltered);
		}
	}

//Observer Product
	@Override
	public void update(Product product, int quantity, String updateType) {
		if (updateType.equalsIgnoreCase("Add Product")) {
			addProductCustomer(product, quantity);
		} else {
			if (updateType.equalsIgnoreCase("Remove Product")) {
				removeProductCustomer(product, quantity);
			}
		}
	}

	@Override
	public void update(Category category) {
		filterProductByCategory(category);
	}

	@Override
	public void update(String discount) {
		Discount result = findDiscount(discount);
		if (result != null) {
			this.customer.setDiscountCurrent(result);
		} else {
			throw new RuntimeException();
		}

	}

// Customer
	public void addProductCustomer(Product product, int quantity) {
		if (!this.listProductsCustomer.containsKey(product)) {
			this.listProductsCustomer.put(product, quantity);
//			System.out.println("Add " + product.getName() + "\tQuantity: " + this.listProductsCustomer.get(product));
			updateQuantityProductStore(product, this.listProductsStore.get(product) - quantity);
			notifyObserver(product, quantity, "Add Product");
		} else {
//			System.out.println("Add " + product.getName() + "\tQuantity: " + quantity);
//			System.out.println(this.listProductsStore);
			increaseQuantityCustomer(product, quantity);
		}
	}

	private void increaseQuantityCustomer(Product product, int quantity) {
		int quantityProductOfStore = this.listProductsStore.get(product);
		int quantityProductOfCustomer = this.listProductsCustomer.get(product);
		if (quantityProductOfCustomer + quantity <= quantityProductOfStore) {
			this.listProductsCustomer.put(product, quantityProductOfCustomer + quantity);
			this.updateQuantityProductStore(product, this.listProductsStore.get(product) - quantity);
			notifyObserver(product, quantityProductOfCustomer + quantity, "Increase Quantity");
		}
	}

	public void removeProductCustomer(Product product, int quantity) {
		if (this.listProductsCustomer.get(product) == 1) {
			this.listProductsCustomer.remove(product);
			notifyObserver(product, quantity, "Remove Product");
		} else {
			decreaseQuantityCustomer(product, quantity);
		}

	}

	private void decreaseQuantityCustomer(Product product, int quantity) {
		int quantityProductOfStore = this.listProductsStore.get(product);
		int quantityProductOfCustomer = this.listProductsCustomer.get(product);
		this.listProductsCustomer.put(product, quantityProductOfCustomer - quantity);
		updateQuantityProductStore(product, quantityProductOfStore + quantity);
		notifyObserver(product, quantityProductOfCustomer - quantity, "Decrease Quantity");
	}

	public void usingDiscount(String nameDiscount) {
		Discount discount = findDiscount(nameDiscount);
		if (discount != null && this.discounts.containsKey(discount) && this.discounts.get(discount) > 0) {
			this.customer.setDiscountCurrent(discount);
			this.updatePrice();
		} else {
			throw new RuntimeException();
		}
	}

	public void filterProductByCategory(Category category) {
		Map<Product, Integer> listFiltered = new HashMap<>();
		for (Map.Entry<Product, Integer> entry : listProductsStore.entrySet()) {
			if (entry.getKey().getCategory().equals(category)) {
				listFiltered.put(entry.getKey(), entry.getValue());
			}
		}
		notifyObserver(listFiltered);
	}

//Store
	public void addProductStore(Product product) {
		addProductCustomer(product, 10);
	}

	public void addProductStore(Product product, int quantity) {
		this.listProductsStore.put(product,
				(this.listProductsStore.get(product) == null ? 0 : this.listProductsStore.get(product)) + quantity);
	}

	public void removeProduct(Product product) {
		this.listProductsStore.remove(product);
	}

	public Product findProductStore(String name) {
		for (Map.Entry<Product, Integer> entry : listProductsStore.entrySet()) {
			if (entry.getKey().getName().equalsIgnoreCase(name)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void addDiscount(Discount discount, int quatity) {
		this.discounts.put(discount,
				(this.discounts.get(discount) == null) ? quatity : this.discounts.get(discount) + quatity);
	}

	public void updateQuantityProductStore(Product product, int quantity) {
		this.listProductsStore.put(product, quantity);

//		printListProductCustomer();
//
//		printListProductStore();
	}

	public Discount findDiscount(String name) {
		Discount discount = null;
		for (Map.Entry<Discount, Integer> entry : this.discounts.entrySet()) {
			if (entry.getKey().getId().equals(name)) {
				discount = entry.getKey();
			}
		}
		return discount;
	}

	public double updatePrice() {
		double totalPrice = 0;
		for (Map.Entry<Product, Integer> entry : this.listProductsCustomer.entrySet()) {
			totalPrice += entry.getKey().getUnitPrice() * entry.getValue();
		}
		if (this.customer.getDiscountCurrent() != null) {
			totalPrice = this.customer.getDiscountCurrent().calculatePrice(totalPrice);
		}
		return totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<Product, Integer> getListProductsStore() {
		return listProductsStore;
	}

	public void setListProductsStore(Map<Product, Integer> listProductsStore) {
		this.listProductsStore = listProductsStore;
	}

	public Map<Product, Integer> getListProductsCustomer() {
		return listProductsCustomer;
	}

	public void setListProductsCustomer(Map<Product, Integer> listProductsCustomer) {
		this.listProductsCustomer = listProductsCustomer;
	}

	public Map<Discount, Integer> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Map<Discount, Integer> discounts) {
		this.discounts = discounts;
	}

	public void printListProductStore() {
		System.out.println("List Product Store");
		for (Map.Entry<Product, Integer> entry : listProductsStore.entrySet()) {
			System.out.println(entry.getKey().getName() + "\tQuantity: " + entry.getValue());
		}
	}

	public void printListProductCustomer() {
		System.out.println("List Product Customer");
		for (Map.Entry<Product, Integer> entry : listProductsCustomer.entrySet()) {
			System.out.println(entry.getKey().getName() + "\tQuantity: " + entry.getValue());
		}
	}
}
