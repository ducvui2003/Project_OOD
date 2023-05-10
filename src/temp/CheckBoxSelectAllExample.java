package temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxSelectAllExample extends JFrame {
	public CheckBoxSelectAllExample() {
		super("Select All Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new FlowLayout());

		JCheckBox selectAll = new JCheckBox("Select All");
		selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean selected = selectAll.isSelected();
				Component[] components = getContentPane().getComponents();
				for (Component component : components) {
					if (component instanceof JCheckBox && component != selectAll) {
						((JCheckBox) component).setSelected(selected);
					}
				}
			}
		});

		getContentPane().add(selectAll);
		getContentPane().add(new JCheckBox("Checkbox 1"));
		getContentPane().add(new JCheckBox("Checkbox 2"));
		getContentPane().add(new JCheckBox("Checkbox 3"));
	}

	public static void main(String[] args) {
		CheckBoxSelectAllExample example = new CheckBoxSelectAllExample();
		example.setVisible(true);
	}
}
