package Ship;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;

public class CheckPackage extends JFrame {

    private Container c;
    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2;
    private JLabel label1, label2, label3, label4, label5, label6, imageLabel1, imageLabel2;
    private ImageIcon icon1, icon2;
    private Font font1, font2, font3;

    public CheckPackage() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(450, 200, 900, 600);
        this.setTitle("CheckPackage");

        c = this.getContentPane();
        tabbedPane = new JTabbedPane();

        // Panel 1
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);

        // Add the panel to the tabbed pane
        tabbedPane.addTab("Package 1", null, panel1, "Package 1");

        font1 = new Font("Tahoma", Font.BOLD, 30);
        font2 = new Font("Tahoma", Font.BOLD, 20);
        font3 = new Font("Tahoma", Font.BOLD, 10);

        label1 = new JLabel("Bay Cruise");
        label1.setBounds(50, 5, 300, 30);
        label1.setForeground(Color.yellow);
        label1.setFont(font1);
        panel1.add(label1);

        label2 = new JLabel("Teknaf to Saintmartin");
        label2.setBounds(30, 60, 300, 30);
        label2.setForeground(Color.RED);
        label2.setFont(font2);
        panel1.add(label2);

        label3 = new JLabel("Rojoni Gondha(Green Zone)= 1300TK");
        label3.setBounds(30, 110, 300, 30);
        label3.setForeground(Color.BLUE);
        label3.setFont(font3);
        panel1.add(label3);

        icon1 = new ImageIcon(getClass().getResource("image/teksain.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
       icon1 = new ImageIcon(image1);

       imageLabel1 = new JLabel(icon1);
        imageLabel1.setBounds(30, 150, 800, 400);
       panel1.add(imageLabel1);

        // Panel 2
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.WHITE);

        // Add the panel to the tabbed pane
        tabbedPane.addTab("Package 2", null, panel2, "Package 2");

        label4 = new JLabel("MV Bay One");
        label4.setBounds(50, 5, 300, 30);
        label4.setForeground(Color.yellow);
        label4.setFont(font1);
        panel2.add(label4);

        label5 = new JLabel("Chattogram to Saint Martin ");
        label5.setBounds(30, 60, 300, 30);
        label5.setForeground(Color.RED);
        label5.setFont(font2);
        panel2.add(label5);

        label6 = new JLabel("One Way: 2800 Taka");
        label6.setBounds(30, 110, 300, 30);
        label6.setForeground(Color.BLUE);
        label6.setFont(font3);
        panel2.add(label6);

      icon2 = new ImageIcon(getClass().getResource("image/ctgsain.jpg"));
        Image image2 = icon2.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
       icon2 = new ImageIcon(image2);

      imageLabel2 = new JLabel(icon2);
        imageLabel2.setBounds(30, 150, 800, 400);
       panel2.add(imageLabel2);

        c.add(tabbedPane);
    }

    public static void main(String[] args) {
        CheckPackage frame = new CheckPackage();
        frame.setVisible(true);
    }
}
