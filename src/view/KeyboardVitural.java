package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardVitural {
	public static void main(String[] args) {
		// Create a JFrame object to hold the text field and virtual keyboard
		JFrame frame = new JFrame("Virtual Keyboard Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);

		// Create a text field
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 30));

		// Add a mouse listener to the text field
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Create a virtual keyboard and position it relative to the text field
				JDialog keyboard = new JDialog(frame, "Virtual Keyboard");
				keyboard.setLocation(textField.getLocationOnScreen().x,
						textField.getLocationOnScreen().y + textField.getHeight());
				keyboard.setSize(300, 150);

				// Add buttons to the virtual keyboard
				JPanel panel = new JPanel(new GridLayout(3, 29));
				for (char c = 'A'; c <= 'Z'; c++) {
					JButton button = new JButton(Character.toString(c));
					panel.add(button);
				}
				panel.add(new JButton("BACKSPACE"));
				keyboard.add(panel);

				// Display the virtual keyboard
				keyboard.setVisible(true);
			}
		});

		// Add the text field to the frame
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		frame.setVisible(true);
	}
}