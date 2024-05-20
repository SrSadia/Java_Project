package Plane;


import LogIn.FirstPage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PaymentPage extends CustomSizedBasePage implements ActionListener {
    private JTextField cardNumberField;
    private JTextField cardHolderField;
    private JTextField cvvField;
    private JButton payButton;
    private JButton previousButton;
    private JButton logoutButton;

    public PaymentPage() {
        super("Payment");

        ImageIcon background_image = new ImageIcon("Plane/Picture/PaymentPage.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        cardNumberField = new JTextField(20);
        cardHolderField = new JTextField(20);
        cvvField = new JTextField(5);
        payButton = new JButton("Pay");
        previousButton = new JButton("Previous");
        logoutButton = new JButton("Log out");

        payButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        addComponent(new JLabel("Card Number:"), 540, 145, 100, 30);
        addComponent(cardNumberField, 640, 145, 200, 35);
        addComponent(new JLabel("Card Holder:"), 540, 195, 100, 30);
        addComponent(cardHolderField, 640, 195, 200, 35);
        addComponent(new JLabel("CVV:"), 590, 245, 100, 30);
        addComponent(cvvField, 640, 240, 200, 35);


        addComponent(payButton, 780, 550, 100, 35);
        addComponent(previousButton,10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);
        addComponent(background,0, 0, 900, 650);

        frame.setVisible(false);
    }

    public String getCardNumber() {
        return cardNumberField.getText();
    }

    public String getCardHolder() {
        return cardHolderField.getText();
    }

    public String getCVV() {
        return cvvField.getText();
    }

    public void addActionListenerToPayButton(ActionListener listener) {
        payButton.addActionListener(listener);
    }

    public void showPaymentPage() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {

            JOptionPane.showMessageDialog(null, "Your ticket purchase has been successfully processed");
            frame.setVisible(false);

            FinalPage finalPage = new FinalPage();
            finalPage.showFinalPage();
        }
        if (e.getSource() == previousButton) {
            frame.setVisible(false);

            PassengerInfoPage passengerInfoPage = new PassengerInfoPage();
            passengerInfoPage.show();
        }
        if (e.getSource() == logoutButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }

    }
}