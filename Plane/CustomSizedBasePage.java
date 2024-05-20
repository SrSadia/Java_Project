package Plane;
import javax.swing.*;

public class CustomSizedBasePage {
    public JFrame frame;

    public CustomSizedBasePage(String title) {
        frame = new JFrame(title);
        frame.setSize(900, 650);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponent(JComponent component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        frame.add(component);
    }

    public void show() {
        frame.setVisible(true);
    }
}
