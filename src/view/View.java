package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import model.Discount;
import model.Model;
import model.Product;
import staticPack.ColorView;

import java.util.Map;

import javax.swing.UIManager;

public class View extends JFrame implements Observer {
	private Map<Product, Integer> listProductStore;
	private Map<Product, Integer> listProductCustomer;
	private PanelBill panelBill;
	private PanelMenu panelMenu;
	private double widthPanelSelectProduct;
	private Model model;

	/**
	 * Create the application.
	 */
	public View(Model model) {
		this.model = model;
		model.getStore().addObserver(this);
		this.listProductStore = model.getStore().getListProductsStore();
		this.listProductCustomer = model.getStore().getListProductsCustomer();
		initialize();
	}

//Observer
	@Override
	public void update(Product product, int quantity, String updateType) {
		if (updateType.equalsIgnoreCase("Add Product")) {
			handleAddProduct(product);
		} else {
			if (updateType.equalsIgnoreCase("Remove Product")) {
				handleRemoveProduct(product);
			} else {
				if (updateType.equalsIgnoreCase("Increase Quantity")) {
					handleIncreaseQuantity(product, quantity);
				} else {
					if (updateType.equalsIgnoreCase("Decrease Quantity")) {
						handleDecreaseProduct(product, quantity);
					}
				}
			}
		}
		updatePrice();
	}

	@Override
	public void update(Map<Product, Integer> listFiltered) {
		this.setListProductStore(listFiltered);
		this.panelMenu.getPanelMenuItems().refresh();
	}



	public void updatePrice() {
		if (model.getStore().getCustomer().getDiscountCurrent() == null) {
			this.getPanelBill().getLabelDataTotalDiscount().setText("No Coupon");
		} else {
			this.getPanelBill().getLabelDataTotalDiscount()
					.setText(model.getStore().getCustomer().getDiscountCurrent().getCalculator().getDiscountValue());
		}
		this.getPanelBill().getLableDataGrandTotal().setText(model.getStore().updatePrice() + "");
	}

	private void handleDecreaseProduct(Product product, int quantity) {
		this.getPanelBill().getPanelTableBill().decreaseQuantity(product.getName(), quantity);
	}

	private void handleRemoveProduct(Product product) {
		this.getPanelBill().getPanelTableBill().removeItem(product);
		this.getPanelBill().getPanelTableBill().updateUI();
	}

	public void handleAddProduct(Product product) {
		this.getPanelBill().getPanelTableBill().addItem(product, 1);
		this.getPanelBill().getPanelTableBill().updateUI();
	}

	public void handleIncreaseQuantity(Product product, int quantity) {
		this.getPanelBill().getPanelTableBill().increaseQuantity(product.getName(), quantity);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		Look and feel
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		widthPanelSelectProduct = screenWidth / 2;
		setSize(screenWidth, screenHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void display() {
		setLayout(new GridLayout(1, 2, 5, 0));
		this.setBackground(ColorView.getColorMenu());
		panelBill = new PanelBill(this);
		this.add(panelBill);
		System.out.println(this.panelBill.getPreferredSize());
		panelMenu = new PanelMenu(this);
		this.add(panelMenu);
	}

	public Map<Product, Integer> getListProductStore() {
		return listProductStore;
	}

	public void setListProductStore(Map<Product, Integer> listProductStore) {
		this.listProductStore = listProductStore;
	}

	public Map<Product, Integer> getListProductCustomer() {
		return listProductCustomer;
	}

	public void setListProductCustomer(Map<Product, Integer> listProductCustomer) {
		this.listProductCustomer = listProductCustomer;
	}

	public PanelBill getPanelBill() {
		return panelBill;
	}

	public void setPanelBill(PanelBill panelBillProduct) {
		this.panelBill = panelBillProduct;
	}

	public PanelMenu getPanelChooseProduct() {
		return panelMenu;
	}

	public void setPanelChooseProduct(PanelMenu panelChooseProduct) {
		this.panelMenu = panelChooseProduct;
	}

	public double getWidthPanelSelectProduct() {
		return widthPanelSelectProduct;
	}

	public void setWidthPanelSelectProduct(double widthPanelSelectProduct) {
		this.widthPanelSelectProduct = widthPanelSelectProduct;
	}

	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
