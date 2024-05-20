package Admin.CustomizePlane;

import Plane.CustomSizedBasePage;
import LogIn.FirstPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlaneCustomize extends CustomSizedBasePage implements ActionListener {
    private JLabel fromLabel, toLabel, className, date, seat, fromDisplay, toDisplay, classDisplay, dateDisplay,
            seatDisplay;
    private JTextField fromTextField, toTextField, classNameField, dateField, seatField;
    private JButton homeButton, addButton;

    public PlaneCustomize() {
        super("Plane Customization");

        fromLabel = new JLabel("From:");
        toLabel = new JLabel("To:");
        className = new JLabel("Class:");
        date = new JLabel("Date");
        seat = new JLabel("Seat");

        fromDisplay = new JLabel("From");
        toDisplay = new JLabel("To");
        classDisplay = new JLabel("Class");
        dateDisplay = new JLabel("Date");
        seatDisplay = new JLabel("Seat");

        addComponent(fromLabel, 25, 150, 80, 30);
        addComponent(toLabel, 25, 200, 80, 30);
        addComponent(className, 25, 250, 80, 30);
        addComponent(date, 25, 300, 80, 30);
        addComponent(seat, 25, 350, 80, 30);

        addComponent(fromDisplay, 420, 120, 80, 30);
        addComponent(toDisplay, 520, 120, 80, 30);
        addComponent(classDisplay, 620, 120, 80, 30);
        addComponent(dateDisplay, 720, 120, 80, 30);
        addComponent(seatDisplay, 820, 120, 80, 30);

        fromTextField = new JTextField();
        toTextField = new JTextField();
        classNameField = new JTextField();
        dateField = new JTextField();
        seatField = new JTextField();

        addComponent(fromTextField, 90, 150, 200, 30);
        addComponent(toTextField, 90, 200, 200, 30);
        addComponent(classNameField, 90, 250, 200, 30);
        addComponent(dateField, 90, 300, 200, 30);
        addComponent(seatField, 90, 350, 200, 30);

        homeButton = new JButton("Home");
        addButton = new JButton("Add");

        addComponent(homeButton, 140, 400, 100, 30);
        addComponent(addButton, 250, 400, 100, 30);

        homeButton.addActionListener(this);
        addButton.addActionListener(this);

        displaySavedDestinations();

        show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);

        } else if (e.getSource() == addButton) {
            String from = fromTextField.getText();
            String to = toTextField.getText();
            String className = classNameField.getText();
            String date = dateField.getText();
            String seat = seatField.getText();
            PlaneDestination.saveToFile(from, to, className, date, seat);

            fromTextField.setText("");
            toTextField.setText("");
            classNameField.setText("");
            dateField.setText("");
            seatField.setText("");

            PlaneCustomize planeCustomize = new PlaneCustomize();
            frame.setVisible(false);
        }

    }

    private void displaySavedDestinations() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PlaneDestination.txt"));
            StringBuilder fromDestinations = new StringBuilder();
            StringBuilder toDestinations = new StringBuilder();
            StringBuilder classDestinations = new StringBuilder();
            StringBuilder dateDestinations = new StringBuilder();
            StringBuilder seatDestinations = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 1) {
                    String from = parts[0];
                    String to = (parts.length >= 2) ? parts[1] : "";
                    String className = (parts.length >= 3) ? parts[2] : "";
                    String date = (parts.length >= 4) ? parts[3] : "";
                    String seat = (parts.length >= 5) ? parts[4] : "";

                    fromDestinations.append(from).append("\n");
                    toDestinations.append(to).append("\n");
                    classDestinations.append(className).append("\n");
                    dateDestinations.append(date).append("\n");
                    seatDestinations.append(seat).append("\n");
                }
            }

            reader.close();

            JTextArea fromTextArea = new JTextArea(fromDestinations.toString());
            fromTextArea.setEditable(false);
            JScrollPane fromScrollPane = new JScrollPane(fromTextArea);
            addComponent(fromScrollPane, 400, 150, 100, 300);

            JTextArea toTextArea = new JTextArea(toDestinations.toString());
            toTextArea.setEditable(false);
            JScrollPane toScrollPane = new JScrollPane(toTextArea);
            addComponent(toScrollPane, 500, 150, 100, 300);

            JTextArea classTextArea = new JTextArea(classDestinations.toString());
            classTextArea.setEditable(false);
            JScrollPane classScrollPane = new JScrollPane(classTextArea);
            addComponent(classScrollPane, 600, 150, 100, 300);

            JTextArea dateTextArea = new JTextArea(dateDestinations.toString());
            dateTextArea.setEditable(false);
            JScrollPane dateScrollPane = new JScrollPane(dateTextArea);
            addComponent(dateScrollPane, 700, 150, 100, 300);

            JTextArea seatTextArea = new JTextArea(seatDestinations.toString());
            seatTextArea.setEditable(false);
            JScrollPane seatScrollPane = new JScrollPane(seatTextArea);
            addComponent(seatScrollPane, 800, 150, 100, 300);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
