package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ChangeQuantity;
import controller.Controller;
import controller.Select;
import model.Product;
import staticPack.ColorView;

public class PanelBillItem extends JPanel {
	private JCheckBox checkBox;
	private JLabel labelName, labelID, labelQuantity, labelUnitPrice;
	private JButton buttonPlus, buttonSubtract;
	private View view;
	private String itemName, itemID, itemQuantity, itemPrice;
	private Product product;
	private int quantity = 1;
	private Controller select;

	public PanelBillItem(View view, JCheckBox checkBox, String itemName, String itemID, String itemQuantity,
			String itemPrice) {
		super();
		this.view = view;
		this.checkBox = checkBox;
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		display();
	}

	public PanelBillItem(View view, JCheckBox checkBox, Product product) {
		super();
		this.view = view;
		this.checkBox = checkBox;
		this.product = product;
		this.itemName = product.getName();
		this.itemID = product.getId();
		this.itemPrice = product.getUnitPrice() + "";
		display();
	}

	public PanelBillItem(View view, JCheckBox checkBox, Product product, int quantity) {
		super();
		this.view = view;
		this.checkBox = checkBox;
		this.product = product;
		this.itemName = product.getName();
		this.itemID = product.getId();
		this.itemQuantity = quantity + "";
		this.itemPrice = product.getUnitPrice() + "";
		select = new Select(view, view.getModel(), this);
		display();
	}

	public void display() {
		this.setLayout(new GridLayout(1, 5, 0, 0));
		checkBox.setOpaque(false);
		this.checkBox.setHorizontalAlignment(JCheckBox.CENTER);

		labelID = new JLabel(itemID);
		labelID.setHorizontalAlignment(JLabel.CENTER);

		labelName = new JLabel(itemName);
		labelName.setHorizontalAlignment(JLabel.CENTER);

		JPanel panelQuantity = panelQuantity(itemQuantity);

		labelUnitPrice = new JLabel(itemPrice);
		labelUnitPrice.setHorizontalAlignment(JLabel.CENTER);

		this.add(this.checkBox);
		checkBox.addItemListener((ItemListener) select);
		this.add(this.labelID);
		this.add(this.labelName);
		this.add(this.labelUnitPrice);
		this.add(panelQuantity);
	}

	public JPanel panelQuantity(String itemQuantity) {
		JPanel panelQuantity = new JPanel();
		panelQuantity.setLayout(new BoxLayout(panelQuantity, BoxLayout.X_AXIS));
		labelQuantity = new JLabel(itemQuantity);
		labelQuantity.setHorizontalAlignment(JLabel.CENTER);
		panelQuantity.setOpaque(false);
		buttonPlus = new JButton();
		buttonPlus.setOpaque(false);
		buttonPlus.setIcon(new ImageIcon("src//Icon//Plus.png"));
		buttonPlus.setAlignmentY(Component.CENTER_ALIGNMENT);
		buttonSubtract = new JButton();
		buttonSubtract.setOpaque(false);
		buttonSubtract.setIcon(new ImageIcon("src//Icon//Subtract.png"));
		buttonSubtract.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelQuantity.add(Box.createHorizontalGlue()); // add flexible space
		panelQuantity.add(buttonSubtract);
		panelQuantity.add(Box.createHorizontalStrut(10)); // add fixed space
		panelQuantity.add(labelQuantity);
		panelQuantity.add(Box.createHorizontalStrut(10)); // add fixed space
		panelQuantity.add(buttonPlus);
		panelQuantity.add(Box.createHorizontalGlue()); // add flexible space
		buttonPlus.setVisible(false);
		buttonSubtract.setVisible(false);
//		Action
		ActionListener action = new ChangeQuantity(view, view.getModel(), this);
		buttonPlus.addActionListener(action);
		buttonSubtract.addActionListener(action);

		return panelQuantity;
	}

	public void setQuantity(int quanity) {
		this.getLabelQuantity().setText("" + quanity);
	}

	public void decreaseQuantity() {
		quantity = quantity - 1;
		this.getLabelQuantity().setText(quantity + "");
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public JLabel getLabelName() {
		return labelName;
	}

	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}

	public JLabel getLabelID() {
		return labelID;
	}

	public void setLabelID(JLabel labelID) {
		this.labelID = labelID;
	}

	public JLabel getLabelQuantity() {
		return labelQuantity;
	}

	public void setLabelQuantity(JLabel labelQuantity) {
		this.labelQuantity = labelQuantity;
	}

	public JLabel getLabelUnitPrice() {
		return labelUnitPrice;
	}

	public void setLabelUnitPrice(JLabel labelUnitPrice) {
		this.labelUnitPrice = labelUnitPrice;
	}

	public JButton getButtonPlus() {
		return buttonPlus;
	}

	public void setButtonPlus(JButton buttonPlus) {
		this.buttonPlus = buttonPlus;
	}

	public JButton getButtonSubtract() {
		return buttonSubtract;
	}

	public void setButtonSubtract(JButton buttonSubtract) {
		this.buttonSubtract = buttonSubtract;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Product getProduct() {
		return product;
	}
}
