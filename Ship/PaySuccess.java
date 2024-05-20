package Ship;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private Container c;
    private JLabel label1, imgLabel;
    private Font font1, font2;
    private ImageIcon logo;
    private JButton btn1, nBtn;
    private Cursor cursor;

    PaySuccess() {
       
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Payment Successful");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        logo = new ImageIcon(getClass().getResource("image/paysuc.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(20, 78, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);
       
        font1 = new Font("Segoe UI Black", Font.PLAIN, 30);
        font2 = new Font("Segoe UI Black", Font.PLAIN, 20);

        label1 = new JLabel();
        label1.setText("Your Payment Has");
        label1.setBounds(430, 80, 500, 50);
        label1.setFont(font1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Successfully Completed.");
        label1.setBounds(430, 130, 500, 50);
        label1.setFont(font1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Happy Travel!");
		label1.setForeground(Color.RED);
        label1.setBounds(430, 180, 500, 50);
        label1.setFont(font1);
        c.add(label1);
        
        cursor = new Cursor(Cursor.HAND_CURSOR);

        btn1 = new JButton("Finish");
        btn1.setBounds(475, 310, 300, 50);
        btn1.setFont(font2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLUE);
        c.add(btn1);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              Payment paymentFrame = new Payment();
			paymentFrame.setVisible(true);
                dispose();
            }
        });
    }
    
    public static void main(String[] args) {

        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
