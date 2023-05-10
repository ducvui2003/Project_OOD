package staticPack;

import java.awt.Color;

public class ColorView {
	private static Color colorMenuItem = Color.decode("#00F5FF");
	private static Color colorMenu = Color.decode("#FCE700");
	private static Color colorButton = Color.decode("#EA047E");
	private static Color colorOrange = Color.decode("#FF6D28");
	private static Color green = Color.decode("#00FF00");// bright Green
	private static Color red = Color.decode("#EF5350");// bright red

	private static ColorView instance;

	private ColorView() {
		// TODO Auto-generated constructor stub
	}

	public static ColorView getInstance() {
		if (instance == null) {
			instance = new ColorView();
		}
		return instance;
	}

	public static Color getColorMenuItem() {
		return colorMenuItem;
	}

	public static Color getColorMenu() {
		return colorMenu;
	}

	public static Color getColorButton() {
		return colorButton;
	}

	public static Color getGreen() {
		return green;
	}

	public static Color getRed() {
		return red;
	}
	public static Color getColorOrange() {
		return colorOrange;
	}

	public static void setColorMenuItem(Color colorMenuItem) {
		ColorView.colorMenuItem = colorMenuItem;
	}

	public static void setColorMenu(Color colorMenu) {
		ColorView.colorMenu = colorMenu;
	}

	public static void setColorButton(Color colorButton) {
		ColorView.colorButton = colorButton;
	}

	public static void setColorOrange(Color colorOrange) {
		ColorView.colorOrange = colorOrange;
	}

	public static void setGreen(Color green) {
		ColorView.green = green;
	}

	public static void setRed(Color red) {
		ColorView.red = red;
	}

	public static void setInstance(ColorView instance) {
		ColorView.instance = instance;
	}
}
