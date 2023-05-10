package model;

public interface ObserverProduct {
	public void update(Product product, int quantity, String updateType);

	public void update(Category category);

	public void update(String discount);
}
