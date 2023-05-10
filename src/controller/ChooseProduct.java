package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.JPanel;

import model.Model;
import model.Product;
import view.View;
import view.PanelMenu;
import view.PanelMenuItem;
import view.View;

public class ChooseProduct extends Controller implements ActionListener {
	Product productChoose = null;
	PanelMenuItem itemProduct;

	public ChooseProduct(View view, Model model, PanelMenuItem itemProduct) {
		super(view, model);
		this.itemProduct = itemProduct;
	}

	public PanelMenuItem getItemProduct() {
		return itemProduct;
	}

	public void setItemProduct(PanelMenuItem itemProduct) {
		this.itemProduct = itemProduct;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (itemProduct.getButtonChoose() == e.getSource()) {
			productChoose = itemProduct.getProduct();
//			System.out.println(productChoose);
			model.getStore().getCustomer().addProduct(productChoose, 1);
		}
	}

}