package staticPack;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ButtonBackGround {

	private ButtonBackGround() {
		// TODO Auto-generated constructor stub
	}

	public static void setBackgroundButton(JButton buttonChoose, Color color) {
		buttonChoose.setBackground(color);
		buttonChoose.setOpaque(true); // make sure button is opaque
		buttonChoose.setBorderPainted(false); // remove default border

		// set margin to add space between text and padding
		Insets margin = new Insets(10, 20, 10, 20); // 10 pixels top/bottom, 20 pixels left/right
		buttonChoose.setMargin(margin);

	}

	public static Color setOpacity(Color color, int alpha) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
	}
}
