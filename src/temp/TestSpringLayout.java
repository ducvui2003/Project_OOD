package temp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;

public class TestSpringLayout extends JFrame {
	public TestSpringLayout() {
		 // Create the frame
        setTitle("Spring Grid Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel with SpringLayout
        JPanel panel = new JPanel(new SpringLayout());

        // Create the first label
        JLabel label1 = new JLabel("Label 1");
        panel.add(label1);
        

        // Set the size of label1
        Constraints label1Constraints = new Constraints();
        label1Constraints.setWidth(Spring.constant(50));
        label1Constraints.setHeight(Spring.constant(50));
        panel.add(label1, label1Constraints);

        // Create the second label
        JLabel label2 = new JLabel("Label 2");
        panel.add(label2);

        // Set the size and position of label2
        Constraints label2Constraints = new Constraints();
        label2Constraints.setWidth(Spring.constant(50));
        label2Constraints.setHeight(Spring.constant(50));
        label2Constraints.setX(Spring.sum(Spring.constant(50), Spring.constant(10)));
        label2Constraints.setY(Spring.constant(0));
        panel.add(label2, label2Constraints);

        // Create the third label
        JLabel label3 = new JLabel("Label 3");
        panel.add(label3);

        // Set the size and position of label3
        Constraints label3Constraints = new Constraints();
        label3Constraints.setWidth(Spring.constant(50));
        label3Constraints.setHeight(Spring.constant(50));
        label3Constraints.setX(Spring.constant(0));
        label3Constraints.setY(Spring.sum(Spring.constant(50), Spring.constant(10)));
        panel.add(label3, label3Constraints);

        // Create the fourth label
        JLabel label4 = new JLabel("Label 4");
        panel.add(label4);

        // Set the size and position of label4
        Constraints label4Constraints = new Constraints();
        label4Constraints.setWidth(Spring.constant(50));
        label4Constraints.setHeight(Spring.constant(50));
        label4Constraints.setX(Spring.sum(Spring.constant(50), Spring.constant(10)));
        label4Constraints.setY(Spring.sum(Spring.constant(50), Spring.constant(10)));
        panel.add(label4, label4Constraints);

        // Set the panel as the content pane of the frame
        setContentPane(panel);
	}

	public static void main(String[] args) {
		JFrame test = new TestSpringLayout();
		test.setVisible(true);
	}
}
