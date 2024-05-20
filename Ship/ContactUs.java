package Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactUs extends JFrame implements ActionListener {

    private JTextField nameField, emailField;
    private JTextArea messageArea;
    private JButton submitButton;
    private JLabel bdstallLabel;

    public ContactUs() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Contact Us");
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing

        JLabel nameLabel = new JLabel("Name:");
        inputPanel.add(nameLabel, gbc);

        gbc.gridy++;
        nameField = new JTextField(20); // Set preferred width
        inputPanel.add(nameField, gbc);

        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        inputPanel.add(emailLabel, gbc);

        gbc.gridy++;
        emailField = new JTextField(20); // Set preferred width
        inputPanel.add(emailField, gbc);

        gbc.gridy++;
        JLabel messageLabel = new JLabel("Your Message:");
        inputPanel.add(messageLabel, gbc);

        gbc.gridy++;
        messageArea = new JTextArea(5, 20); // Set rows and columns
        JScrollPane scrollPane = new JScrollPane(messageArea); // Add scroll functionality for long messages
        inputPanel.add(scrollPane, gbc);

        // Add the submit button below the message text field
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        inputPanel.add(submitButton, gbc);

        add(inputPanel, BorderLayout.WEST);

        // Panel for bdstall.com info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel bdstallInfoLabel = new JLabel("Shiptravel.com");
        bdstallInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        infoPanel.add(bdstallInfoLabel);

        JLabel addressLabel = new JLabel("Dhaka, Bangladesh");
        infoPanel.add(addressLabel);

        JLabel phoneLabel = new JLabel("Ph: 0175-666-5900");
        infoPanel.add(phoneLabel);

        JLabel timeLabel = new JLabel("10:00 AM - 6:00 PM");
        infoPanel.add(timeLabel);

        JLabel emailInfoLabel = new JLabel("Email: info@shitravel.com");
        infoPanel.add(emailInfoLabel);

        add(infoPanel, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String message = messageArea.getText();

            // Validate if all fields are filled
            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Here you can perform additional actions like sending the message to a server or database

                // Show a confirmation message
                JOptionPane.showMessageDialog(this, "Thank you! We will reach you as soon as possible.", "Message Sent", JOptionPane.INFORMATION_MESSAGE);

                // Clear all fields after submission
                nameField.setText("");
                emailField.setText("");
                messageArea.setText("");
            }
        }
    }

    public static void main(String[] args) {
        ContactUs contactUs = new ContactUs();
        contactUs.setVisible(true);
    }
}
