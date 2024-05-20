package Bus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bKash extends JFrame implements ActionListener {
   private JButton button1, button2;
   private JTextField textField1;
   private JPasswordField passwordField1;
   private JLabel label1, label3, label4, imageLabel;
   private ImageIcon icon;
    public bKash() {
        setTitle("bKash Payment");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
         
		icon = new ImageIcon(getClass().getResource("image/bKash.jpg"));
        Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        imageLabel = new JLabel(icon);
		
        imageLabel.setBounds(10, 10, 70, 70);
        add(imageLabel);
		
		
        label1 = new JLabel("Account Number");
        label1.setBounds(420, 100, 200, 30);
        label1.setFont(new Font("Cambria", Font.BOLD, 20));
        add(label1);

        textField1 = new JTextField();
        textField1.setBounds(600, 100, 170, 30);
        textField1.setFont(new Font("Cambria", Font.PLAIN, 15));
        add(textField1);

        label3 = new JLabel("Pin");
        label3.setBounds(535, 170, 200, 30);
        label3.setFont(new Font("Cambria", Font.BOLD, 20));
        add(label3);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(600, 170, 170, 30);
        passwordField1.setFont(new Font("Cambria", Font.PLAIN, 15));
        add(passwordField1);

        button1 = new JButton("Cancel");
        button1.setBounds(480, 300, 100, 30);
        button1.setFont(new Font("Cambria", Font.BOLD, 15));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Proceed");
        button2.setBounds(680, 300, 100, 30);
        button2.setFont(new Font("Cambria", Font.BOLD, 15));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            char[] password = passwordField1.getPassword();
            String type = new String(password);
           if (textField1.getText().isEmpty() || type.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Fill up all the fields");
}          else {
    int yesORno = JOptionPane.showConfirmDialog(null, "Confirm Payment", "Confirm", JOptionPane.YES_NO_OPTION);
    if (yesORno == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "Payment Successful");
        dispose(); // Close the current frame
    }
}
        }
        if (e.getSource() == button1) {
            Home homeFrame = new Home();
            homeFrame.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        new bKash().setVisible(true);
    }
}
