package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.View;

public class VirtualKeyBoard extends JDialog implements ActionListener {

	private View frame;
	private JTextField textField;
	private JButton buttonCharacter, buttonNumber, buttonBackSpace, buttonSpace, buttonCancel, buttonEnter, buttonClean;
	private ArrayList<JButton> listButtonNum, listButtonChar;
	private String textInput = "";

	public VirtualKeyBoard(View frame, JTextField textField) {
		this.frame = frame;
		this.textField = textField;
		textField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("On Screen Keyboard");
				setSize(1000, 300);
				setVisible(true);
				setLocationRelativeTo(frame);
				setResizable(false);

				setLayout(new BorderLayout());

				JPanel panelNumber = new JPanel();
				listButtonNum = new ArrayList<>();
				listButtonChar = new ArrayList<>();
				for (int number = 0; number <= 9; number++) {
					buttonNumber = new JButton(String.valueOf(number));
					buttonNumber.setPreferredSize(new Dimension(100, 50));
					panelNumber.add(buttonNumber);
					add(panelNumber, BorderLayout.NORTH);
					listButtonNum.add(buttonNumber);
				}

				JPanel panelCharacter = new JPanel(new GridLayout(2, 14));
				for (char character = 'A'; character <= 'Z'; character++) {
					buttonCharacter = new JButton(String.valueOf(character));
					panelCharacter.add(buttonCharacter);
					add(panelCharacter, BorderLayout.CENTER);
					listButtonChar.add(buttonCharacter);
				}

				JPanel panelOther = new JPanel(new GridLayout());
				buttonBackSpace = new JButton("BACKSPACE");
				buttonSpace = new JButton("SPACE");
				buttonCancel = new JButton("CANCEL");
				buttonEnter = new JButton("ENTER");
				buttonClean = new JButton("CLEAN");
				panelOther.add(buttonBackSpace);
				panelOther.add(buttonSpace);
				panelOther.add(buttonCancel);
				panelOther.add(buttonEnter);
				panelOther.add(buttonClean);
				panelOther.setPreferredSize(new Dimension(getWidth(), 60));
				add(panelOther, BorderLayout.SOUTH);

				int x = frame.getX() + frame.getWidth() - getWidth();
				int y = frame.getY() + frame.getHeight() - getHeight();
				setLocation(x, y);

				buttonCancel.addActionListener(VirtualKeyBoard.this);
				buttonBackSpace.addActionListener(VirtualKeyBoard.this);
				buttonSpace.addActionListener(VirtualKeyBoard.this);
				buttonEnter.addActionListener(VirtualKeyBoard.this);
				buttonClean.addActionListener(VirtualKeyBoard.this);

				for (JButton buttonNumber : listButtonNum) {
					buttonNumber.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							textInput += buttonNumber.getActionCommand();
							textField.setText(textInput);
						}
					});
				}

				for (JButton buttonChar : listButtonChar) {
					buttonChar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							textInput += buttonChar.getActionCommand();
							textField.setText(textInput);
						}
					});
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCancel) {
			dispose();
		} else if (e.getSource() == buttonEnter) {
			textField.setText(buttonEnter.getText());
		} else if (e.getSource() == buttonBackSpace) {
			if (!textInput.isEmpty()) {
				textInput = textInput.substring(0, textInput.length() - 1);
				textField.setText(textInput);
			} else {
				JOptionPane.showMessageDialog(frame, "Text is null");
			}
		} else if (e.getSource() == buttonSpace) {
			textInput += " ";
			textField.setText(textInput);
		}else if(e.getSource() == buttonClean) {
			textInput = "";
			textField.setText(textInput);
		}
	}
}
