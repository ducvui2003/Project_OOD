package temp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JViewport;

import controller.Controller;
import model.Model;
import view.View;
import view.PanelBillItems;

public class EventRemoveItemSelect extends Controller implements ActionListener {

	private PanelBillItems panelTableBill;

//	public EventRemoveItemSelect(View myFrame, PanelBillItems panelTableBill) {
//		this.myFrame = myFrame;
//		this.panelTableBill = panelTableBill;
//	}

	public EventRemoveItemSelect(View view, Model model, PanelBillItems panelTableBill) {
		super(view, model);
		this.panelTableBill = panelTableBill;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getPanelBill().getButtonDeleteAll()) {
			JViewport viewport = panelTableBill.getScrollPane().getViewport();
			if (viewport != null) {
				Component panelInside = viewport.getView();
				if (panelInside instanceof JPanel) {
					((JPanel) panelInside).removeAll();
					view.getPanelBill().getPanelTableBill().getNameProducts().clear();
					panelInside.revalidate();
					panelInside.repaint();
					view.getPanelBill().getLabelDataTotalDiscount().setText("0.0");

				}
			}

		}
	}

}
