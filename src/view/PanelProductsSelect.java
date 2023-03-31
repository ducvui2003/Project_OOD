package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ShowAdvancedOption;
import controller.VirtualKeyBoard;

public class PanelProductsSelect extends JPanel {
	private Dimension dimesionFortextField;
	private JTextField textFieldFind;
	GUI gui;
	public PanelProductsSelect() {
		display();
	}

	public void display() {
		this.setLayout(new BorderLayout());
	}
	
	public JPanel panelSelect() {
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(new BorderLayout());

		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new BorderLayout(2, 2));
		panelSearch.setPreferredSize(new Dimension(panelSelect.getWidth(), 40));
		panelSelect.add(panelSearch, BorderLayout.NORTH);

		JPanel panelTextField = new JPanel();
		panelTextField.setLayout(new BorderLayout(2, 2));
		panelSearch.add(panelTextField, BorderLayout.CENTER);
		panelSearch.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		textFieldFind = new JTextField();
		dimesionFortextField = new Dimension(100, panelSearch.getHeight());
		textFieldFind.setPreferredSize(dimesionFortextField);
		panelTextField.add(textFieldFind, BorderLayout.CENTER);
		VirtualKeyBoard virtualKeyboard = new VirtualKeyBoard(GUI.this, this.textFieldFind);

		buttonFind = new JButton("Find");
		dimesionForButton = new Dimension(60, panelSearch.getHeight());
		buttonFind.setPreferredSize(dimesionForButton);
		panelTextField.add(buttonFind, BorderLayout.EAST);

		JPanel panelComboBox = new JPanel();
		panelComboBox.setLayout(new GridLayout(1, 2, 2, 2));

		comboBoxFilter = new JComboBox(listItem);
		comboBoxFilter.setSelectedIndex(0);
		dimesionForComboBox = new Dimension(70, panelSearch.getHeight());
		comboBoxFilter.setPreferredSize(dimesionForComboBox);
		panelComboBox.add(comboBoxFilter);
		ShowAdvancedOption sao = new ShowAdvancedOption(this);
		comboBoxFilter.addActionListener(sao);

		comboBoxFilterAdvanced = new JComboBox();
		comboBoxFilterAdvanced.setEnabled(false);
		panelComboBox.add(comboBoxFilterAdvanced);
		panelSearch.add(panelComboBox, BorderLayout.EAST);
		return panelSelect;
	}
	public JPanel pannelProducts() {
		
	}
}
