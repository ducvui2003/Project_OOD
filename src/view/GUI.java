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

public class GUI extends JFrame {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField textFieldFind;
	private Dimension dimesionForButton, dimesionFortextField, dimesionForPanel, dimesionForComboBox,
			dimesionProductFrame;
	private JButton buttonFind;
	private String[] listItem = { "All", "Drink", "Food", "Bake" };
	private Object[] nameColumn = { false, "Product Name", "Price", "Quantity", "Account", "Action" };
	private JComboBox comboBoxFilter;
	private JComboBox<JCheckBox> comboBoxFilterAdvanced;
	private JCheckBox[] checkBoxDrink = { new JCheckBox("Hot"), new JCheckBox("Cold") };
	private JCheckBox[] checkBoxBake = { new JCheckBox("Banh man"), new JCheckBox("Banh ngot") };
	private JCheckBox[] checkBoxFood = { new JCheckBox("Snack"), new JCheckBox("VN Food") };
	private ArrayList<Product> listProducts;

	private TableBill tableBill;
	private JCheckBox selectAll;
	private JTextField textFieldCoupon;
	private JButton buttonSummit;
	private JButton buttonRemove;
	private JCheckBox checkBoxSelectAll;

//	width and height component
	double widthPanelSelectProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store store = new Store();
					store.addProduct(new Product("Cam", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam1", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam2", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam3", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));
					store.addProduct(new Product("Cam4", "1", 20, "src\\image\\juice.jpg", 100));

					GUI window = new GUI(store);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		JPanel panelBill = createPanelBill();

		this.getContentPane().add(panelBill);
		JPanel panelProductSelect = new JPanel();
		this.getContentPane().add(panelProductSelect);
		widthPanelSelectProduct = panelProductSelect.getPreferredSize().getWidth();
		panelProductSelect.setLayout(new BorderLayout());

		JPanel panelSelect = createPanelSelect();
		panelProductSelect.add(panelSelect, BorderLayout.NORTH);

		JPanel panelProduct = createListItemProduct(3);
		JScrollPane scrollPaneProduct = new JScrollPane(panelProduct);
		panelSelect.add(scrollPaneProduct);
		panelProductSelect.add(scrollPaneProduct, BorderLayout.CENTER);

	}

	private JPanel createPanelSelect() {
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(new BorderLayout());
		getContentPane().add(panelSelect);

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

	private JPanel createPanelBill() {
		JPanel panelBill = new JPanel();
		panelBill.setLayout(new BorderLayout(0, 20));
		panelBill.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

//		Table bill
//	continue

//		Detail bill: price, coupon,...
		JPanel panelDetail = panelDetailBill();
		panelBill.add(panelDetail, BorderLayout.SOUTH);
		return panelBill;
	}

//	private JTable tableBill() {
//		tableProduct = new JTable();
//		tableProduct.setModel(
//				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, }, nameColumn));
//
//		TableColumn tableColumn = tableProduct.getColumnModel().getColumn(0);
//		tableColumn.setCellRenderer(tableProduct.getDefaultRenderer(Boolean.class));
//		tableColumn.setCellEditor(tableProduct.getDefaultEditor(Boolean.class));
//		tableColumn.setHeaderRenderer(new CheckboxHeader("Select All"));
//		tableProduct.getTableHeader().setReorderingAllowed(false);
//		tableProduct.getColumnModel().getColumn(0).setPreferredWidth(103);
//		tableProduct.getColumnModel().getColumn(1).setPreferredWidth(97);
//		tableProduct.getColumnModel().getColumn(2).setPreferredWidth(90);
//		tableProduct.getColumnModel().getColumn(3).setPreferredWidth(82);
//		tableProduct.getColumnModel().getColumn(4).setPreferredWidth(95);
//		tableColumn.setCellRenderer(tableProduct.getDefaultRenderer(Boolean.class));
//		tableColumn.setCellEditor(tableProduct.getDefaultEditor(Boolean.class));
//		tableColumn.setHeaderRenderer(new CheckboxHeader("Select All"));
//		tableProduct.getTableHeader().setReorderingAllowed(false);
//		tableProduct.getTableHeader().setResizingAllowed(false);
//		return tableProduct;
//	}

	private JPanel panelDetailBill() {
		JPanel panelDetail = new JPanel();
		panelDetail.setLayout(new BorderLayout(10, 10));

		JPanel panelRemove = new JPanel();
		panelRemove.setLayout(new FlowLayout());

		checkBoxSelectAll = new JCheckBox("Select All");
		panelRemove.add(checkBoxSelectAll);
		buttonRemove = new JButton("Remove");
		buttonRemove.setEnabled(false);
		panelRemove.add(buttonRemove);
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel centerBlock = new JPanel();
		centerBlock.setLayout(new BoxLayout(centerBlock, BoxLayout.Y_AXIS));
		centerBlock.add(Box.createGlue());
		centerBlock.add(panelRemove);
		centerBlock.add(Box.createGlue());
		panelDetail.add(centerBlock, BorderLayout.WEST);

		JPanel panel = new JPanel();
		panelDetail.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(5, 5));

		JPanel panelCoupon = new JPanel();
		panel.add(panelCoupon, BorderLayout.NORTH);
		panelCoupon.setLayout(new BorderLayout(2, 2));

		JLabel labelCoupon = new JLabel("Coupon: ");
		panelCoupon.add(labelCoupon, BorderLayout.WEST);

		textFieldCoupon = new JTextField();
		textFieldCoupon.setPreferredSize(new Dimension(50, 30));
		panelCoupon.add(textFieldCoupon, BorderLayout.CENTER);

		buttonSummit = new JButton("Summit");
		buttonSummit.setPreferredSize(new Dimension(80, 30));
		panelCoupon.add(buttonSummit, BorderLayout.EAST);

		JPanel panelPay = new JPanel();
		panel.add(panelPay);
		panelPay.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panelPay.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 5, 5));

		JLabel lableTotalDiscount = new JLabel("Total Discount: ");
		panel_1.add(lableTotalDiscount);

		JLabel labelTax = new JLabel("Total Tax: ");
		panel_1.add(labelTax);

		JLabel lableGrandTotal = new JLabel("Grand Total: ");
		panel_1.add(lableGrandTotal);

		JButton buttonPay = new JButton("Pay");
		buttonPay.setPreferredSize(new Dimension(80, 60));
		panelPay.add(buttonPay, BorderLayout.EAST);
		return panelDetail;
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

	class CheckboxHeader implements TableCellRenderer {

		public CheckboxHeader(String title) {
			selectAll = new JCheckBox(title);
			selectAll.setOpaque(false);
			selectAll.setHorizontalAlignment(JCheckBox.CENTER);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return selectAll;
		}
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
