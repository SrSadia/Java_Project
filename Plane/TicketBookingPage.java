package Plane;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import LogIn.FirstPage;
import LogIn.SecondPage;

public class TicketBookingPage extends CustomSizedBasePage implements ActionListener {
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> classComboBox;
    private JComboBox<String> seatComboBox;
    private JButton nextButton;
    private JButton previousButton;
    private JButton logoutButton;

    public TicketBookingPage() {
        super("Ticket Booking");

        ImageIcon background_image = new ImageIcon("Plane/Picture/TicketBookingPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        fromComboBox = new JComboBox<>();
        toComboBox = new JComboBox<>();
        classComboBox = new JComboBox<>();
        dateComboBox = new JComboBox<>();
        seatComboBox = new JComboBox<>();

        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        logoutButton = new JButton("Logout");

        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        addComponent(new JLabel("From:"), 620, 105, 100, 30);
        addComponent(fromComboBox, 660, 105, 200, 35);

        addComponent(new JLabel("To:"), 620, 155, 100, 30);
        addComponent(toComboBox, 660, 150, 200, 35);

        addComponent(new JLabel("Date:"), 620, 210, 100, 30);
        addComponent(dateComboBox, 660, 200, 200, 35);

        addComponent(new JLabel("Class:"), 620, 250, 100, 30);
        addComponent(classComboBox, 660, 250, 200, 35);

        addComponent(new JLabel("Seat:"), 620, 300, 100, 30);
        addComponent(seatComboBox, 660, 300, 200, 35);

        addComponent(nextButton, 780, 550, 100, 35);
        addComponent(previousButton, 10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);

        addComponent(background, 0, 0, 900, 650);

        frame.setVisible(false);

        populateComboBoxes();
    }

    private void populateComboBoxes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PlaneDestination.txt"));
            ArrayList<String> fromDestinations = new ArrayList<>();
            ArrayList<String> toDestinations = new ArrayList<>();
            ArrayList<String> classDestinations = new ArrayList<>();
            ArrayList<String> dateDestinations = new ArrayList<>();
            ArrayList<String> seatDestinations = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    fromDestinations.add(parts[0]);
                    toDestinations.add(parts[1]);
                    classDestinations.add(parts[2]);
                    dateDestinations.add(parts[3]);
                    seatDestinations.add(parts[4]);
                }
            }

            reader.close();

            fromComboBox.setModel(new DefaultComboBoxModel<>(fromDestinations.toArray(new String[0])));
            toComboBox.setModel(new DefaultComboBoxModel<>(toDestinations.toArray(new String[0])));
            classComboBox.setModel(new DefaultComboBoxModel<>(classDestinations.toArray(new String[0])));
            dateComboBox.setModel(new DefaultComboBoxModel<>(dateDestinations.toArray(new String[0])));
            seatComboBox.setModel(new DefaultComboBoxModel<>(seatDestinations.toArray(new String[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSelectedFrom() {
        return (String) fromComboBox.getSelectedItem();
    }

    public String getSelectedTo() {
        return (String) toComboBox.getSelectedItem();
    }

    public String getSelectedDate() {
        return (String) dateComboBox.getSelectedItem();
    }

    public String getSelectedClass() {
        return (String) classComboBox.getSelectedItem();
    }
    public String getSelectedSeat() {
        return (String) seatComboBox.getSelectedItem();
    }

    public void addActionListenerToNextButton(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void setVisibility() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            String selectedFrom = getSelectedFrom();
            String selectedTo = getSelectedTo();
            String selectedClass = getSelectedClass();

            CalculateCost costCalculator = new CalculateCost(selectedFrom, selectedTo, selectedClass);
            double calculatedCost = costCalculator.calculateCost();

            JOptionPane.showMessageDialog(null, "Your calculated cost is: $" + calculatedCost);

            frame.setVisible(false);
            PassengerInfoPage passengerInfoPage = new PassengerInfoPage();
            passengerInfoPage.show();
        }

        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            FirstPage firstPage = new FirstPage();
        }

        if (e.getSource() == previousButton) {
            frame.setVisible(false);
            SecondPage secondPage = new SecondPage();
        }
    }
}
