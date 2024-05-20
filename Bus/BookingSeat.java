package Bus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingSeat extends JFrame implements ActionListener {
    
    private bKash bkash;

    JFrame f;
    JLabel fromLabel, toLabel, dateLabel, busTypeLabel, passengerNoLabel, seatLabel, title, totalPriceLabel;
    JComboBox<String> fromBox, toBox, busTypeBox, dateBox, passengerBox;
    JPanel seatPanel;
    JButton next, previous, exit;
    int acPrice = 1300;
    int nonAcPrice = 720;

    public BookingSeat() {
        super("Bus Reservation");
        super.setSize(750, 670);
        super.setLocation(395, 10);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Booking Bus Seat");
        title.setBounds(110, 40, 700, 50);
        title.setFont(new Font("Cambria", Font.BOLD, 30));
        super.add(title);


        Font font = new Font("Serif", Font.BOLD, 22);

        f = new JFrame();

        title = new JLabel("Complete Your Ticket Information");
        title.setBounds(300, 20, 400, 50);
        title.setFont(font);
        f.add(title);

        String[] str1 = { "Dhaka", "Rangpur", "Sylhet", "Chittagong", "Rajshahi", "Jashore" };
        fromBox = new JComboBox<>(str1);
        fromBox.setBounds(350, 120, 190, 30);
        fromBox.setBackground(Color.WHITE);
        f.add(fromBox);

        fromLabel = new JLabel("From");
        fromLabel.setBounds(220, 120, 190, 30);
        fromLabel.setForeground(Color.BLACK);
        f.add(fromLabel);

        String[] str2 = { "Dhaka", "Rangpur", "Sylhet", "Chittagong", "Rajshahi", "Jashore" };
        toBox = new JComboBox<>(str2);
        toBox.setBounds(350, 170, 190, 30);
        toBox.setBackground(Color.WHITE);
        f.add(toBox);

        toLabel = new JLabel("To");
        toLabel.setBounds(220, 170, 190, 30);
        toLabel.setForeground(Color.BLACK);
        f.add(toLabel);

        String[] str7 = { "9 September", "10 September", "11 September", "12 September", "13 September", "14 September", "15 September", "16 September", "17 September", "18 September" };
        dateBox = new JComboBox<>(str7);
        dateBox.setBounds(350, 220, 190, 30);
        dateBox.setBackground(Color.WHITE);
        f.add(dateBox);

        dateLabel = new JLabel("Date");
        dateLabel.setBounds(220, 220, 190, 30);
        dateLabel.setForeground(Color.BLACK);
        f.add(dateLabel);

        String[] str4 = { "AC", "NON AC" };
        busTypeBox = new JComboBox<>(str4);
        busTypeBox.setBounds(350, 270, 190, 30);
        busTypeBox.setBackground(Color.WHITE);
        busTypeBox.addActionListener(this);
        f.add(busTypeBox);

        busTypeLabel = new JLabel("Bus Type");
        busTypeLabel.setBounds(220, 270, 190, 30);
        busTypeLabel.setForeground(Color.BLACK);
        f.add(busTypeLabel);

        String[] str5 = { "1", "2", "3", "4", "5", "6" };
        passengerBox = new JComboBox<>(str5);
        passengerBox.setBounds(350, 320, 190, 30);
        passengerBox.setBackground(Color.WHITE);
        passengerBox.addActionListener(this);
        f.add(passengerBox);

        passengerNoLabel = new JLabel("Number of Passengers");
        passengerNoLabel.setBounds(220, 320, 190, 30);
        passengerNoLabel.setForeground(Color.BLACK);
        f.add(passengerNoLabel);

        seatPanel = new JPanel();
        seatPanel.setBounds(220, 370, 400, 100);
        seatPanel.setLayout(new GridLayout(0, 4, 5, 5));
        f.add(seatPanel);

        totalPriceLabel = new JLabel("Total Price: 0");
        totalPriceLabel.setBounds(220, 480, 190, 30);
        totalPriceLabel.setForeground(Color.BLACK);
        f.add(totalPriceLabel);

        previous = new JButton("PREVIOUS");
        previous.setBounds(340, 520, 110, 25);
        previous.addActionListener(this);
        f.add(previous);

        next = new JButton("NEXT");
        next.setBounds(465, 520, 77, 25);
        next.addActionListener(this);
        f.add(next);

        exit = new JButton("EXIT");
        exit.setBounds(380, 560, 110, 25);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        f.add(exit);

        f.setSize(900, 650);
        f.setTitle("Bus Reservation");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon background_image = new ImageIcon("image/Bus6.jpg");

        ImageIcon logo = new ImageIcon("image/Bus6.jpg");
        f.setIconImage(logo.getImage());

        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        f.add(background);
        f.setVisible(true);

        updateSeatsAndPrice();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previous) {
            f.setVisible(false);
            new Home();
        } else if (e.getSource() == next) {
            String from = fromBox.getSelectedItem().toString();
            String to = toBox.getSelectedItem().toString();
            if (!validationCheck(from, to)) {
                JOptionPane.showMessageDialog(null, "Please select journey start city and end city properly");
            } else {
                f.setVisible(false);
                new bKash();
            }
        } else if (e.getSource() == exit) {
            f.dispose();
        } else if (e.getSource() == passengerBox || e.getSource() == busTypeBox) {
            updateSeatsAndPrice();
        }
    }

    public boolean validationCheck(String from, String to) {
        return !from.equals(to);
    }

    private void updateSeatsAndPrice() {
        seatPanel.removeAll();
        int numPassengers = Integer.parseInt(passengerBox.getSelectedItem().toString());
        String[] seats = { "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "D4", "E1", "E2", "E3", "E4", "F1", "F2", "F3", "F4" };

        for (int i = 0; i < numPassengers; i++) {
            JComboBox<String> seatBox = new JComboBox<>(seats);
            seatPanel.add(seatBox);
        }

        seatPanel.revalidate();
        seatPanel.repaint();

        int pricePerPerson = busTypeBox.getSelectedItem().equals("AC") ? acPrice : nonAcPrice;
        int totalPrice = numPassengers * pricePerPerson;
        totalPriceLabel.setText("Total Price: " + totalPrice);
    }

    public static void main(String[] args) {
        new BookingSeat();
    }
}
