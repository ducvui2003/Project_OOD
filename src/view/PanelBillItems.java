package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.SelectAll;
import model.Product;
import staticPack.ColorView;

public class PanelBillItems extends JPanel {
	private View myFrame;
	private PanelBillItem header;
	private JCheckBox checkBoxSelectAll, checkBoxSelectItem;
	private ArrayList<Product> listProductChecked = new ArrayList<>();
	private ArrayList<PanelBillItem> listPanelBillItems = new ArrayList<>();// use to get index to working with
																			// panelListBill
	private JPanel panelListBill;
	private JButton buttonDelete;
	private JScrollPane scrollPane;
	private Controller selectAll;

	public PanelBillItems(View myFrame) {
		this.myFrame = myFrame;
		display();
	}

	public void display() {
		this.setLayout(new BorderLayout());
		header = panelHeader();
		this.add(header, BorderLayout.NORTH);
		scrollPane = new JScrollPane(panelListItems());
		this.add(scrollPane, BorderLayout.CENTER);
		this.setBackground(ColorView.getColorMenu());
	}

	public PanelBillItem panelHeader() {
		checkBoxSelectAll = new JCheckBox("All");
		header = new PanelBillItem(myFrame, checkBoxSelectAll, "Name", "ID", "Quantity", "Price");
		header.setBackground(new Color(142, 167, 233));
		header.setBorder(BorderFactory.createLineBorder(Color.black));
		selectAll = new SelectAll(myFrame, myFrame.getModel(), this);
		checkBoxSelectAll.addItemListener((ItemListener) selectAll);
		return header;
	}

	public JPanel panelListItems() {
		panelListBill = new JPanel();
		panelListBill.setLayout(new TopDownFlowLayout(FlowLayout.LEFT));
		panelListBill.setBackground(ColorView.getColorMenu());
		return panelListBill;
	}

	public void addItem(Product product, int quantity) {
		checkBoxSelectItem = new JCheckBox("");
		PanelBillItem panelBillItem = new PanelBillItem(myFrame, checkBoxSelectItem, product, quantity);
		panelBillItem.getButtonPlus().setVisible(true);
		panelBillItem.getButtonSubtract().setVisible(true);
		panelBillItem.setPreferredSize(new Dimension((int) panelListBill.getPreferredSize().getWidth() - 2, 70));
		panelBillItem.setBackground(ColorView.getColorMenuItem());
		panelListBill.add(panelBillItem);
		listPanelBillItems.add(panelBillItem);
	}

	public void removeItem(Product product) {
		for (int i = 0; i < listPanelBillItems.size(); i++) {
			if (listPanelBillItems.get(i).getProduct().getName().equalsIgnoreCase(product.getName())) {
				listPanelBillItems.remove(i);
				panelListBill.remove(i);
				break;
			}
		}
	}

	public void increaseQuantity(String nameProduct, int quantity) {
		for (int i = 0; i < listPanelBillItems.size(); i++) {
			if (listPanelBillItems.get(i).getProduct().getName().equalsIgnoreCase(nameProduct)) {
				listPanelBillItems.get(i).setQuantity(quantity);
			}
		}
	}

	public void decreaseQuantity(String nameProduct, int quantity) {
		for (int i = 0; i < listPanelBillItems.size(); i++) {
			if (listPanelBillItems.get(i).getProduct().getName().equalsIgnoreCase(nameProduct)) {
				listPanelBillItems.get(i).setQuantity(quantity);
			}
		}
	}

//	public void selectAllPanelListBill() {
//		panelListBill.removeAll();
//		for (int i = 0; i < listProductChecked.size(); i++) {
//			checkBoxSelectItem = new JCheckBox("");
//			PanelBillItem panelBillItem = new PanelBillItem(myFrame, checkBoxSelectItem, listProductChecked.get(i), quantity);
//			panelBillItem.getButtonPlus().setVisible(true);
//			panelBillItem.getButtonSubtract().setVisible(true);
//			panelBillItem.setPreferredSize(new Dimension((int) panelListBill.getPreferredSize().getWidth() - 2, 70));
//			panelBillItem.setBackground(ColorView.getColorMenuItem());
//			panelListBill.add(panelBillItem);
//			listPanelBillItems.add(panelBillItem);
//		}
//	}

	public PanelBillItem getPanelItemBillHeader() {
		return header;
	}

	public void setPanelItemBillHeader(PanelBillItem panelItemBillHeader) {
		this.header = panelItemBillHeader;
	}

	public JCheckBox getCheckBoxSelectAll() {
		return checkBoxSelectAll;
	}

	public void setCheckBoxSelectAll(JCheckBox checkBoxSelectAll) {
		this.checkBoxSelectAll = checkBoxSelectAll;
	}

	public JCheckBox getCheckBoxSelect() {
		return checkBoxSelectItem;
	}

	public void setCheckBoxSelect(JCheckBox checkBoxSelect) {
		this.checkBoxSelectItem = checkBoxSelect;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}

	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JPanel getPanelListBill() {
		return panelListBill;
	}

	public void setPanelListBill(JPanel panelListBill) {
		this.panelListBill = panelListBill;
	}

	public ArrayList<Product> getListProductChecked() {
		return listProductChecked;
	}

	public void setListProductChecked(ArrayList<Product> listProductChecked) {
		this.listProductChecked = listProductChecked;
	}

	public ArrayList<PanelBillItem> getListPanelBillItems() {
		return listPanelBillItems;
	}

	public void setListPanelBillItems(ArrayList<PanelBillItem> listPanelBillItems) {
		this.listPanelBillItems = listPanelBillItems;
	}

	public Controller getSelectAll() {
		return selectAll;
	}

	public void setSelectAll(Controller selectAll) {
		this.selectAll = selectAll;
	}

}
