package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;
import view.PanelBillItem;
import view.View;

public class Select extends Controller implements ItemListener {
	private PanelBillItem panelBillItem;

	public Select(View view, Model model, PanelBillItem panelBillItem) {
		super(view, model);
		this.panelBillItem = panelBillItem;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!view.getPanelBill().getPanelTableBill().getListProductChecked().contains(panelBillItem.getProduct())) {
				view.getPanelBill().getPanelTableBill().getListProductChecked().add(panelBillItem.getProduct());
			}
		} else {
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				view.getPanelBill().getPanelTableBill().getListProductChecked().remove(panelBillItem.getProduct());
			}
		}

	}

}
