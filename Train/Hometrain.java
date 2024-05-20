package Train;
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

public class Hometrain extends JFrame implements ActionListener {

    private Container c;
    private JPanel panel1;
    private JLabel imgLabel, headingLabel, hiconLabel, wcLabel, bookTicketLabel, confirmTicketLabel;
    private ImageIcon icon1, icon2;
    private Font font1, font2, font3;
    private JButton bookButton, payButton, logoutButton, backButton;

    public Hometrain() {
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

        icon1 = new ImageIcon(getClass().getResource("image/train.jpg"));
        Image image = icon1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image);

        imgLabel = new JLabel(icon1);
        imgLabel.setBounds(5, 0, 70, 70);
        panel1.add(imgLabel);

        font1 = new Font("Tahoma", Font.BOLD, 30);
        font2 = new Font("Tahoma", Font.PLAIN, 20);
        font3 = new Font("Arial", Font.BOLD, 30);

        headingLabel = new JLabel("Home");
        headingLabel.setBounds(80, 10, 300, 40);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(font1);
        panel1.add(headingLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1400, 10, 150, 45);
        logoutButton.setBackground(new Color(10, 32, 56));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(font2);
        panel1.add(logoutButton);

        wcLabel = new JLabel("Railway Tickets");
        wcLabel.setBounds(650, 100, 300, 40);
        wcLabel.setBackground(new Color(255, 215, 0));
        wcLabel.setForeground(Color.BLACK);
        wcLabel.setFont(new Font("Arial", Font.BOLD, 40));
        wcLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wcLabel);

        bookTicketLabel = new JLabel("Book your tickets from here");
        bookTicketLabel.setBounds(200, 250, 500, 40);
        bookTicketLabel.setForeground(Color.BLACK);
        bookTicketLabel.setFont(font3);
        c.add(bookTicketLabel);
		
        bookButton = new JButton("Book Tickets");
        bookButton.setBounds(200, 300, 500, 80);
        bookButton.setBackground(new Color(10, 32, 56));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(font2);
        c.add(bookButton);
		
		confirmTicketLabel = new JLabel("Confirm your ticket");
        confirmTicketLabel.setBounds(200, 450, 500, 40);
        confirmTicketLabel.setForeground(Color.BLACK);
        confirmTicketLabel.setFont(font3);
        c.add(confirmTicketLabel);

        payButton = new JButton("Payment");
       payButton.setBounds(200, 500, 500, 80);
        payButton.setBackground(new Color(10, 32, 56));
        payButton.setForeground(Color.WHITE);
        payButton.setFont(font2);
        c.add(payButton);

        backButton = new JButton("Back");
        backButton.setBounds(1300, 700, 150, 45);
        backButton.setBackground(new Color(10, 32, 56));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(font2);
        c.add(backButton);

        icon2 = new ImageIcon(getClass().getResource("image/home2.jpg"));
        Image img = icon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img);

        hiconLabel = new JLabel(icon2);
        hiconLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        c.add(hiconLabel);
        c.setComponentZOrder(hiconLabel, c.getComponentCount() - 1);
		
		bookButton.addActionListener(this);
	    payButton.addActionListener(this);
		backButton.addActionListener(this);
		logoutButton.addActionListener(this);
    }
      
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutButton) {
            System.exit(0);
        } else if (e.getSource() == bookButton) {
              BookTicket bookticketFrame = new BookTicket();
            bookticketFrame.setVisible(true);
        } else if (e.getSource() == payButton) {
               int TotalPrice = 1000;  
            Payment paymentFrame = new Payment(TotalPrice);
        } else if (e.getSource() == backButton) {
            // method for going back
        }
    }
	  
       public void trainMain() {
        Hometrain frame = new Hometrain();
        frame.setVisible(true);
    }
}
