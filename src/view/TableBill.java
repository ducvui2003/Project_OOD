package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableBill extends JPanel {
	public TableBill() {
		create();
	}

	public void create() {
		this.setLayout(new GridLayout(1, 0, 0, 0));
		this.setLayout(new BorderLayout(0, 0));
		JLabel labelID = new JLabel("ID");
		labelID.setEnabled(false);

		JLabel labelName = new JLabel("NAME");
		labelName.setEnabled(false);

		JPanel panelMoreInfoItem = new JPanel();
		panelMoreInfoItem.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel labelQuantity = new JLabel("QUANTITY");
		panelMoreInfoItem.add(labelQuantity);
		JLabel labelUnitPriceJLabel = new JLabel("UNIT PRICE");
		panelMoreInfoItem.add(labelUnitPriceJLabel);

		JLabel labelOption = new JLabel("OPTION");
		panelMoreInfoItem.add(labelOption);

		JLabel labelTotalPrice = new JLabel("TOTAL PRICE");
		panelMoreInfoItem.add(labelTotalPrice);

		this.add(labelID, BorderLayout.WEST);
		this.add(labelName, BorderLayout.CENTER);
		this.add(panelMoreInfoItem, BorderLayout.EAST);
	}

	public JPanel createItemBill(String id, String name, int quantity, double unitPrice) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		JLabel labelID = new JLabel(id);
		labelID.setEnabled(false);

		JLabel labelName = new JLabel(name);
		labelName.setEnabled(false);

		JPanel panelMoreInfoItem = new JPanel();
		panelMoreInfoItem.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel labelQuantity = new JLabel(quantity + "");
		panelMoreInfoItem.add(labelQuantity);
		JLabel labelUnitPriceJLabel = new JLabel(unitPrice + "");
		panelMoreInfoItem.add(labelUnitPriceJLabel);

		JComboBox<String> option = new JComboBox<>();
		panelMoreInfoItem.add(option);

		JLabel labelTotalPrice = new JLabel(quantity * unitPrice + "");
		panelMoreInfoItem.add(labelTotalPrice);

		panel.add(labelID, BorderLayout.WEST);
		panel.add(labelName, BorderLayout.CENTER);
		panel.add(panelMoreInfoItem, BorderLayout.EAST);
		return panel;
	}
}
