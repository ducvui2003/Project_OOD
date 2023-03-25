package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

public class RoundBorder implements Border {
	private final int radius;
	private final int thickness;
	private final Color color;

	public RoundBorder(int radius, int thickness, Color color) {
		this.radius = radius;
		this.thickness = thickness;
		this.color = color;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(thickness));
		g2.draw(new RoundRectangle2D.Double(x + (thickness / 2), y + (thickness / 2), width - thickness,
				height - thickness, radius * 2, radius * 2));
		g2.dispose();
	}

	@Override
	public Insets getBorderInsets(Component c) {
		int thickness = this.thickness / 2;
		return new Insets(radius + thickness, radius + thickness, radius + thickness, radius + thickness);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}
}
