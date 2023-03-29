package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import view.GUI;

public class ShowAdvancedOption implements ActionListener {
	private GUI frame;

	public ShowAdvancedOption(GUI frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox comboxFilter = frame.getComboBoxFilter();
		JComboBox comboxFilterAdvanced = frame.getComboBoxFilterAdvanced();
		if (e.getSource() == frame.getComboBoxFilter()) {
			if (comboxFilter.getActionCommand() != "All") {
				comboxFilterAdvanced.setVisible(true);
				comboxFilterAdvanced.setEnabled(true);
				comboxFilterAdvanced.setRenderer(new CheckBoxListCellRenderer());
				DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
				for (JCheckBox checkbox : frame.getCheckBoxFood()) {
					model.addElement(checkbox);
				}
				comboxFilterAdvanced.setModel(model);
			}
		}

		if (e.getSource() == frame.getComboBoxFilterAdvanced()) {

		}
	}

	class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer<Object> {
		public CheckBoxListCellRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(value.toString());
			setSelected(isSelected);
			setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
			setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
			return this;
		}
	}
}