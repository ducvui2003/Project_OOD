package test;

import java.util.Map;

import controller.Controller;
import model.Category;
import model.Customer;
import model.Discount;
import model.Model;
import model.PercentDiscountCalculator;
import model.Product;
import model.Store;
import model.ValueDiscountCalculator;
import view.View;

public class Test {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Store store = new Store(customer);

		Product product_001 = new Product("001", "Lay's Classic Potato Chips", 1.50, Category.SNACK);
		product_001.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_001, 10);
		Product product_002 = new Product("002", "Dasani Bottled Water", 1.00, Category.SNACK);
		product_002.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_002, 10);
		Product product_003 = new Product("003", "Coca-Cola", 1.25, Category.WATER);
		product_003.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_003, 10);
		Product product_004 = new Product("004", "SkimMilk", 1.75, Category.FRUIT);
		product_004.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_004, 10);
		Product product_005 = new Product("005", "Fresh Banana", 0.75, Category.FRUIT);
		product_005.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_005, 10);
		Product product_006 = new Product("006", "Snickers Chocolate Bar", 1.00, Category.SNACK);
		product_006.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_006, 10);
		Product product_007 = new Product("007", "Gatorade Sports Drink", 2.00, Category.SODA);
		product_007.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_007, 10);
		Product product_008 = new Product("008", "Fuji Apple", 1.25, Category.WATER);
		product_008.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_008, 10);
		Product product_009 = new Product("009", "Almond Joy Chocolate Bar", 1.00, Category.SNACK);
		product_009.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_009, 10);
		Product product_010 = new Product("010", "2% Milk", 1.5, Category.SODA);
		product_010.setFileImage("src\\image\\sandWich.jpg");
		store.addProductStore(product_010, 10);

		Model model = new Model(store);
		Discount discount1 = new Discount("001", "Giam 50%", new PercentDiscountCalculator(50));
		Discount discount2 = new Discount("002", "Giam 50 VND", new ValueDiscountCalculator(10));
		store.addDiscount(discount1, 2);
		store.addDiscount(discount2, 2);
		View view = new View(model);

		Controller control = new Controller(view, model);
	}
}
