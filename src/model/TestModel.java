package model;

public class TestModel {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Store store = new Store(customer);

		Product product1 = new Product("001", "Soda", 1.50, Category.SODA);
		product1.setFileImage("src\\\\image\\\\sandWich.jpg");
		store.addProductStore(product1, 10);
		Product product2 = new Product("002", "Water", 1.00, Category.WATER);
		product2.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product2, 10);
		Product product3 = new Product("003", "Chips", 2.50, Category.SNACK);
		product3.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product3, 10);
		Product product4 = new Product("004", "Candy", 0.75, Category.SNACK);
		product4.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product4, 10);
		Product product5 = new Product("005", "Juice", 2.00, Category.FRUIT);
		product5.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product5, 10);
		Product product6 = new Product("006", "Apple", 0.75, Category.FRUIT);
		product6.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product6, 10);
		Product product7 = new Product("007", "Pretzels", 1.75, Category.SNACK);
		product7.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product7, 10);
		Product product8 = new Product("008", "Milk", 2.50, Category.MILK);
		product8.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product8, 10);
		Product product9 = new Product("009", "Almonds", 1.25, Category.SNACK);
		product9.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product9, 10);
		Product product10 = new Product("010", "Orange Juice", 2.25, Category.FRUIT);
		product10.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product10, 10);
		store.printListProductCustomer();
		store.printListProductStore();
		System.out.println("----------------------");
		customer.addProduct(product2, 3);
		System.out.println("----------------------");
		customer.addProduct(product1, 3);
		System.out.println("----------------------");
		customer.addProduct(product2, 3);
		System.out.println("----------------------");
//		customer.addProduct(product2, 21);
		System.out.println("----------------------");
		customer.addProduct(product2, 3);
		System.out.println("----------------------");
		store.filterProductByCategory(Category.FRUIT);
		System.out.println("----------------------");
		System.out.println(store.updatePrice());
		Discount discount = new Discount("001", "Giam 50", new PercentDiscountCalculator(50));
		store.addDiscount(discount, 2);
		customer.usingDiscount("001");
		System.out.println(customer.getDiscountCurrent());
		System.out.println(store.getDiscounts());
		System.out.println(store.updatePrice());
	}
}
