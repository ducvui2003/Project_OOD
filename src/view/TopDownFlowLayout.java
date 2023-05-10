package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class TopDownFlowLayout extends FlowLayout {
	public TopDownFlowLayout(int align) {
		super(align);
		setHgap(0);
		setVgap(5);
	}

	@Override
	public void layoutContainer(Container parent) {
		synchronized (parent.getTreeLock()) {
			int x = getHgap();
			int y = getVgap();
			int maxHeight = 0;
			int rowWidth = 0;
			int availableWidth = parent.getWidth() - getHgap() * 2;
			Component[] components = parent.getComponents();
			for (Component component : components) {
				if (component.isVisible()) {
					Dimension preferredSize = component.getPreferredSize();
					if (x + preferredSize.width > availableWidth) {
						x = getHgap();
						y += maxHeight + getVgap();
						maxHeight = 0;
						rowWidth = 0;
					}
					component.setBounds(x, y, preferredSize.width, preferredSize.height);
					x += preferredSize.width + getHgap();
					maxHeight = Math.max(maxHeight, preferredSize.height);
					rowWidth += preferredSize.width + getHgap();
				}
			}
			int containerHeight = y + maxHeight + getVgap();
			int containerWidth = Math.max(rowWidth - getHgap(), availableWidth);
			parent.setPreferredSize(new Dimension(containerWidth, containerHeight));
			parent.setMinimumSize(new Dimension(containerWidth, containerHeight));
		}
	}
}
