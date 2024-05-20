package Ship;

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;




public class Login extends JFrame implements ActionListener{
	
	private Container c;
	private JPanel panel1, panel2;
	private ImageIcon icon1;
	private JLabel imgLabel, userLabel, passLabel, forgetLabel;
	private Font font1;
	private JTextField userTf, passTf;
	private JButton button1, button2, button3;
	Login(){
		
		initComponents();
	}
	
	public void  initComponents(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350,200,900,400);
		this.setTitle("Login");
		
	    c= this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
	
		panel1 = new JPanel();
		panel1.setBounds(0,0 ,400,400);
		panel1.setLayout(null);
	    panel1.setBackground(new Color (131, 193, 233));
		c.add(panel1);
		
		
		icon1 = new ImageIcon(getClass().getResource("image/login.png"));
        Image image = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image);
		
		
		
		imgLabel = new JLabel(icon1);
		imgLabel.setBounds(100,120,200,200);
		panel1.add(imgLabel);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(400, 30, 450, 300);
		c.add(panel2);
		
		font1 = new Font("Arial", Font.BOLD, 20);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(60,20,100,25);
		userLabel.setFont(font1);
		panel2.add(userLabel);
		
		userTf = new JTextField();
		userTf.setBounds(60,60, 300, 30);
		userTf.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(userTf);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(60,110,100,25);
		passLabel.setFont(font1);
		panel2.add(passLabel);
		
		passTf = new JTextField();
		passTf.setBounds(60,150, 300, 30);
		passTf.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(passTf);
		
		button1 = new JButton("Login");
		button1.setBounds(60,200,130,30);
		button1.setBackground(new Color(133, 193, 233));
		button1.setForeground(Color.WHITE);
		button1.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(button1);
		
		button2 = new JButton("Signup");
		button2.setBounds(230,200,130,30);
		button2.setBackground(new Color(133, 193, 233));
		button2.setForeground(Color.WHITE);
		button2.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(button2);
		
		button3 = new JButton("Forget Password");
		button3.setBounds(130,270,130,30);
		button3.setBackground(new Color(133, 193, 233));
		button3.setForeground(Color.WHITE);
		button3.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(button3);
		
		forgetLabel = new JLabel("Trouble Login?");
		forgetLabel.setBounds(150,245,150,20);
		forgetLabel.setForeground(Color.RED);
		panel2.add(forgetLabel);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}
      
	     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) { // Login button
            String userName = userTf.getText().toLowerCase(); // User Name
            String password = passTf.getText(); // Password

            if (userName.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"));
                    String line;
                    boolean found = false;
                    while ((line = reader.readLine()) != null) {
                        if (line.equals("User Name : " + userName)) {
                            String passwordLine = reader.readLine();
                            if (passwordLine.equals("Password : " + password)) {
                                JOptionPane.showMessageDialog(null, "Login Successful.", "Travel Agency!", JOptionPane.INFORMATION_MESSAGE);
                                found = true;
                                setVisible(false);
                               // Packs frame = new Packs();
                              //  frame.setVisible(true);
                                break;
                            }
                        }
                    }
                    reader.close();
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == button2) { // Signup button
            this.setVisible(false);
            new SignUp2().setVisible(true);
        } 
        // Handle other button actions here if needed
    }
   public static void main(String[]args){
	   
	    Login frame = new Login();
		frame.setVisible(true);
	   
   }
}