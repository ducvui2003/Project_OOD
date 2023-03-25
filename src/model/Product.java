package model;

public class Product {
	private String id;
	private String name;
	private int quantity;
	private double price;
	private String fileName;

	public Product(String name, String id, int quantity, String fileName, double price) {
		this.name = name;
		this.id = id;
		this.quantity = quantity;
		this.fileName = fileName;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
