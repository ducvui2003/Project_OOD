package temp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExamplePanel extends JPanel {
	public ExamplePanel() {
		// create a new GridBagLayout for the parent panel
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		// create a JScrollPane and add it to the parent panel
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
		scrollPaneConstraints.gridx = 0;
		scrollPaneConstraints.gridy = 0;
		scrollPaneConstraints.fill = GridBagConstraints.BOTH;
		scrollPaneConstraints.weightx = 1.0;
		scrollPaneConstraints.weighty = 1.0;
		add(scrollPane, scrollPaneConstraints);

		// create a child panel for each row and add it to the JScrollPane
		JPanel childPanel1 = new JPanel();
		childPanel1.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints childPanel1Constraints = new GridBagConstraints();
		childPanel1Constraints.gridx = 0;
		childPanel1Constraints.gridy = 0;
		childPanel1Constraints.fill = GridBagConstraints.BOTH;
		childPanel1Constraints.weightx = 1.0;
		childPanel1Constraints.weighty = 0.0;
		scrollPane.add(childPanel1, childPanel1Constraints);

		JPanel childPanel2 = new JPanel();
		childPanel2.setPreferredSize(new Dimension(100, 200));
		GridBagConstraints childPanel2Constraints = new GridBagConstraints();
		childPanel2Constraints.gridx = 1;
		childPanel2Constraints.gridy = 0;
		childPanel2Constraints.fill = GridBagConstraints.BOTH;
		childPanel2Constraints.weightx = 1.0;
		childPanel2Constraints.weighty = 0.0;
		scrollPane.add(childPanel2, childPanel2Constraints);

		JPanel childPanel3 = new JPanel();
		childPanel3.setPreferredSize(new Dimension(100, 150));
		GridBagConstraints childPanel3Constraints = new GridBagConstraints();
		childPanel3Constraints.gridx = 2;
		childPanel3Constraints.gridy = 0;
		childPanel3Constraints.fill = GridBagConstraints.BOTH;
		childPanel3Constraints.weightx = 1.0;
		childPanel3Constraints.weighty = 0.0;
		scrollPane.add(childPanel3, childPanel3Constraints);

		  // create a new JPanel to use as the viewport view of the JScrollPane
        JPanel scrollPaneViewport = new JPanel(new BorderLayout());
        // add the ExamplePanel to the viewport view panel
        scrollPaneViewport.add(this, BorderLayout.CENTER);
        // set the viewport view of the JScrollPane to the viewport view panel
        scrollPane.setViewportView(scrollPaneViewport);
	}

	public static void main(String[] args) {
		// create a new JFrame and add the ExamplePanel to it
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ExamplePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
