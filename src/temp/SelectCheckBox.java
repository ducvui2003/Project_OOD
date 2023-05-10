package temp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import view.View;
import view.PanelBill;
import view.PanelBillItem;
import view.PanelBillItems;

public class SelectCheckBox implements ActionListener {
	private View myFrame;
	private PanelBillItems panelTableBill;
	private double totalDiscount;

	public SelectCheckBox(View myFrame, PanelBillItems panelTableBill) {
		this.myFrame = myFrame;
		this.panelTableBill = panelTableBill;
		totalDiscount = 0.0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panelTableBill.getCheckBoxSelectAll()) {
			boolean selected = panelTableBill.getCheckBoxSelectAll().isSelected();
			JViewport viewport = panelTableBill.getScrollPane().getViewport();
			if (viewport != null) {
				Component panelInside = viewport.getView();
				if (panelInside instanceof JPanel) {
					JPanel panelListItem = (JPanel) panelInside;
					for (Component component : panelListItem.getComponents()) {
						if (component instanceof PanelBillItem) {
							((PanelBillItem) component).getCheckBox().setSelected(selected);
							myFrame.getPanelBill().getButtonDeleteAll().setEnabled(selected);
							if (selected) {
								totalDiscount += Double
										.parseDouble((((PanelBillItem) component).getLabelUnitPrice()).getText());
							} else {
								totalDiscount = 0.0;
							}
							myFrame.getPanelBill().getLabelDataTotalDiscount()
									.setText(String.valueOf(totalDiscount));

						}
					}
				}
			}
		} else {
			JCheckBox checkBoxItem = ((JCheckBox) e.getSource());
			PanelBillItem panelItemBillProduct = panelTableBill.getListPanelItemBillProduct()
					.get(panelTableBill.getListCheckBoxItems().indexOf(checkBoxItem));
			if (checkBoxItem.isSelected()) {
				totalDiscount += Double.parseDouble(panelItemBillProduct.getLabelUnitPrice().getText());
			} else {
				totalDiscount -= Double.parseDouble(panelItemBillProduct.getLabelUnitPrice().getText());
				panelTableBill.getCheckBoxSelectAll().setSelected(false);
			}
			myFrame.getPanelBill().getLabelDataTotalDiscount().setText(String.valueOf(totalDiscount));
		}
	}

}
