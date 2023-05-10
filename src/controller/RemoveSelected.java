package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Model;
import model.Product;
import view.View;

public class RemoveSelected extends Controller implements ActionListener {
	private JButton button;

	public RemoveSelected(View view, Model model, JButton button) {
		super(view, model);
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			int choice = JOptionPane.showOptionDialog(view,
					"Bạn có muốn xóa các sản phẩm đã chọn ra khỏi danh sách chọn không?", "Question",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Có", "Không" },
					"Có");
			if (choice == JOptionPane.YES_OPTION) {
				ArrayList<Product> productsChecked = view.getPanelBill().getPanelTableBill().getListProductChecked();
				Map<Product, Integer> mapProductCustomer = model.getStore().getListProductsCustomer();
				System.out.println(productsChecked);
				for (int i = 0; i < productsChecked.size(); i++) {
					System.out.println(mapProductCustomer.get(productsChecked.get(i)));
					Product product = productsChecked.get(i);
					model.getStore().getCustomer().removeProduct(product, mapProductCustomer.get(product));
				}
				view.getPanelBill().getPanelTableBill().getListProductChecked().clear();
				System.out.println(view.getPanelBill().getPanelTableBill().getListProductChecked());
				view.getPanelBill().getPanelTableBill().getCheckBoxSelectAll().setSelected(false);
				JOptionPane.showMessageDialog(view,
						"Đã xóa các sản phẩm đã chọn ra khỏi danh sách ra khỏi danh sách chọn");
			}

		}

	}
}
