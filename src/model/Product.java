package model;

import java.util.Objects;

public class Product {
	private String id;
	private String name;
	private double unitPrice;
	private Category category;
	private String fileImage = null;

	public Product(String id, String name, double unitPrice, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFileImage() {
		return fileImage;
	}

	public void setFileImage(String fileImage) {
		this.fileImage = fileImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, fileImage, id, name, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return category == other.category && Objects.equals(fileImage, other.fileImage) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", category=" + category
				+ ", fileImage=" + fileImage + "]";
	}

}
