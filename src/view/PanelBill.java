package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBill extends JPanel {
	private TableBill tableBill;
	private JCheckBox checkBoxSelectAll;
	private JButton buttonRemove;
	private JTextField textFieldCoupon = new JTextField();
	private JButton buttonSummit;

	private JPanel panelBill() {
		JPanel panelBill = new JPanel();
		panelBill.setLayout(new BorderLayout(0, 20));
		panelBill.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

//		Table bill
		tableBill = new TableBill();
//		JScrollPane scrollPane = new JScrollPane(tableBill);
		panelBill.add(tableBill, BorderLayout.CENTER);

//		Panel Bill Detail
		JPanel panelDetailBill = panelDetailBill(textFieldCoupon, buttonRemove);
		panelBill.add(panelDetailBill, BorderLayout.SOUTH);
		return panelBill;
	}

	private JPanel panelDetailBill(JTextField textFieldCoupon, JButton buttonSummit) {
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
}
