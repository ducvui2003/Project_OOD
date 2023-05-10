package controller;

import javax.swing.JOptionPane;

import model.Product;
import view.View;

public class HandleRemoveProductNonNotify implements HandleRemoveProduct {
	View view;

	public HandleRemoveProductNonNotify(View view) {
		super();
		this.view = view;
	}

	@Override
	public void handleRemoveProduct(Product product) {
		view.getPanelBill().getPanelTableBill().removeItem(product);
		view.getPanelBill().getPanelTableBill().updateUI();
	}
}
