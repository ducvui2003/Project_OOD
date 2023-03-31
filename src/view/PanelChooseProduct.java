package view;

import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ChangeQuantity;

public class PanelChooseProduct extends JPanel  {
	private JLabel labelQuantity;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonChoose;
	private int quantityCurrent; //Output to become input of model

	public PanelChooseProduct() {
		create();
	}

	private void create() {
		this.setLayout(new GridLayout(1, 2, 5, 0));

		JPanel panelQuantity = panelQuantityProduct();
		buttonChoose = new JButton("Choose");
		buttonChoose.setFocusable(false);
		this.add(panelQuantity);
		this.add(buttonChoose);
		
//		Action
		ChangeQuantity action  = new ChangeQuantity(this);
		buttonChoose.addActionListener(action);
		buttonUp.addActionListener(action);
		buttonDown.addActionListener(action);
	}

	private JPanel panelQuantityProduct() {
		Dimension dimension = new Dimension(24, 24);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		labelQuantity = new JLabel();
		labelQuantity.setText("1");
		labelQuantity.setHorizontalAlignment(JLabel.CENTER);
		labelQuantity.setFocusable(false);
		labelQuantity.setPreferredSize(dimension);
		quantityCurrent = Integer.parseInt(labelQuantity.getText());
		buttonUp = new JButton();
		buttonUp.setIcon(new ImageIcon("src\\icons\\plus_icon.png"));
		buttonUp.setHorizontalTextPosition(JButton.CENTER);
		buttonUp.setVerticalTextPosition(JButton.CENTER);
		buttonUp.setHorizontalAlignment(JButton.CENTER);
		buttonUp.setVerticalAlignment(JButton.CENTER);
		buttonUp.setPreferredSize(dimension);
		buttonUp.setFocusable(false);
		buttonDown = new JButton();
		buttonDown.setIcon(new ImageIcon("src\\icons\\minus_icon.png"));
		buttonDown.setPreferredSize(dimension);
		buttonDown.setHorizontalTextPosition(JButton.CENTER);
		buttonDown.setVerticalTextPosition(JButton.CENTER);
		buttonDown.setHorizontalAlignment(JButton.CENTER);
		buttonDown.setVerticalAlignment(JButton.CENTER);
		buttonDown.setFocusable(false);
		buttonDown.setEnabled(false);
		panel.add(buttonUp, BorderLayout.EAST);
		panel.add(buttonDown, BorderLayout.WEST);
		panel.add(labelQuantity, BorderLayout.CENTER);

		return panel;
	}

	public JLabel getLabelQuantity() {
		return labelQuantity;
	}

