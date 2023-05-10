package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;

import model.Product;
import staticPack.ColorView;

public class PanelMenuItems extends JPanel {
	View myFrame;
	private Dimension dimesionProductFrame;
	private PanelMenuItem panelMenuItem;
	private ArrayList<PanelMenuItem> listPanelMenuItem = new ArrayList<>();

	public PanelMenuItems(View myFrame) {
		super();
		this.myFrame = myFrame;
		dimesionProductFrame = new Dimension((int) (myFrame.getWidthPanelSelectProduct() - 100) / 4, 400);
//		gridBagLayout();
		display();
	}

	public PanelMenuItems(View myFrame, int dimesionProductFrame) {
		super();
		this.myFrame = myFrame;
		this.dimesionProductFrame = new Dimension(dimesionProductFrame / 4, 300);
		gridBagLayout();
	}

	public PanelMenuItems() {
		display();
	}

	public void display() {
		this.setLayout(new GridLayout(0, 4, 5, 5));
		dimesionProductFrame = new Dimension((int) (myFrame.getWidthPanelSelectProduct() - 100) / 4, 400);
		for (Map.Entry<Product, Integer> entry : myFrame.getListProductStore().entrySet()) {
			panelMenuItem = new PanelMenuItem(entry.getKey(), myFrame, entry.getValue());
			panelMenuItem.setPreferredSize(dimesionProductFrame);
			listPanelMenuItem.add(panelMenuItem);
			this.add(panelMenuItem);
		}
		this.setBackground(ColorView.getColorMenu());
	}

	public void gridBagLayout() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		int column = 4;
		int x = 0;
		int y = 0;
//		constraints.weightx = 1.0; // resize horizontally
		constraints.gridheight = 2;
		for (Map.Entry<Product, Integer> entry : myFrame.getListProductStore().entrySet()) {
			panelMenuItem = new PanelMenuItem(entry.getKey(), myFrame, entry.getValue());
			panelMenuItem.setPreferredSize(dimesionProductFrame);
			constraints.gridx = x;
			constraints.gridy = y;
			listPanelMenuItem.add(panelMenuItem);
			this.add(panelMenuItem, constraints);
			x++;
			if (x == column) {
				x = 0;
				y++;
			}

		}
		this.setBackground(ColorView.getColorMenu());
	}

	public void refresh() {
		this.removeAll();
		this.setLayout(new GridLayout(0, 4, 5, 5));
		dimesionProductFrame = new Dimension((int) (myFrame.getWidthPanelSelectProduct() - 100) / 4, 400);
		for (Map.Entry<Product, Integer> entry : myFrame.getListProductStore().entrySet()) {
			panelMenuItem = new PanelMenuItem(entry.getKey(), myFrame, entry.getValue());
			panelMenuItem.setPreferredSize(dimesionProductFrame);
			listPanelMenuItem.add(panelMenuItem);
			this.add(panelMenuItem);
		}
		this.setBackground(ColorView.getColorMenu());
		this.updateUI();
	}

}
