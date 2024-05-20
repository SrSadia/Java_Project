package Plane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import LogIn.FirstPage;
import LogIn.SecondPage;

public class PassengerInfoPage extends CustomSizedBasePage implements ActionListener {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton logoutButton;

    public PassengerInfoPage() {
        super("Passenger Information");


        ImageIcon background_image = new ImageIcon("Plane/Picture/PassengerInfoPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        logoutButton = new JButton("Logout");


        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        addComponent(new JLabel("Name:"), 590, 105, 100, 30);
        addComponent(nameField, 640, 105, 200, 35);
        addComponent(new JLabel("Phone:"), 590, 155, 100, 30);
        addComponent(phoneField, 640, 150, 200, 35);
        addComponent(new JLabel("Email:"), 590, 205, 100, 30);

        addComponent(emailField, 640, 200, 200, 35);
        addComponent(new JLabel("Gender:"), 590, 250, 100, 30);
        addComponent(maleRadioButton, 646, 250, 200, 35);
        addComponent(femaleRadioButton, 646, 270, 100, 30);

        

        addComponent(nextButton, 780, 550, 100, 35);
        addComponent(previousButton, 10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);
        addComponent(background,0, 0, 900, 650);

        frame.setVisible(false);
    }


    public boolean isMaleSelected() {
        return maleRadioButton.isSelected();
    }

    public boolean isFemaleSelected() {
        return femaleRadioButton.isSelected();
    }

    public void addActionListenerToNextButton(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {

            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            
            // Validate phone number
            if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                return;
            }
            // Validate Email
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                return;
            }

            PaymentPage paymentPage = new PaymentPage();
            paymentPage.showPaymentPage();
            frame.setVisible(false);
        }
        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            FirstPage firstPage = new FirstPage();
            
        }
        if (e.getSource() == previousButton) {
            TicketBookingPage ticketBookingPage = new TicketBookingPage();
            ticketBookingPage.setVisibility();
            frame.setVisible(false);

        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {



        if (phoneNumber.length() != 11) {

            return false;
        }
    
        for (int i = 0; i < phoneNumber.length(); i++) {

            if (!Character.isDigit(phoneNumber.charAt(i))) {

                return false;
            }
        }
        
    
        return true;

    }

    private boolean isValidEmail(String email) {
        //check "@"  "."
        return email.contains("@") && email.contains(".");
    }
}
