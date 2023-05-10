package model;

public interface SubjectProduct {
	public void addObserver(ObserverProduct observer);

	public void removeObserver(ObserverProduct observer);

	public void notifyObserver(Product product, int quantity, String updateType);

	public void notifyObserver(Category category);
	
	public void notifyObserver(String discount);
	
}