package temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckboxExample extends JFrame {
	public CheckboxExample() {
		super("Checkbox Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new BorderLayout());

		JPanel selectAllPanel = new JPanel();
		JCheckBox selectAllCheckbox = new JCheckBox("Select All");
		selectAllPanel.add(selectAllCheckbox);

		JPanel checkboxPanel = new JPanel(new FlowLayout());
		checkboxPanel.add(new JCheckBox("Checkbox 1"));
		checkboxPanel.add(new JCheckBox("Checkbox 2"));
		checkboxPanel.add(new JCheckBox("Checkbox 3"));

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(selectAllPanel, BorderLayout.NORTH);
		mainPanel.add(checkboxPanel, BorderLayout.CENTER);

		add(mainPanel);

		selectAllCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = (JPanel) mainPanel.getComponent(1);
				Component[] components = panel.getComponents();
				for (Component component : components) {
					if (component instanceof JCheckBox && component != selectAllCheckbox) {
						((JCheckBox) component).setSelected(selectAllCheckbox.isSelected());
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		CheckboxExample example = new CheckboxExample();
		example.setVisible(true);
	}
}
