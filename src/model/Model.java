package model;

public class Model implements IModel {
	private Store store;

	public Model(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}
