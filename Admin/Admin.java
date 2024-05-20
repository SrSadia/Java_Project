package Admin;

import Plane.CustomSizedBasePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends CustomSizedBasePage implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton,  createAccountButton;

    public Admin() {
        super("Admin Login");


        Font labelFont = new Font("Arial", Font.BOLD, 24);
        JLabel largeLabel = new JLabel("Welcome to Admin Panel");
        largeLabel.setFont(labelFont);
        addComponent(largeLabel, 325, 50, 500, 50);

        usernameField = new JTextField("User Name");
        passwordField = new JPasswordField();

        addComponent(usernameField, 330, 150, 250, 50);
        addComponent(passwordField, 330, 200, 250, 50);

        loginButton = new JButton("Login");
        createAccountButton = new JButton("Create Account");

        addComponent(loginButton, 330, 250, 250, 40);
        addComponent(createAccountButton, 330, 290, 250, 40);

        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);

        show();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String enteredName = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            
            int loginStatus = AdminUser.checkUser(enteredName, enteredPassword, "AdminUsers.txt");

            if (loginStatus == 1) {
                frame.setVisible(false);
                AdminCustomize adminCustomizePage = new AdminCustomize();
            } 
            else if (loginStatus == 2) {
                // Incorrect password
                JOptionPane.showMessageDialog(frame, "Incorrect password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                // User not found
                JOptionPane.showMessageDialog(frame, "User not found. Please create an account or check your credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == createAccountButton) {
            frame.setVisible(false);
            AdminCreateAccount adminCreateAccount=new AdminCreateAccount();

        }
    }
}
