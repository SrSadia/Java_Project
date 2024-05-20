package Ship;

import javax.swing.*;
import java.awt.*;

public class AboutUs extends JFrame {

    public AboutUs() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("About Us");
        setSize(800, 600);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

     
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        JLabel headlineLabel = new JLabel("About Us");
        headlineLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(headlineLabel, BorderLayout.NORTH);

        JTextArea aboutTextArea = new JTextArea();
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setWrapStyleWord(true);
        aboutTextArea.setEditable(false);
        aboutTextArea.setText("All rights Reserved. We are one of the popular ship/launch ticket booking service for making people journey easiier, safer and better. Book our special packages, tickets within just some clicks.\nFor any query, Inform us in our \"Contact Us\" option.\nHave a safe and pleasant journey.");

      
        int numLines = aboutTextArea.getLineCount();
        int lineHeight = aboutTextArea.getFontMetrics(aboutTextArea.getFont()).getHeight();
        int preferredHeight = lineHeight * numLines;
        aboutTextArea.setPreferredSize(new Dimension(300, preferredHeight));

        JScrollPane scrollPane = new JScrollPane(aboutTextArea); 
        textPanel.add(scrollPane, BorderLayout.CENTER);

        add(textPanel, BorderLayout.WEST);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("image/about.png"));
        Image img = backgroundImage.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(img);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        add(backgroundLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        AboutUs aboutUs = new AboutUs();
        aboutUs.setVisible(true);
    }
}
