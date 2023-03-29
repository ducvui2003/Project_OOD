package controller;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

public class MyTextFieldDialog extends JFrame {

	private JTextField textField;

	public MyTextFieldDialog() {
		super("Text Field Dialog Example");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setLocationRelativeTo(null);

		// Create a text field and add an ActionListener
		textField = new JTextField();
		textField.setColumns(20);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog dialog = new JDialog(MyTextFieldDialog.this, "Dialog Box", true);
//				JDialog dialogVirtual = new JDialog(dialog, getTitle(), rootPaneCheckingEnabled)
				dialog.add(new JButton("Closed"));
				dialog.setSize(200, 100);
				dialog.setLocationRelativeTo(MyTextFieldDialog.this);
				dialog.setVisible(true);
			}
		});

		// Add the text field to the frame
		add(textField);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MyTextFieldDialog();
	}
}
