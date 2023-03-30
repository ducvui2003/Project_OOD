package fonts;

import java.awt.Font;

public class FontText {
	private static FontText instance;
	private static Font fontTitle;
	private static Font fontText;

	private FontText() {
		// TODO Auto-generated constructor stub
		RegistryFont registryPlayfairFont = new RegistryFont("src\\fonts\\PlayfairDisplay\\PlayfairDisplay-Black.ttf");
		fontText = registryPlayfairFont.getCustomFont(Font.PLAIN, 24);
	}

	public static FontText getInstance() {
		if (instance == null) {
			instance = new FontText();
		}
		return instance;
	}

	public static Font getFontTitle() {
		return fontTitle;
	}

	public static void setFontTitle(Font fontTitle) {
		FontText.fontTitle = fontTitle;
	}

	public static void setInstance(FontText instance) {
		FontText.instance = instance;
	}

	public static Font getFontText() {
		return fontText;
	}

	public static void setFontText(Font fontText) {
		FontText.fontText = fontText;
	}

}
