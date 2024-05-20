package Bus;
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

public class Home extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel1;
    private JLabel labelImg, labelHeading, labelHcon, labelWc;
    private ImageIcon icon1, icon2;
    private Font font1, font2, font3;
    private JButton bookBut, payBut, logoutBut, backBut;

    public Home() {
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

        icon1 = new ImageIcon(getClass().getResource("image/bus.jpg"));
        Image image = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image);

        labelImg = new JLabel(icon1);
        labelImg.setBounds(5, 0, 70, 70);
        panel1.add(labelImg);

        font1 = new Font("Tahoma", Font.BOLD, 30);
        font2 = new Font("Tahoma", Font.PLAIN, 20);
        font3 = new Font("Arial", Font.BOLD, 30);

        labelHeading = new JLabel("Home");
        labelHeading.setBounds(80, 10, 300, 40);
        labelHeading.setForeground(Color.WHITE);
        labelHeading.setFont(font1);
        panel1.add(labelHeading);

        logoutBut = new JButton("Logout");
        logoutBut.setBounds(1400, 10, 150, 45);
        logoutBut.setBackground(new Color(10, 32, 56));
        logoutBut.setForeground(Color.WHITE);
        logoutBut.setFont(font2);
        panel1.add(logoutBut);

        labelWc = new JLabel("Welcome to Bus Ticket Booking");
        labelWc.setBounds(200, 100, 1400, 60);
        labelWc.setBackground(new Color(255, 215, 0));
        labelWc.setForeground(Color.BLACK);
        labelWc.setFont(new Font("Segoe UI", Font.BOLD, 40));
        labelWc.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(labelWc);

        bookBut = new JButton("Ticket Booking");
        bookBut.setBounds(200, 300, 500, 80);
        bookBut.setBackground(new Color(10, 32, 56));
        bookBut.setForeground(Color.WHITE);
        bookBut.setFont(font2);
        c.add(bookBut);

        payBut = new JButton("Payment");
        payBut.setBounds(900, 300, 500, 80);
        payBut.setBackground(new Color(10, 32, 56));
        payBut.setForeground(Color.WHITE);
        payBut.setFont(font2);
        c.add(payBut);

        backBut = new JButton("Back");
        backBut.setBounds(1300, 700, 150, 45);
        backBut.setBackground(new Color(10, 32, 56));
        backBut.setForeground(Color.WHITE);
        backBut.setFont(font2);
        c.add(backBut);

        icon2 = new ImageIcon(getClass().getResource("image/bus.jpg"));
        Image img = icon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img);

        labelHcon = new JLabel(icon2);
        labelHcon.setBounds(0, 0, this.getWidth(), this.getHeight());
        c.add(labelHcon);
        c.setComponentZOrder(labelHcon, c.getComponentCount() - 1);

        bookBut.addActionListener(this);
        payBut.addActionListener(this);
        backBut.addActionListener(this);
        logoutBut.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutBut) {
            System.exit(0);
        } else if (e.getSource() == bookBut) {
            BookingSeat bookingseatFrame = new BookingSeat();
            bookingseatFrame.setVisible(true);
        } else if (e.getSource() == payBut) {
            bKash bkashFrame = new bKash();
            bkashFrame.setVisible(true);
        } else if (e.getSource() == backBut) {
            // Implement back button functionality if needed
        }
    }

    public void start() {
        Home frame = new Home();
        frame.setVisible(true);
    }
}
