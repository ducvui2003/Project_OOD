package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.ShowAdvancedOption;
import controller.VirtualKeyBoard;
import model.Product;
import model.Store;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GUI extends JFrame {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField textFieldFind;
	private Dimension dimesionForButton, dimesionFortextField, dimesionForPanel, dimesionForComboBox,
			dimesionProductFrame;
	private JButton buttonFind;
	private String[] listItem = { "All", "Drink", "Food", "Bake" };
	private JComboBox<JCheckBox> comboBoxFilterAdvanced;
	private JCheckBox[] checkBoxDrink = { new JCheckBox("Hot"), new JCheckBox("Cold") };
	private JCheckBox[] checkBoxBake = { new JCheckBox("Banh man"), new JCheckBox("Banh ngot") };
	private JCheckBox[] checkBoxFood = { new JCheckBox("Snack"), new JCheckBox("VN Food") };
	private ArrayList<Product> listProducts;

	private JCheckBox selectAll;
	private JTextField textFieldCoupon;
	private JButton buttonSummit;
	private JButton buttonRemove;
	private JCheckBox checkBoxSelectAll;

//	width and height component
	double widthPanelSelectProduct;
	private JComboBox comboBoxFilter;

	
	/**
	 * Create the application.
	 */
	public GUI(Store store) {
		this.listProducts = store.getListProducts();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Vending machine");
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		setSize((int) (screenWidth), (int) (screenHeight));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display();
	}

	public void display() {
		getContentPane().setLayout(new GridLayout(1, 2, 5, 5));

//Panel Bill (panel left)
		JPanel panelBill = new PanelBill();
		this.getContentPane().add(panelBill);

//Panel Products Select (panel right)
		JPanel panelProductsSelect = new JPanel();
		this.getContentPane().add(panelProductsSelect);
		panelProductsSelect.setLayout(new BorderLayout());
		widthPanelSelectProduct = panelProductsSelect.getPreferredSize().getWidth();

//Panel Products Select -> panelSelect (North)
		JPanel panelProductsSelect_panelSelect = createPanelSelect();
		panelProductsSelect.add(panelProductsSelect_panelSelect, BorderLayout.NORTH);

//Panel Products Select -> panelSelect (Center) (Scroll)
		JPanel panelProductsSelect_panelProducts = createListItemProduct(3);
		JScrollPane scrollPane_panelProducts = new JScrollPane(panelProductsSelect_panelProducts);
		panelProductsSelect.add(scrollPane_panelProducts, BorderLayout.CENTER);

	}

	

	private JPanel createPanelSelect() {
		
	}

	private JPanel createListItemProduct(int column) {
		dimesionProductFrame = new Dimension(100, 100);
		JPanel panelProduct = new JPanel(new GridLayout(0, column, 10, 10));
		for (int i = 0; i < listProducts.size(); i++) {
			Product product = listProducts.get(i);
			PanelItemProduct item = new PanelItemProduct(product.getName(), product.getId(), product.getQuantity(),
					product.getFileName(), product.getPrice());
			item.setPreferredSize(new Dimension((int) widthPanelSelectProduct / column, 300));
			panelProduct.add(item);
		}

		return panelProduct;
	}

	public JTextField getTextFieldFind() {
		return textFieldFind;
	}

	public void setTextFieldFind(JTextField textFieldFind) {
		this.textFieldFind = textFieldFind;
	}

	public JButton getButtonFind() {
		return buttonFind;
	}

	public void setButtonFind(JButton buttonFind) {
		this.buttonFind = buttonFind;
	}

	public JComboBox getComboBoxFilter() {
		return comboBoxFilter;
	}

	public void setComboBoxFilter(JComboBox comboBoxFilter) {
		this.comboBoxFilter = comboBoxFilter;
	}

	public JComboBox getComboBoxFilterAdvanced() {
		return comboBoxFilterAdvanced;
	}

	public void setComboBoxFilterAdvanced(JComboBox comboBoxFilterAdvanced) {
		this.comboBoxFilterAdvanced = comboBoxFilterAdvanced;
	}

	public JCheckBox[] getCheckBoxDrink() {
		return checkBoxDrink;
	}

	public void setCheckBoxDrink(JCheckBox[] checkBoxDrink) {
		this.checkBoxDrink = checkBoxDrink;
	}

	public JCheckBox[] getCheckBoxBake() {
		return checkBoxBake;
	}

	public void setCheckBoxBake(JCheckBox[] checkBoxBake) {
		this.checkBoxBake = checkBoxBake;
	}

	public JCheckBox[] getCheckBoxFood() {
		return checkBoxFood;
	}

	public void setCheckBoxFood(JCheckBox[] checkBoxFood) {
		this.checkBoxFood = checkBoxFood;
	}

	public JCheckBox getSelectAll() {
		return selectAll;
	}

	public void setSelectAll(JCheckBox selectAll) {
		this.selectAll = selectAll;
	}

	public JTextField getTextFieldCoupon() {
		return textFieldCoupon;
	}

	public void setTextFieldCoupon(JTextField textFieldCoupon) {
		this.textFieldCoupon = textFieldCoupon;
	}

	public JButton getButtonSummit() {
		return buttonSummit;
	}

	public void setButtonSummit(JButton buttonSummit) {
		this.buttonSummit = buttonSummit;
	}

	public JButton getButtonRemove() {
		return buttonRemove;
	}

	public void setButtonRemove(JButton buttonRemove) {
		this.buttonRemove = buttonRemove;
	}

	public JCheckBox getCheckBoxSelectAll() {
		return checkBoxSelectAll;
	}

	public void setCheckBoxSelectAll(JCheckBox checkBoxSelectAll) {
		this.checkBoxSelectAll = checkBoxSelectAll;
	}

}
