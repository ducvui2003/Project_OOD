package temp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CheckBoxListExample extends JFrame {

	private JList<JCheckBox> checkBoxList;
	private DefaultListModel<JCheckBox> listModel;

	public CheckBoxListExample() {
		super("Checkbox List Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		listModel = new DefaultListModel<>();
		listModel.addElement(new JCheckBox("Option 1"));
		listModel.addElement(new JCheckBox("Option 2"));
		listModel.addElement(new JCheckBox("Option 3"));

		checkBoxList = new JList<>(listModel);
		checkBoxList.setCellRenderer(new CheckBoxListCellRenderer());

		checkBoxList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int[] selectedIndices = checkBoxList.getSelectedIndices();
				ArrayList<String> selectedOptions = new ArrayList<>();

				for (int i = 0; i < selectedIndices.length; i++) {
					JCheckBox checkBox = checkBoxList.getModel().getElementAt(selectedIndices[i]);
					if (checkBox.isSelected()) {
						selectedOptions.add(checkBox.getText());
					}
				}

				String[] selectedOptionsArray = selectedOptions.toArray(new String[selectedOptions.size()]);
				System.out.println(Arrays.toString(selectedOptionsArray));
			}
		});

		JScrollPane scrollPane = new JScrollPane(checkBoxList);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	private static class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer<JCheckBox> {

		@Override
		public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
			setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
			setSelected(value.isSelected());
			setText(value.getText());
			setFont(list.getFont());
			setEnabled(list.isEnabled());
			setOpaque(true);
			return this;
		}
	}

	public static void main(String[] args) {
		new CheckBoxListExample();
	}
}
