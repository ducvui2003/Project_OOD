package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;
import model.Product;
import view.PanelBill;
import view.PanelBillItems;
import view.View;

public class SelectAll extends Controller implements ItemListener {
	PanelBillItems panelBillItems;

	public SelectAll(View view, Model model, PanelBillItems panelBillItems) {
		super(view, model);
		this.panelBillItems = panelBillItems;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			for (int i = 0; i < panelBillItems.getListPanelBillItems().size(); i++) {
				Product product = panelBillItems.getListPanelBillItems().get(i).getProduct();
				if (!panelBillItems.getListProductChecked().contains(product)) {
					panelBillItems.getListProductChecked().add(product);
				}
			}

		} else {
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				for (int i = 0; i < panelBillItems.getListPanelBillItems().size(); i++) {
					Product product = panelBillItems.getListPanelBillItems().get(i).getProduct();
					panelBillItems.getListProductChecked().remove(product);
				}
			}
		}
	}
}
