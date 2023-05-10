package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Model;
import view.View;

public class SubmitCoupon extends Controller implements ActionListener {

	private String idCoupon = "";

	public SubmitCoupon(View view, Model model) {
		super(view, model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getPanelBill().getButtonSummit()) {
			idCoupon = view.getPanelBill().getTextFieldCoupon().getText();
			view.getPanelBill().getTextFieldCoupon().setText("");
			try {
				model.getStore().getCustomer().usingDiscount(idCoupon);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(view, "Coupon isn't avaiable or quantity of Coupon is zero!", "Warning",
						JOptionPane.WARNING_MESSAGE);

			}
		}

	}
}
