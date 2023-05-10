package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.VirtualKeyBoard;
import model.Category;
import staticPack.ColorView;

public class PanelMenu extends JPanel {

	private View myFrame;
	private JTextField inputText;
	private JButton buttonFind, buttonChoose, buttonUp, buttonDown;
	private JLabel labelQuantityProd;
	private ArrayList<PanelMenuItem> listPanelMenuItem = new ArrayList<>();
	private JPanel panelMenuItem;
	private VirtualKeyBoard virtualKeyboard;
	private ComboBoxCheckBoxes listCheckBox;
	private PanelMenuItems panelMenuItems;

	public PanelMenu(View myFrame) {
		this.myFrame = myFrame;
		display();
	}

	public void display() {
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
//Search
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new BorderLayout(2, 2));
		panelInput.setPreferredSize(new Dimension(this.getWidth(), 34));
		JPanel panelInputText = new JPanel(new BorderLayout(2, 2));
		inputText = new JTextField();
		panelInputText.add(inputText, BorderLayout.CENTER);
		virtualKeyboard = new VirtualKeyBoard(myFrame, inputText);

		listCheckBox = new ComboBoxCheckBoxes(myFrame, Category.getStringArray());
		panelInputText.add(listCheckBox, BorderLayout.EAST);
		buttonFind = new JButton("Find");
		panelInput.add(panelInputText, BorderLayout.CENTER);
		panelInput.add(buttonFind, BorderLayout.EAST);
//panelItems
		panelMenuItems = new PanelMenuItems(myFrame);
		JScrollPane scrollPaneProduct = new JScrollPane(panelMenuItems);
		add(panelInput, BorderLayout.NORTH);
		add(scrollPaneProduct, BorderLayout.CENTER);
		System.out.println(this.getPreferredSize());
		this.setBackground(ColorView.getColorMenu());

	}

	public JButton getButtonChoose() {
		return buttonChoose;
	}

	public void setButtonChoose(JButton buttonChoose) {
		this.buttonChoose = buttonChoose;
	}

	public JButton getButtonUp() {
		return buttonUp;
	}

	public void setButtonUp(JButton buttonUp) {
		this.buttonUp = buttonUp;
	}

	public JButton getButtonDown() {
		return buttonDown;
	}

	public void setButtonDown(JButton buttonDown) {
		this.buttonDown = buttonDown;
	}

	public JLabel getLabelQuantityProd() {
		return labelQuantityProd;
	}

	public void setLableQuantityProd(JLabel lableQuantityProd) {
		this.labelQuantityProd = lableQuantityProd;
	}

	public JPanel getPanelMenuItem() {
		return panelMenuItem;
	}

	public void setPanelMenuItem(JPanel panelMenuItem) {
		this.panelMenuItem = panelMenuItem;
	}

	public ArrayList<PanelMenuItem> getListPanelMenuItem() {
		return listPanelMenuItem;
	}

	public void setListPanelMenuItem(ArrayList<PanelMenuItem> listPanelMenuItem) {
		this.listPanelMenuItem = listPanelMenuItem;
	}

	public PanelMenuItems getPanelMenuItems() {
		return panelMenuItems;
	}

	public void setPanelMenuItems(PanelMenuItems panelMenuItems) {
		this.panelMenuItems = panelMenuItems;
	}
}
