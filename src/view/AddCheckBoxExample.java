package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class AddCheckBoxExample extends JFrame{
	
	public AddCheckBoxExample() {
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setRenderer(new CheckBoxListCellRenderer());
		comboBox.setEditor(new CheckBoxListCellEditor());
		comboBox.addItem("Item 1");
		comboBox.addItem("Item 2");
		comboBox.addItem("Item 3");
		add(comboBox);
		setVisible(true);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	class CheckBoxListCellRenderer extends JPanel implements ListCellRenderer {
	    private JCheckBox checkBox;
	    private JLabel label;

	    public CheckBoxListCellRenderer() {
	        setLayout(new BorderLayout());
	        checkBox = new JCheckBox();
	        label = new JLabel();
	        add(checkBox, BorderLayout.WEST);
	        add(label, BorderLayout.CENTER);
	    }

	    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	        String item = value.toString();
	        label.setText(item);
	        checkBox.setSelected(isSelected);
	        if (isSelected) {
	            setBackground(list.getSelectionBackground());
	            setForeground(list.getSelectionForeground());
	        } else {
	            setBackground(list.getBackground());
	            setForeground(list.getForeground());
	        }
	        return this;
	    }
	}
	
	
	class CheckBoxListCellEditor extends AbstractCellEditor implements ComboBoxEditor {
	    private JPanel panel;
	    private JCheckBox checkBox;
	    private JLabel label;

	    public CheckBoxListCellEditor() {
	        panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        checkBox = new JCheckBox();
	        label = new JLabel();
	        panel.add(checkBox, BorderLayout.WEST);
	        panel.add(label, BorderLayout.CENTER);

	        checkBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                fireEditingStopped();
	            }
	        });
	    }

	    public Component getEditorComponent() {
	        return panel;
	    }

	    public Object getItem() {
	        return checkBox.isSelected();
	    }

	    public void setItem(Object value) {
	        boolean selected = (Boolean) value;
	        checkBox.setSelected(selected);
	    }

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void selectAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub
			
		}
	   
	}
	
	public static void main(String[] args) {
		new AddCheckBoxExample();
	}
}
