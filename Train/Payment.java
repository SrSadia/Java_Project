package Train;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
    private JRadioButton rocketRadioButton, bkashRadioButton, nogodRadioButton;
    private ButtonGroup paymentMethodGroup;
    private JButton confirmButton, backButton;
    private JTextField mobileField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JLabel selectAllRequiredLabel;
    private int totalPrice;

    public Payment(int totalPrice) {
        this.totalPrice = totalPrice;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Train Ticket Booking Payment");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 24);
        Font smallFont = new Font("Segoe UI", Font.PLAIN, 14);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(labelFont);

        ImageIcon bkashIcon = new ImageIcon("Image/bkash.jpg");
        ImageIcon nogodIcon = new ImageIcon("Image/nogod.jpg");
        ImageIcon rocketIcon = new ImageIcon("Image/rocket.png");

        bkashRadioButton = new JRadioButton(bkashIcon);
        bkashRadioButton.setActionCommand("bKash");
        nogodRadioButton = new JRadioButton(nogodIcon);
        nogodRadioButton.setActionCommand("Nogod");
        rocketRadioButton = new JRadioButton(rocketIcon);
        rocketRadioButton.setActionCommand("Rocket");

        bkashRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nogodRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rocketRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(bkashRadioButton);
        paymentMethodGroup.add(nogodRadioButton);
        paymentMethodGroup.add(rocketRadioButton);

        JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioButtonPanel.setBackground(new Color(240, 240, 240));
        radioButtonPanel.add(bkashRadioButton);
        radioButtonPanel.add(nogodRadioButton);
        radioButtonPanel.add(rocketRadioButton);

        selectAllRequiredLabel = new JLabel("*Select Payment Method is Required");
        selectAllRequiredLabel.setFont(smallFont);
        selectAllRequiredLabel.setForeground(Color.RED);

        JLabel mobileLabel = new JLabel("Mobile Number:");
        mobileLabel.setFont(labelFont);
        mobileField = new JTextField(20);

        mobileField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || !str.matches("\\d*")) {
                    JOptionPane.showMessageDialog(null, "Please enter only numeric values for mobile number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                super.insertString(offs, str, a);
            }
        });

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField(20);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(smallFont);
        showPasswordCheckBox.setForeground(Color.GRAY);
        showPasswordCheckBox.addActionListener(this);

        confirmButton = new JButton("Confirm Payment");
        confirmButton.setFont(smallFont);
        confirmButton.setBackground(new Color(41, 128, 185));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(this);
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        backButton = new JButton("Back");
        backButton.setFont(smallFont);
        backButton.setBackground(new Color(41, 128, 185));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(paymentMethodLabel, gbc);

        gbc.gridy++;
        formPanel.add(radioButtonPanel, gbc);

        gbc.gridy++;
        formPanel.add(selectAllRequiredLabel, gbc);

        gbc.gridy++;
        formPanel.add(mobileLabel, gbc);

        gbc.gridy++;
        formPanel.add(mobileField, gbc);

        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        formPanel.add(passwordField, gbc);

        gbc.gridy++;
        formPanel.add(showPasswordCheckBox, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Payment(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (allFieldsFilled()) {
                String selectedPaymentMethod = paymentMethodGroup.getSelection().getActionCommand();
                String mobile = mobileField.getText();
                String password = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(this,
                        "Payment Completed with " + selectedPaymentMethod + ".\nMobile Number: " + mobile
                                + "\nTotal Price: " + totalPrice,
                        "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE);

             
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Payment Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == showPasswordCheckBox) {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        } else if (e.getSource() == backButton) {
              Hometrain hometrainFrame = new Hometrain();
                hometrainFrame.setVisible(true);
            this.dispose();
        }
    }

    private boolean allFieldsFilled() {
        return paymentMethodGroup.getSelection() != null &&
               !mobileField.getText().isEmpty() &&
               passwordField.getPassword().length != 0;
    }
}