	public void setLabelQuantity(JLabel labelQuantity) {
		this.labelQuantity = labelQuantity;
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

	public int getQuantityCurrent() {
		return quantityCurrent;
	}

	public void setQuantityCurrent(int quantityCurrent) {
		this.quantityCurrent = quantityCurrent;
	}

	public JButton getButtonChoose() {
		return buttonChoose;
	}

	public void setButtonChoose(JButton buttonChoose) {
		this.buttonChoose = buttonChoose;
=======
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import controller.VirtualKeyBoard;
import model.Product;

public class PanelChooseProduct extends JPanel {

	private GUI myFrame;
	private JTextField textFieldFind;
	private Dimension dimesionForButton, dimesionFortextField, dimesionForComboBox, dimesionProductFrame;
	private JButton buttonFind;
	private String[] listItem = { "All", "Drink", "Food", "Bake" };
	private boolean[] valueCheckBox = new boolean[listItem.length];
	private CheckComboStore[] store = new CheckComboStore[listItem.length];
	private JComboBox comboBoxFilter;
	private Color colorProductPanel = new Color(247, 219, 106);

	public PanelChooseProduct(GUI myFrame) {
		this.myFrame = myFrame;
		setLayout(new BorderLayout());
		myFrame.add(this);

		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(new BorderLayout(2, 2));
		panelSearch.setPreferredSize(new Dimension(this.getWidth(), 40));
		add(panelSearch, BorderLayout.NORTH);

		JPanel panelTextField = new JPanel();
		panelTextField.setLayout(new BorderLayout(2, 2));
		panelSearch.add(panelTextField, BorderLayout.CENTER);
		panelSearch.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		textFieldFind = new JTextField();
		dimesionFortextField = new Dimension(100, panelSearch.getHeight());
		textFieldFind.setPreferredSize(dimesionFortextField);
		panelTextField.add(textFieldFind, BorderLayout.CENTER);
		VirtualKeyBoard virtualKeyboard = new VirtualKeyBoard(myFrame, this.textFieldFind);

		buttonFind = new JButton("Find");
		dimesionForButton = new Dimension(60, panelSearch.getHeight());
		buttonFind.setPreferredSize(dimesionForButton);
		panelTextField.add(buttonFind, BorderLayout.EAST);

//		comboBoxFilter = new JComboBox(listItem);
//		comboBoxFilter.setSelectedIndex(0);
		panelSearch.add(new CheckComboBox().getContent(), BorderLayout.EAST);
		dimesionForComboBox = new Dimension(80, panelSearch.getHeight());
		comboBoxFilter.setPreferredSize(dimesionForComboBox);

		JPanel panelListProduct = createListPanelProduct();
		JScrollPane scrollPaneProduct = new JScrollPane(panelListProduct);
		add(scrollPaneProduct);
	}

	public JPanel createListPanelProduct() {
		dimesionProductFrame = new Dimension(100, 100);
		JPanel panelProduct = new JPanel(new GridLayout(0, 4, 10, 10));
		for (int i = 0; i < myFrame.getListProducts().size(); i++) {
			Product product = myFrame.getListProducts().get(i);
			JPanel item = createPanelProduct(product.getName(), product.getId(), product.getQuantity(),
					product.getFileName(), product.getPrice());
			item.setPreferredSize(dimesionProductFrame);
			panelProduct.add(item);
		}
		return panelProduct;
	}

	private JLabel addImage(String linkImage) {
		ImageIcon imageIcon = new ImageIcon(linkImage);
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setSize(new Dimension(200, 200));
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		imageLabel.setIcon(scaledIcon);

		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
		return imageLabel;
	}

	private JPanel createPanelProduct(String name, String id, int quantity, String linkImage, double price) {
		Border border = new RoundBorder(10, 3, colorProductPanel);
//		Create Frame product
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

//		Create Frame Image
		JPanel panelImage = new JPanel();
		panelImage.setLayout(new BorderLayout());
		panel.setBorder(border);

//		ImageIcon imageIcon = new ImageIcon(linkImage);
		JLabel imageLabel = addImage(linkImage);
		panelImage.add(imageLabel, BorderLayout.CENTER);
		panel.add(panelImage, BorderLayout.CENTER);

//		Create Frame product info
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(4, 1, 5, 5));
		JLabel nameLabel = new JLabel("Ten sp: " + name);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(nameLabel);
		JLabel idLabel = new JLabel("ID: " + id);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(idLabel);
		JLabel priceLabel = new JLabel("Price: " + price + " VND");
		panelInfo.add(priceLabel);
		priceLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel quantityLabel = new JLabel("Quantity: " + quantity);
		quantityLabel.setHorizontalAlignment(JLabel.CENTER);
		panelInfo.add(quantityLabel);
		panel.add(panelInfo, BorderLayout.SOUTH);

//		Decorate panel
		panel.setBorder(border);
		panel.setBackground(colorProductPanel);
		panelInfo.setBackground(colorProductPanel);
		panelImage.setBackground(colorProductPanel);
		return panel;
	}

	class CheckComboBox implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == comboBoxFilter) {
				CheckComboStore checkComboStore = (CheckComboStore) comboBoxFilter.getSelectedItem();
				CheckComboRenderer checkComboRenderer = (CheckComboRenderer) comboBoxFilter.getRenderer();
				checkComboRenderer.checkBoxTemplate.setSelected((checkComboStore.state = !checkComboStore.state));
			}
		}

		public JComboBox getContent() {
			Arrays.fill(valueCheckBox, false);
			for (int i = 0; i < listItem.length; i++) {
				store[i] = new CheckComboStore(listItem[i], valueCheckBox[i]);
			}
			comboBoxFilter = new JComboBox(store);
			comboBoxFilter.setRenderer(new CheckComboRenderer());
			comboBoxFilter.addActionListener(this);
			return comboBoxFilter;
		}

	}

	class CheckComboRenderer implements ListCellRenderer {

		JCheckBox checkBoxTemplate;

		public CheckComboRenderer() {
			checkBoxTemplate = new JCheckBox();
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			CheckComboStore store = (CheckComboStore) value;
			checkBoxTemplate.setText(store.idCheckBox);
			checkBoxTemplate.setSelected(((Boolean) store.state).booleanValue());
			checkBoxTemplate.setBackground(isSelected ? Color.red : Color.white);
			checkBoxTemplate.setForeground(isSelected ? Color.white : Color.black);
			return checkBoxTemplate;
		}

	}

	class CheckComboStore {
		String idCheckBox;
		boolean state;

		public CheckComboStore(String idCheckBox, boolean state) {
			this.idCheckBox = idCheckBox;
			this.state = state;
		}
>>>>>>> ca1b271dfdd0e54e7fa9d9d278103b8edfca5074
	}
}
