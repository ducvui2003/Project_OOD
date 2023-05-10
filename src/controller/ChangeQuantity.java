package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.lang.model.element.ModuleElement.ProvidesDirective;
import javax.swing.JOptionPane;

import model.Model;
import model.Product;
import view.PanelBillItem;
import view.View;

public class ChangeQuantity extends Controller implements ActionListener {
	private int quantity = 1;
	private PanelBillItem itemBill;

	public ChangeQuantity(View view, Model model, PanelBillItem itemBill) {
		super(view, model);
		this.itemBill = itemBill;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		view.setHandleRemove(new HandleRemoveProductNotify(view));
		if (itemBill.getButtonPlus() == e.getSource()) {
			model.getStore().getCustomer().addProduct(itemBill.getProduct(), quantity);
			System.out.println(quantity);
		}
		if (itemBill.getButtonSubtract() == e.getSource()) {
			if (model.getStore().getListProductsCustomer().get(itemBill.getProduct()) > 1) {
				model.getStore().getCustomer().removeProduct(itemBill.getProduct(), quantity);
			} else {
				int choice = JOptionPane.showOptionDialog(view,
						"Bạn có muốn xóa \"" + itemBill.getProduct().getName() + "\" ra khỏi danh sách chọn không?",
						"Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Có", "Không" }, "Có");
				if (choice == JOptionPane.YES_OPTION) {
					view.getPanelBill().getPanelTableBill().removeItem(itemBill.getProduct());
					view.getPanelBill().getPanelTableBill().updateUI();
					JOptionPane.showMessageDialog(null, "Đã xóa \"" + itemBill.getProduct().getName() + "\" ra khỏi danh sách chọn");
				}
			}
		}
	}
}
