package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.Category;
import model.Model;
import view.View;

public class Filter extends Controller implements ActionListener {
	private String stringSelected;
	private JComboBox comboBox;

	public Filter(View view, Model model, JComboBox comboBox) {
		super(view, model);
		this.comboBox = comboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stringSelected = (String) comboBox.getSelectedItem();
		try {
			Category category = Category.valueOf(stringSelected);
			model.getStore().getCustomer().filter(category);
		} catch (Exception e2) {
			view.update(model.getStore().getListProductsStore());
		}
	}
}
