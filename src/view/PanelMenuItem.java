package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Desktop.Action;
import java.awt.event.ActionListener;
import java.security.Guard;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ChooseProduct;
import model.Product;
import staticPack.ButtonBackGround;
import staticPack.ColorView;

public class PanelMenuItem extends JPanel {
	private Product product;
	private String id, name, linkImage;
	private double price;
	private int quantity;
	private JLabel labelQuantityProd;
	private JButton buttonChoose;
	private View view;

	public PanelMenuItem(Product product, View view, int quantity) {
		super();
		this.product = product;
		this.id = product.getId();
		this.name = product.getName();
		this.quantity = quantity;
		this.linkImage = product.getFileImage();
		this.price = product.getUnitPrice();
		this.view = view;
		display(name, id, quantity, linkImage, price);
	}

	private void display(String name, String id, int quantity, String linkImage, double price) {
//		Create Frame product
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		Create Frame Image
		JPanel panelImage = new JPanel();
		panelImage.setLayout(new BorderLayout());

//		Create image for Picture
		JLabel imageLabel = addImage(linkImage);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		this.add(panelImage, BorderLayout.CENTER);

//		Create Frame product info
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(5, 1, 0, -5));
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
		JButton buttonChooseProduct = buttonChooseProduct();
		panelInfo.add(buttonChooseProduct);
		this.add(panelInfo, BorderLayout.SOUTH);

//		Decorate panel
		this.setBackground(ColorView.getColorMenuItem());
		panelInfo.setOpaque(false);
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

	public JButton buttonChooseProduct() {
		buttonChoose = new JButton("Choose");
		ButtonBackGround.setBackgroundButton(buttonChoose, ColorView.getColorButton());

		buttonChoose.setFocusable(false);
		buttonChoose.setPreferredSize(new Dimension(getWidth(), 30));
//		Action
		ActionListener action = new ChooseProduct(view, view.getModel(), this);
		buttonChoose.addActionListener(action);
		return buttonChoose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public JLabel getLabelQuantityProd() {
		return labelQuantityProd;
	}

	public void setLabelQuantityProd(JLabel labelQuantityProd) {
		this.labelQuantityProd = labelQuantityProd;
	}

	public JButton getButtonChoose() {
		return buttonChoose;
	}

	public void setButtonChoose(JButton buttonChoose) {
		this.buttonChoose = buttonChoose;
	}

	public View getGui() {
		return view;
	}

	public void setGui(View gui) {
		this.view = gui;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
