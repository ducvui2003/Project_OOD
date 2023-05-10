package model;

public interface Buyer {
	public void addProduct(Product product, int quantity);

	public void removeProduct(Product product, int quantity);

	public void filter(Category category);

	public void usingDiscount(String discount);

}
