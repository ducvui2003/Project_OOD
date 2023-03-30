package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PanelChooseProduct;

public class ChangeQuantity implements ActionListener {
	PanelChooseProduct chooseProduct;

	public ChangeQuantity(PanelChooseProduct chooseProduct) {
		super();
		this.chooseProduct = chooseProduct;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int currentQuantity = chooseProduct.getQuantityCurrent();
		if (chooseProduct.getButtonUp() == e.getSource()) {
			currentQuantity = currentQuantity + 1;
			chooseProduct.getLabelQuantity().setText(currentQuantity + "");
			chooseProduct.getButtonDown().setEnabled(true);
		}
		if (chooseProduct.getButtonDown() == e.getSource()) {
			currentQuantity = currentQuantity - 1;
			chooseProduct.getLabelQuantity().setText(currentQuantity + "");
			if (currentQuantity == 1) {
				chooseProduct.getButtonDown().setEnabled(false);
			}
		}
		if (chooseProduct.getButtonChoose() == e.getSource()) {
//			Getter Current Quantity, transport it into Jtable
			chooseProduct.getLabelQuantity().setText("1");
			chooseProduct.getButtonDown().setEnabled(false);
		}
		chooseProduct.setQuantityCurrent(currentQuantity);
		System.out.println(chooseProduct.getQuantityCurrent());
	}
}
