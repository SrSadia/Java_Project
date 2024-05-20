package Ship;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment extends JFrame {

    private Container c;
    private JLabel label1, label2, label3, imgLabel, bkngLabel;
    private Font font1, font2, font3, font4, font5, font6;
    private ImageIcon logo, img1;
    private JTextField tf1, tf2, tf3;
    private JButton button1, button2, nBtn;
    private Cursor cursor;

    Payment() {
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Payment");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
 
        logo = new ImageIcon(getClass().getResource("image/pay2.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 50, 290, 174); 
        c.add(imgLabel);

       
        label2 = new JLabel("We Accept Only");
        label2.setBounds(380, 85, 500, 50);
        label2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
        c.add(label2);

        
        img1 = new ImageIcon(getClass().getResource("image/bkng.png"));
        bkngLabel = new JLabel(img1);
        bkngLabel.setBounds(650, 90, 200, 100);
        c.add(bkngLabel);


        font1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        font2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        font3 = new Font("Segoe UI", Font.PLAIN, 20);
        font4 = new Font("Segoe UI", Font.PLAIN, 15);
        font5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        font6 = new Font("Segoe UI Black", Font.PLAIN, 25);

        
        label2 = new JLabel("Account Information");
        label2.setBounds(380, 140, 500, 50);
        label2.setFont(font2);
        c.add(label2);

       
        label3 = new JLabel("Account Username");
        label3.setBounds(430, 180, 500, 50);
        label3.setFont(font3);
        c.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(620, 190, 180, 30); 
        tf1.setFont(font4);
        c.add(tf1);

      
        label3 = new JLabel("Mobile Number");
        label3.setBounds(430, 220, 500, 50);
        label3.setFont(font3);
        c.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(620, 230, 180, 30);
        tf2.setFont(font5);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf2);

       
        label3 = new JLabel("Bkash/Nogod Pin");
        label3.setBounds(430, 260, 500, 50);
        label3.setFont(font3);
        c.add(label3);

        tf3 = new JPasswordField(); 
        tf3.setBounds(620, 270, 180, 30); 
        tf3.setFont(font4);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf3);

       
        cursor = new Cursor(Cursor.HAND_CURSOR);

        
        button1 = new JButton("Confirm Payment");
        button1.setBounds(75, 325, 250, 50); 
        button1.setFont(font6);
        button1.setCursor(cursor);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.decode("#4CAF50")); 
        c.add(button1);

        button2 = new JButton("Back");
        button2.setBounds(550, 325, 250, 50);
        button2.setFont(font6);
        button2.setCursor(cursor);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.decode("#FF9800"));
        c.add(button2);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

     
        tf1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf1.getText().length() >= 10 )
                    e.consume();
            }
        });

        tf2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf2.getText().length() >= 19 )
                    e.consume();
            }
        });

        tf3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf3.getText().length() >= 7 )
                    e.consume();
            }
        });

        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Dashboard dashboard = new Dashboard();
               dashboard.setVisible(true);
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                
                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    PaySuccess paysuccessFrame = new PaySuccess();
                     paysuccessFrame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        Payment frame = new Payment();
        frame.setVisible(true);
    }
}
