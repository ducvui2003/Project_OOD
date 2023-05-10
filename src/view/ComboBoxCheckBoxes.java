package view;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import controller.Filter;
import model.Category;
import model.Model;

public class ComboBoxCheckBoxes extends JComboBox {
	private View view;
	private Model model;
	private String[] arrayData;

	public ComboBoxCheckBoxes(String[] array) {
		super();
		this.arrayData = array;
		display();
	}

	public ComboBoxCheckBoxes(View view, String[] arrayData) {
		super();
		this.view = view;
		this.model = view.getModel();
		this.arrayData = arrayData;
		display();
	}

	public void display() {
		// Create a DefaultComboBoxModel with the data array
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(arrayData);

		// Set the model on the combo box
		this.setModel(model);
		this.setRenderer(new CheckboxComboBoxRenderer());
		this.addActionListener(new Filter(view, this.model, this));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.add(new ComboBoxCheckBoxes(new String[] { "Coffee", "Water" }));
	}

	private class CheckboxComboBoxRenderer implements ListCellRenderer<String> {

		private final JCheckBox checkBox = new JCheckBox();

		@Override
		public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
				boolean isSelected, boolean cellHasFocus) {
			checkBox.setText(value);
			checkBox.setSelected(isSelected);
			return checkBox;
		}
	}
}
