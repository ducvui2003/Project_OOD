package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ChangeQuantity;

public class PanelChooseProduct extends JPanel  {
	private JLabel labelQuantity;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonChoose;
	private int quantityCurrent; //Output to become input of model

	public PanelChooseProduct() {
		create();
	}

	private void create() {
		this.setLayout(new GridLayout(1, 2, 5, 0));

		JPanel panelQuantity = panelQuantityProduct();
		buttonChoose = new JButton("Choose");
		buttonChoose.setFocusable(false);
		this.add(panelQuantity);
		this.add(buttonChoose);
		
//		Action
		ChangeQuantity action  = new ChangeQuantity(this);
		buttonChoose.addActionListener(action);
		buttonUp.addActionListener(action);
		buttonDown.addActionListener(action);
	}

	private JPanel panelQuantityProduct() {
		Dimension dimension = new Dimension(24, 24);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		labelQuantity = new JLabel();
		labelQuantity.setText("1");
		labelQuantity.setHorizontalAlignment(JLabel.CENTER);
		labelQuantity.setFocusable(false);
		labelQuantity.setPreferredSize(dimension);
		quantityCurrent = Integer.parseInt(labelQuantity.getText());
		buttonUp = new JButton();
		buttonUp.setIcon(new ImageIcon("src\\icons\\plus_icon.png"));
		buttonUp.setHorizontalTextPosition(JButton.CENTER);
		buttonUp.setVerticalTextPosition(JButton.CENTER);
		buttonUp.setHorizontalAlignment(JButton.CENTER);
		buttonUp.setVerticalAlignment(JButton.CENTER);
		buttonUp.setPreferredSize(dimension);
		buttonUp.setFocusable(false);
		buttonDown = new JButton();
		buttonDown.setIcon(new ImageIcon("src\\icons\\minus_icon.png"));
		buttonDown.setPreferredSize(dimension);
		buttonDown.setHorizontalTextPosition(JButton.CENTER);
		buttonDown.setVerticalTextPosition(JButton.CENTER);
		buttonDown.setHorizontalAlignment(JButton.CENTER);
		buttonDown.setVerticalAlignment(JButton.CENTER);
		buttonDown.setFocusable(false);
		buttonDown.setEnabled(false);
		panel.add(buttonUp, BorderLayout.EAST);
		panel.add(buttonDown, BorderLayout.WEST);
		panel.add(labelQuantity, BorderLayout.CENTER);

		return panel;
	}

	public JLabel getLabelQuantity() {
		return labelQuantity;
	}

	public void setLabelQuantity(JLabel labelQuantity) {
		this.labelQuantity = labelQuantity;
	}

	public JButton getButtonUp() {
		return buttonUp;
	}

	public void setButtonUp(JButton buttonUp) {
		this.buttonUp = buttonUp;
	}

	public JButton getButtonDown() {
		return buttonDown;
	}

	public void setButtonDown(JButton buttonDown) {
		this.buttonDown = buttonDown;
	}

	public int getQuantityCurrent() {
		return quantityCurrent;
	}

	public void setQuantityCurrent(int quantityCurrent) {
		this.quantityCurrent = quantityCurrent;
	}

	public JButton getButtonChoose() {
		return buttonChoose;
	}

	public void setButtonChoose(JButton buttonChoose) {
		this.buttonChoose = buttonChoose;
	}
}
