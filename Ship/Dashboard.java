package Ship;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Dashboard extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel1;
    private JLabel imgLabel, headingLabel, himgLabel, welcomeLabel;
    private ImageIcon icon1, icon2;
    private Font font1, font2;
    private JButton checkButton, bookButton, viewpackButton, destinationButton, paymentButton, contactButton, aboutButton, logoutButton, backButton;

    Dashboard() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1600, 900);
        this.setTitle("Homepage");

        c = this.getContentPane();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        c.setLayout(null);

       
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 70, 102));
        panel1.setBounds(0, 0, 1600, 65);
        c.add(panel1);

        
        icon1 = new ImageIcon(getClass().getResource("image/homeicon.png"));
        Image image = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image);

        imgLabel = new JLabel(icon1);
        imgLabel.setBounds(5, 0, 70, 70);
        panel1.add(imgLabel);

       
        font1 = new Font("Tahoma", Font.BOLD, 30);
        font2 = new Font("Tahoma", Font.PLAIN, 20);

        headingLabel = new JLabel("Home");
        headingLabel.setBounds(80, 10, 300, 40);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(font1);
        panel1.add(headingLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1400, 10, 150, 45);
        logoutButton.setBackground(new Color(47, 79, 79));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(font2);
        logoutButton.addActionListener(this);
        panel1.add(logoutButton);

       
        welcomeLabel = new JLabel("Ship Booking");
        welcomeLabel.setBounds(650, 80, 300, 40);
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(welcomeLabel);
		
		
        checkButton = new JButton("Check Packages");
        checkButton.setBounds(650, 270, 300, 50);     
        checkButton.setBackground(new Color(47, 79, 79));
        checkButton.setForeground(Color.WHITE);
        checkButton.setFont(font2);
        checkButton.addActionListener(this);
        c.add(checkButton);

        bookButton = new JButton("Book Packages");
        bookButton.setBounds(650, 330, 300, 50); 
        bookButton.setBackground(new Color(47, 79, 79));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(font2);
        bookButton.addActionListener(this);
        c.add(bookButton);

        

        destinationButton = new JButton("Destination");
        destinationButton.setBounds(650, 390, 300, 50);   
        destinationButton.setBackground(new Color(47, 79, 79));
        destinationButton.setForeground(Color.WHITE);
        destinationButton.setFont(font2);
        destinationButton.addActionListener(this);
        c.add(destinationButton);

        paymentButton = new JButton("Payment");
        paymentButton.setBounds(650, 450, 300, 50); 
        paymentButton.setBackground(new Color(47, 79, 79));
        paymentButton.setForeground(Color.WHITE);
        paymentButton.setFont(font2);
        paymentButton.addActionListener(this);
        c.add(paymentButton);

        contactButton = new JButton("Contact Us");
        contactButton.setBounds(650, 510, 300, 50);   
        contactButton.setBackground(new Color(47, 79, 79));
        contactButton.setForeground(Color.WHITE);
        contactButton.setFont(font2);
        contactButton.addActionListener(this);
        c.add(contactButton);

        aboutButton = new JButton("About");
        aboutButton.setBounds(650, 570, 300, 50);       
        aboutButton.setBackground(new Color(47, 79, 79));
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setFont(font2);
        aboutButton.addActionListener(this);
        c.add(aboutButton);

        backButton = new JButton("Back");
        backButton.setBounds(1200, 700, 150, 45);
        backButton.setBackground(new Color(47, 79, 79));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(font2);
        backButton.addActionListener(this);
        c.add(backButton);

     
        icon2 = new ImageIcon(getClass().getResource("image/home2.jpg"));
        Image img = icon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img);

        himgLabel = new JLabel(icon2);
        himgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        c.add(himgLabel);
        c.setComponentZOrder(himgLabel, c.getComponentCount() - 1); 
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            System.exit(0);
        } else if (e.getSource() == checkButton) {
            CheckPackage checkPackageFrame = new CheckPackage();
    checkPackageFrame.setVisible(true);
        } else if (e.getSource() == bookButton) {
            BookPackage bookPackageFrame = new BookPackage();
			bookPackageFrame.setVisible(true);
        } else if (e.getSource() == destinationButton) {
            Destinationn destinationFrame = new Destinationn();
            destinationFrame.setVisible(true);
        } else if (e.getSource() == paymentButton) {
            Payment paymentFrame = new Payment();
			paymentFrame.setVisible(true);
        } else if (e.getSource() == contactButton) {
            ContactUs ContactUsFrame = new ContactUs();
    ContactUsFrame.setVisible(true);
        } else if (e.getSource() == aboutButton) {
            AboutUs AboutUsFrame = new AboutUs();
             AboutUsFrame.setVisible(true);
        } else if (e.getSource() == backButton) {
            //. action for backButton
        }
    }

    public static void main(String[] args) {
        Dashboard frame = new Dashboard();
        frame.setVisible(true);
    }
}