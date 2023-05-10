package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
//import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableColumn;
import javax.swing.SwingConstants;

import controller.Controller;
import controller.RemoveSelected;
import controller.SubmitCoupon;
import model.Product;
import staticPack.ButtonBackGround;
import staticPack.ColorView;
import temp.EventRemoveItemSelect;
import temp.SelectCheckBox;

public class PanelBill extends JPanel {
	private View myFrame;
	private JTextField textFieldCoupon;
	private JButton buttonSummit, buttonDeleteAll;
	private JCheckBox checkBoxSelectAll;
	private JLabel labelDataTotalDiscount, lableDataGrandTotal;
	private Dimension dimensionForLableTitle;
	private PanelBillItems panelBillItems;
	private Controller actionButtonSubmit;

	public PanelBill(View myFrame) {
		this.myFrame = myFrame;
		display();
	}

	public void display() {
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		panelBillItems = new PanelBillItems(myFrame);
		this.add(panelBillItems, BorderLayout.CENTER);

		JPanel panelDetail = new JPanel();
		panelDetail.setLayout(new BorderLayout(5, 5));
		panelDetail.setBorder(BorderFactory.createTitledBorder("Detail Information of bill"));
		this.add(panelDetail, BorderLayout.SOUTH);
		panelDetail.setBackground(ColorView.getColorOrange());
		dimensionForLableTitle = new Dimension(100, 30);

		JPanel panelRemove = new JPanel();
		panelRemove.setLayout(new BorderLayout(5, 5));
		buttonDeleteAll = new JButton("Delete");
		ButtonBackGround.setBackgroundButton(buttonDeleteAll, ColorView.getRed());
		buttonDeleteAll.setForeground(Color.black);
		buttonDeleteAll.setPreferredSize(new Dimension(100, panelDetail.getHeight()));

		Controller remove = new RemoveSelected(myFrame, myFrame.getModel(), buttonDeleteAll);
		buttonDeleteAll.addActionListener((ActionListener) remove);

		JSeparator separatorLine = new JSeparator(SwingConstants.VERTICAL);
		panelRemove.add(buttonDeleteAll, BorderLayout.CENTER);
		panelRemove.add(separatorLine, BorderLayout.EAST);
		panelDetail.add(panelRemove, BorderLayout.WEST);

		JPanel panelUtilPos = new JPanel();
		panelUtilPos.setLayout(new BorderLayout(2, 2));
		panelDetail.add(panelUtilPos, BorderLayout.CENTER);

		JPanel panelCoupon = new JPanel();
		panelCoupon.setLayout(new BorderLayout(2, 2));

		JLabel lableCoupon = new JLabel("Coupon:");
		lableCoupon.setPreferredSize(dimensionForLableTitle);
		textFieldCoupon = new JTextField();
		textFieldCoupon.setPreferredSize(new Dimension(50, 30));
		buttonSummit = new JButton("Summit");

		panelCoupon.add(lableCoupon, BorderLayout.WEST);
		panelCoupon.add(textFieldCoupon, BorderLayout.CENTER);
		panelCoupon.add(buttonSummit, BorderLayout.EAST);
//Action 
		actionButtonSubmit = new SubmitCoupon(myFrame, myFrame.getModel());
		buttonSummit.addActionListener((ActionListener) actionButtonSubmit);
		JPanel panelPay = new JPanel();
		panelPay.setLayout(new BorderLayout());

		JPanel panelCost = new JPanel();
		panelCost.setLayout(new GridLayout(3, 1));

		JPanel panelTotalDiscount = new JPanel();
		panelTotalDiscount.setLayout(new BorderLayout());
		JLabel lableTitleTotalDiscount = new JLabel("Total Discount:");
		lableTitleTotalDiscount.setPreferredSize(dimensionForLableTitle);
		labelDataTotalDiscount = new JLabel("");
		panelTotalDiscount.add(lableTitleTotalDiscount, BorderLayout.WEST);
		panelTotalDiscount.add(labelDataTotalDiscount, BorderLayout.CENTER);
		panelCost.add(panelTotalDiscount);

		JPanel panelTax = new JPanel();
		panelTax.setLayout(new BorderLayout());
		JLabel labelTitleTax = new JLabel("Total Tax:");
		labelTitleTax.setPreferredSize(dimensionForLableTitle);
		JLabel labelDataTax = new JLabel("0.5 %");
		panelTax.add(labelTitleTax, BorderLayout.WEST);
		panelTax.add(labelDataTax, BorderLayout.CENTER);
		panelCost.add(panelTax);

		JPanel panelGrandTotal = new JPanel();
		panelGrandTotal.setLayout(new BorderLayout());
		JLabel lableTitleGrandTotal = new JLabel("Grand Total:");
		lableTitleGrandTotal.setPreferredSize(dimensionForLableTitle);
		lableDataGrandTotal = new JLabel("");
		panelGrandTotal.add(lableTitleGrandTotal, BorderLayout.WEST);
		panelGrandTotal.add(lableDataGrandTotal, BorderLayout.CENTER);
		panelCost.add(panelGrandTotal);

		JButton buttonPay = new JButton("Pay");
		ButtonBackGround.setBackgroundButton(buttonPay, ColorView.getGreen());
		buttonPay.setPreferredSize(new Dimension(80, 60));
		panelPay.add(panelCost, BorderLayout.CENTER);
		panelPay.add(buttonPay, BorderLayout.EAST);

		panelUtilPos.add(panelCoupon, BorderLayout.NORTH);
		panelUtilPos.add(panelPay, BorderLayout.SOUTH);
	}

	public JCheckBox getCheckBoxSelectAll() {
		return checkBoxSelectAll;
	}

	public void setCheckBoxSelectAll(JCheckBox checkBoxSelectAll) {
		this.checkBoxSelectAll = checkBoxSelectAll;
	}

	public JTextField getTextFieldCoupon() {
		return textFieldCoupon;
	}

	public void setTextFieldCoupon(JTextField textFieldCoupon) {
		this.textFieldCoupon = textFieldCoupon;
	}

	public JButton getButtonDeleteAll() {
		return buttonDeleteAll;
	}

	public void setButtonDeleteAll(JButton buttonDeleteAll) {
		this.buttonDeleteAll = buttonDeleteAll;
	}

	public JLabel getLabelDataTotalDiscount() {
		return labelDataTotalDiscount;
	}

	public void setLabelDataTotalDiscount(JLabel labelDataTotalDiscount) {
		this.labelDataTotalDiscount = labelDataTotalDiscount;
	}

	public JLabel getLableDataGrandTotal() {
		return lableDataGrandTotal;
	}

	public void setLableDataGrandTotal(JLabel lableDataGrandTotal) {
		this.lableDataGrandTotal = lableDataGrandTotal;
	}

	public PanelBillItems getPanelTableBill() {
		return panelBillItems;
	}

	public void setPanelTableBill(PanelBillItems panelTableBill) {
		this.panelBillItems = panelTableBill;
	}

	public JButton getButtonSummit() {
		return buttonSummit;
	}

	public void setButtonSummit(JButton buttonSummit) {
		this.buttonSummit = buttonSummit;
	}
}
