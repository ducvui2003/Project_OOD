package view;

import java.awt.Color;

public class ColorBoard {
	private static ColorBoard instance;
	private static Color primaryColor;
	private static Color secondaryColor;
	private static Color textColor;

	private ColorBoard() {
		// TODO Auto-generated constructor stub
	}

	public static ColorBoard getInstance() {
		if (instance == null) {
			instance = new ColorBoard();
		}
		return instance;
	}
}
