package Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Destinationn extends JFrame {

    private Container c;
    private JLabel imgLabel, cityLabel;
    private ImageIcon[] images;
    private String[] cityNames;
    private int currentIndex = 0;
    private Timer timer;

    Destinationn() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(500, 200, 800, 600);
        this.setTitle("Destination");

        c = this.getContentPane();
        c.setLayout(null);

        images = new ImageIcon[]{
                new ImageIcon(new ImageIcon(getClass().getResource("image/saint.jpg")).getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon(getClass().getResource("image/ctgsain2.jpg")).getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)),
        };

        cityNames = new String[]{
                "Teknaf to ST Martin ",
                "Chittagong to ST Martin",
               
        };

        
        imgLabel = new JLabel(images[currentIndex]);
        imgLabel.setBounds(0, 0, 800, 600);
        c.add(imgLabel);

        cityLabel = new JLabel(cityNames[currentIndex], SwingConstants.CENTER);
        cityLabel.setBounds(0, 500, 800, 50);
        cityLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        cityLabel.setForeground(Color.WHITE);
        cityLabel.setBackground(new Color(0, 0, 0, 150)); 
        cityLabel.setOpaque(true);
        c.add(cityLabel);

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % images.length;
                imgLabel.setIcon(images[currentIndex]);
                cityLabel.setText(cityNames[currentIndex]);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        Destinationn frame = new Destinationn();
        frame.setVisible(true);
    }
	 public void closeDestinationFrame() {
        this.dispose();
    }

}
