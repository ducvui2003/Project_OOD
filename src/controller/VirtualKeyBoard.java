package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.GUI;

public class VirtualKeyBoard extends JDialog implements ActionListener {

	private GUI frame;
	private JTextField textField;
	private JButton buttonCharacter, buttonNumber, buttonBackSpace, buttonSpace, buttonCancel, buttonEnter;
	private ArrayList<JButton> listButtonNum, listButtonChar;

	public VirtualKeyBoard(GUI frame, JTextField textField) {
		this.frame = frame;
		this.textField = textField;
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("On Screen Keyboard");
				setSize(1000, 300);
//				setModal(true);
				setVisible(true);
				setLocationRelativeTo(frame);
				setResizable(false);

				setLayout(new BorderLayout());

				JPanel panelNumber = new JPanel();
				listButtonNum = new ArrayList<>();
				for (int number = 1; number <= 9; number++) {
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
				}

				JPanel panelOther = new JPanel(new GridLayout());
				buttonBackSpace = new JButton("BACKSPACE");
				buttonSpace = new JButton("SPACE");
				buttonCancel = new JButton("CANCEL");
				buttonEnter = new JButton("ENTER");
				panelOther.add(buttonBackSpace);
				panelOther.add(buttonSpace);
				panelOther.add(buttonCancel);
				panelOther.add(buttonEnter);
				panelOther.setPreferredSize(new Dimension(getWidth(), 60));
				add(panelOther, BorderLayout.SOUTH);

				int x = frame.getX() + frame.getWidth() - getWidth();
				int y = frame.getY() + frame.getHeight() - getHeight();
				setLocation(x, y);

				buttonCancel.addActionListener(VirtualKeyBoard.this);
				buttonNumber.addActionListener(VirtualKeyBoard.this);
				buttonCharacter.addActionListener(VirtualKeyBoard.this);
				buttonBackSpace.addActionListener(VirtualKeyBoard.this);
				buttonSpace.addActionListener(VirtualKeyBoard.this);
				buttonEnter.addActionListener(VirtualKeyBoard.this);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCancel) {
			dispose();
//			dispose();
			setVisible(false);
		}
		
		if (e.getSource() == buttonEnter) {
			setVisible(true);
			textField.setText(buttonEnter.getText());
		}
		if (e.getSource() == buttonBackSpace) {
			textField.setText(buttonBackSpace.getText());
		}
		if (e.getSource() == buttonSpace) {
			textField.setText(buttonSpace.getText());
		}
	}
}
