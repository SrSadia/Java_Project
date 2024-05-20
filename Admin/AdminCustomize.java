package Admin;

import Plane.CustomSizedBasePage;








//import SHIP.FILE NAME OR CLASS NAME;
//import BUS.FILE NAME OR CLASS NAME;
//import TRAIN.FILENAME OR CLASS NAME;






import LogIn.FirstPage;
import Admin.CustomizePlane.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminCustomize extends CustomSizedBasePage implements ActionListener {
    public JButton planeButton, busButton, homeButton, trainButton, shipButton;
    public JLabel titleLabel;

    public AdminCustomize() {
        super("Admin Customization");
        Font font = new Font("Arial", Font.BOLD, 24);

        titleLabel = new JLabel("What do you want to customize?");
        titleLabel.setFont(font);
        addComponent(titleLabel, 280, 50, 500, 50);

        planeButton = new JButton("Plane");
        busButton = new JButton("Bus");
        trainButton = new JButton("Train");
        shipButton = new JButton("Ship");
        homeButton = new JButton("Home");

        addComponent(planeButton, 330, 150, 250, 50);
        addComponent(busButton, 330, 200, 250, 50);
        addComponent(trainButton, 330, 250, 250, 50);
        addComponent(shipButton, 330, 300, 250, 50);
        addComponent(homeButton, 330, 250, 250, 35);

        planeButton.addActionListener(this);
        busButton.addActionListener(this);
        trainButton.addActionListener(this);
        shipButton.addActionListener(this);
        homeButton.addActionListener(this);

        show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == planeButton) {
            PlaneCustomize planeCustomizePage = new PlaneCustomize();
            frame.setVisible(false);
        } 









        
        else if (e.getSource() == busButton) {
        //BUS CUSTOMIZE




        
        } 
        else if (e.getSource() == trainButton) {
        //TRAIN CUSTOMIZE 





        } 
        else if (e.getSource() == shipButton) {
        //SHIP CUSTOMIZE






        } 
        
        
        
        
        
        
        
        else if (e.getSource() == homeButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }
    }
}
