package run;

import java.awt.EventQueue;

import model.Product;
import model.Store;
import view.GUI;

public class Run {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store store = new Store();
					store.addProduct(new Product("Cam", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam1", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam2", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam3", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));

					GUI window = new GUI(store);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
