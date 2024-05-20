package LogIn;

import Admin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {
    JButton logIn = new JButton("Log In");
    JButton createAccount = new JButton("Create Account");
    JButton adminButton = new JButton("Admin LogIn");
 

    JTextField userName = new JTextField("User Name", 15);
    JPasswordField passWord = new JPasswordField(15);

    public FirstPage() {
        setTitle("Travel Agency Management System");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel wlc = new JLabel("Welcome to our Travel Agency Management System!");
        Font font = new Font("Arial", Font.BOLD, 25);
        wlc.setFont(font);

        JLabel description1 = new JLabel("Are you ready to embark on an extraordinary journey?");
        JLabel description2 = new JLabel("Our Travel Agency Management System offers a world of");
        JLabel description3 = new JLabel("possibilities, enabling you to explore the globe like");
        JLabel description4 = new JLabel("never before. Whether you dream of soaring through the");
        JLabel description5 = new JLabel("skies on a plane, embracing the scenic routes of trains,");
        JLabel description6 = new JLabel("or immersing yourself in the charm of bus travel, our");
        JLabel description7 = new JLabel("platform caters to all your wanderlust desires.");

        ImageIcon background_image = new ImageIcon("Login/Picture/LoginPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);

        setLayout(null);
        add(wlc);
        add(description1);
        add(description2);
        add(description3);
        add(description4);
        add(description5);
        add(description6);
        add(description7);
        add(logIn);
        add(createAccount);
        add(adminButton);

        add(userName);
        add(passWord);
        add(background);

        wlc.setBounds(30, 20, 800, 30);
        description1.setBounds(30, 55, 850, 15);
        description2.setBounds(30, 72, 850, 15);
        description3.setBounds(30, 89, 850, 15);
        description4.setBounds(30, 106, 850, 15);
        description5.setBounds(30, 123, 850, 15);
        description6.setBounds(30, 140, 850, 15);
        description7.setBounds(30, 157, 850, 15);

        logIn.setBounds(450, 330, 150, 40);
        createAccount.setBounds(600, 330, 150, 40);
        adminButton.setBounds( 780, 0, 100, 35);

        userName.setBounds(450, 230, 300, 50);
        passWord.setBounds(450, 278, 300, 50);
        background.setBounds(0, 0, 900, 650);

        logIn.addActionListener(this);
        createAccount.addActionListener(this);
        adminButton.addActionListener(this);


        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logIn) {
            String enteredName = userName.getText();
            String enteredPassword = new String(passWord.getPassword());

            
            int loginStatus = UserInformation.checkUser(enteredName, enteredPassword, "users.txt");

            if (loginStatus == 1) {
                // Successful
                
                SecondPage secondPage = new SecondPage();
                setVisible(false);
            } else if (loginStatus == 2) {
                // Incorrect password
                JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // User not found
                JOptionPane.showMessageDialog(this, "User not found. Please create an account or check your credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == createAccount) {
            CreateAccount createAccount = new CreateAccount();
            setVisible(false);
        }
        if (e.getSource() == adminButton) {
            Admin adminPage = new Admin();
        
            setVisible(false);
        }


    }


}
