package LogIn;

import Plane.TicketBookingPage;
import Bus.*;
import Ship.*;
import Train.*;




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondPage implements ActionListener {

    JFrame frame = new JFrame("Travel Agency Management System");

    JButton planeButton = new JButton("Plane");
    JButton busButton = new JButton("Bus");
    JButton trainButton = new JButton("Train");
    JButton shipButton = new JButton("Ship");


    JButton previousButton = new JButton("Previous");
    JButton logoutButton = new JButton("Log out");

    Font font = new Font("Arial", Font.BOLD, 25);

    JLabel name1 = new JLabel("How would you like");
    JLabel name2 = new JLabel("to embark");
    JLabel name3 = new JLabel("on your journey?");

    public SecondPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.setLayout(null);


        ImageIcon background_image = new ImageIcon("Login/Picture/SecondPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1000, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1000, 650);
        frame.setContentPane(background);





        name1.setBounds(120, 160, 300, 30);
        name2.setBounds(165, 200, 300, 30);
        name3.setBounds(137, 240, 300, 30);

        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);



        planeButton.setBounds(650, 150, 200, 60);


        trainButton.setBounds(650, 220, 200, 60);
        shipButton.setBounds(650, 290, 200, 60);
        busButton.setBounds(650, 360, 200, 60);
        previousButton.setBounds(50, 500, 100, 40);
        logoutButton.setBounds(850, 500, 100, 40); 
        

        frame.add(name1);
        frame.add(name2);
        frame.add(name3);
        frame.add(planeButton);

        frame.add(busButton);
        frame.add(trainButton);
        frame.add(shipButton);
        frame.add(previousButton);
        frame.add(logoutButton);

        frame.setVisible(true);

        busButton.addActionListener(this);
        planeButton.addActionListener(this);
        trainButton.addActionListener(this);
        shipButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == planeButton) {
            TicketBookingPage ticketBookingPage = new TicketBookingPage();
            ticketBookingPage.setVisibility();
            frame.setVisible(false);
        }
        if (e.getSource() == trainButton) {
            Hometrain homeTrain = new Hometrain();
            homeTrain.trainMain();
            frame.setVisible(false);
        }
            if (e.getSource() == shipButton) {
            Splash splash = new Splash();
            splash.setVisible(true);
            frame.setVisible(false);
        }
            if (e.getSource() == busButton) {
            Home home = new Home();
            home.start();
            frame.setVisible(false);
        }

        if (e.getSource() == previousButton) {

            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }
        if (e.getSource() == logoutButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }
    }
}
