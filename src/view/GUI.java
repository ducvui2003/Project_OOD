package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Product;
import model.Store;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private Dimension dimesionForButton, dimesionFortextField, dimesionForPanel, dimesionForComboBox,
			dimesionProductFrame;
	private JButton buttonFind;
	private String[] listItem = { "All", "Drink", "Food", "Bake" };
	private JComboBox comboBoxFilter, comboBoxFilterAdvanced;
	private JCheckBox[] checkBoxDrink = { new JCheckBox(), new JCheckBox() };
	private JCheckBox[] checkBoxBake = { new JCheckBox(), new JCheckBox() };
	private JCheckBox[] checkBox = { new JCheckBox(), new JCheckBox() };
	private ArrayList<Product> listProducts;
	private Color colorProductPanel = new Color(247, 219, 106);

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

					GUI window = new GUI(store);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI(Store store) {
		this.listProducts = store.getListProducts();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		frame.setSize((int) (screenWidth * 0.8), (int) (screenHeight * 0.8));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display();
	}

	public void display() {

		dimesionForPanel = new Dimension();
		frame.getContentPane().setLayout(new GridLayout(1, 2, 5, 5));

		JPanel panelBill = createPanelBill();
		panelBill.setLayout(null);

		frame.getContentPane().add(panelBill);

		JPanel panelSelect = createPanelSelect();

		JPanel panelProduct = createListPanel();

		JScrollPane scrollPaneProduct = new JScrollPane(panelProduct);
		panelSelect.add(scrollPaneProduct);
	}

	public JPanel createPanelSelect() {
		JPanel panelSelect = new JPanel();
		frame.getContentPane().add(panelSelect);
		panelSelect.setLayout(new BorderLayout());

		JPanel panelSearch = new JPanel();
		panelSelect.add(panelSearch, BorderLayout.NORTH);

		panelSearch.setLayout(new BorderLayout(2, 2));
		panelSearch.setPreferredSize(new Dimension(panelSelect.getWidth(), 40));

		JPanel panelTextField = new JPanel();
		panelTextField.setLayout(new BorderLayout(2, 2));
		panelSearch.add(panelTextField, BorderLayout.CENTER);
		panelSearch.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		textField = new JTextField();
		dimesionFortextField = new Dimension(100, panelSearch.getHeight());
		textField.setPreferredSize(dimesionFortextField);
		panelTextField.add(textField, BorderLayout.CENTER);

		buttonFind = new JButton("Find");
		dimesionForButton = new Dimension(60, panelSearch.getHeight());
		buttonFind.setPreferredSize(dimesionForButton);
		panelTextField.add(buttonFind, BorderLayout.EAST);

		JPanel panelComboBox = new JPanel();
		panelComboBox.setLayout(new GridLayout(1, 2, 2, 2));

		comboBoxFilter = new JComboBox(listItem);
		comboBoxFilter.setSelectedIndex(0);
		dimesionForComboBox = new Dimension(70, panelSearch.getHeight());
		comboBoxFilter.setPreferredSize(dimesionForComboBox);
		panelComboBox.add(comboBoxFilter);

		comboBoxFilterAdvanced = new JComboBox();
		comboBoxFilterAdvanced.setEnabled(false);
		panelComboBox.add(comboBoxFilterAdvanced);
		panelSearch.add(panelComboBox, BorderLayout.EAST);
		return panelSelect;
	}

	public JPanel createListPanel() {
		dimesionProductFrame = new Dimension(100, 100);
		JPanel panelProduct = new JPanel(new GridLayout(0, 4, 10, 10));
		for (int i = 0; i < listProducts.size(); i++) {
			Product product = listProducts.get(i);
			JPanel item = createPanelProduct(product.getName(), product.getId(), product.getQuantity(),
					product.getFileName(), product.getPrice());
			item.setPreferredSize(dimesionProductFrame);
			panelProduct.add(item);
		}
		return panelProduct;
	}

	private JPanel createPanelProduct(String name, String id, int quantity, String linkImage, double price) {
		Border border = new RoundBorder(10, 3, colorProductPanel);
//		Create Frame product
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

//		Create Frame Image
		JPanel panelImage = new JPanel();
		panelImage.setLayout(new BorderLayout());
		panel.setBorder(border);

//		ImageIcon imageIcon = new ImageIcon(linkImage);
		JLabel imageLabel = addImage(linkImage);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		panel.add(panelImage, BorderLayout.CENTER);

//		Create Frame product info
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(4, 1, 5, 5));
		JLabel nameLabel = new JLabel("Ten sp: " + name);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(nameLabel);
		JLabel idLabel = new JLabel("ID: " + id);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(idLabel);
		JLabel priceLabel = new JLabel("Price: " + price + " VND");
		panelInfo.add(priceLabel);
		priceLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel quantityLabel = new JLabel("Quantity: " + quantity);
		quantityLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(quantityLabel);
		panel.add(panelInfo, BorderLayout.SOUTH);

//		Decorate panel
		panel.setBorder(border);
		panel.setBackground(colorProductPanel);
		panelInfo.setBackground(colorProductPanel);
		panelImage.setBackground(colorProductPanel);
		return panel;
	}

	private JLabel addImage(String linkImage) {
		ImageIcon imageIcon = new ImageIcon(linkImage);
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setSize(new Dimension(200, 200));
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		imageLabel.setIcon(scaledIcon);

		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		return imageLabel;
	}

	public JPanel createPanelBill() {
		JPanel panelBill = new JPanel();
		return panelBill;
	}
}
