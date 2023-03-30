package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonts.FontText;

public class PanelItemProduct extends JPanel {
	private Color colorBackground = new Color(247, 219, 106);

	private String name;
	private String id;
	private int quantity;
	private String linkImage;
	private double price;

	public PanelItemProduct(String name, String id, int quantity, String linkImage, double price) {
		super();
		this.name = name;
		this.id = id;
		this.quantity = quantity;
		this.linkImage = linkImage;
		this.price = price;
		create(name, id, quantity, linkImage, price);
		this.setFont(FontText.getFontText());
	}

	private JPanel create(String name, String id, int quantity, String linkImage, double price) {
//		Create Frame product
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		Create Frame Image
		JPanel panelImage = new JPanel();
		panelImage.setLayout(new BorderLayout());
//		panel.setBorder(border);

//		ImageIcon imageIcon = new ImageIcon(linkImage);
		JLabel imageLabel = addImage(linkImage);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		this.add(panelImage, BorderLayout.CENTER);

//		Create Frame product info
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(5, 1, 0, 2));
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
		this.add(panelInfo, BorderLayout.SOUTH);

		PanelChooseProduct panelChooseProduct = new PanelChooseProduct();
		panelInfo.add(panelChooseProduct);
//		Decorate panel
//		panel.setBorder(border);
		this.setBackground(colorBackground);
		panelInfo.setBackground(colorBackground);
		panelImage.setBackground(colorBackground);
		return this;
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

	public Color getColorBackground() {
		return colorBackground;
	}

	public void setColorBackground(Color colorBackground) {
		this.colorBackground = colorBackground;
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

}
