package fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class RegistryFont {
	private Font customFont;

	public RegistryFont(String pathFont) {
		try (InputStream inputStream = getClass().getResourceAsStream(pathFont)) {
			customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
	}

	public Font getCustomFont(int style, int size) {
		customFont = customFont.deriveFont(style, size);
		return customFont;
	}
}
