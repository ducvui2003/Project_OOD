package controller;

import javax.swing.JOptionPane;

import model.Product;
import view.View;

public class HandleRemoveProductNotify implements HandleRemoveProduct {
	View view;

	public HandleRemoveProductNotify(View view) {
		super();
		this.view = view;
	}

	@Override
	public void handleRemoveProduct(Product product) {
		int choice = JOptionPane.showOptionDialog(view,
				"Bạn có muốn xóa \"" + product.getName() + "\" ra khỏi danh sách chọn không?", "Question",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Có", "Không" }, "Có");
		if (choice == JOptionPane.YES_OPTION) {
			view.getPanelBill().getPanelTableBill().removeItem(product);
			view.getPanelBill().getPanelTableBill().updateUI();
			JOptionPane.showMessageDialog(null, "Đã xóa \"" + product.getName() + "\" ra khỏi danh sách chọn");
		}

	}
}
