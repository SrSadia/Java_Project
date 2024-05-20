package Train;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookTicket extends JFrame {

    private Container c;
    private JLabel textlbl, usernamelabel, selcpacklabel, personlabel, idlabel, maillabel, phonelabel, totallabel, timeDatelabel, routeLabel, backgroundLabel;
    private Font font1, font2, font3;
    private Choice chpack, personch;
    private JTextField tfUsername, tfId, tfEmail, tfPhone, tfPrice;
    private Cursor cursor;
    private JButton buttonBook, buttonBack;
    private JComboBox<String> dayComboBox, monthComboBox, yearComboBox, timeComboBox, routeComboBox;
    private ImageIcon icon1;

    BookTicket() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(350, 200, 1100, 500);
        this.setTitle("Book Packages");

        c = this.getContentPane();
        c.setLayout(null);
        
        ImageIcon icon2 = new ImageIcon(getClass().getResource("image/ticket.jpg"));
        Image img = icon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img);
        backgroundLabel = new JLabel(icon2);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        c.add(backgroundLabel);

        font1 = new Font("Tahoma", Font.BOLD, 20);
        font2 = new Font("Tahoma", Font.PLAIN, 16);
        font3 = new Font("Tahoma", Font.PLAIN, 12);

        textlbl = new JLabel("Book Packages");
        textlbl.setBounds(100, 10, 200, 30);
        textlbl.setFont(font1);
        backgroundLabel.add(textlbl);

        usernamelabel = new JLabel("Username");
        usernamelabel.setBounds(40, 70, 100, 20);
        usernamelabel.setFont(font2);
		 usernamelabel.setForeground(Color.WHITE);
        backgroundLabel.add(usernamelabel);

        tfUsername = new JTextField();
        tfUsername.setBounds(250, 70, 200, 20);
        tfUsername.setFont(font2);
        backgroundLabel.add(tfUsername);

        routeLabel = new JLabel("Select Route");
        routeLabel.setBounds(40, 110, 150, 20);
        routeLabel.setFont(font2);
		routeLabel.setForeground(Color.WHITE);
        backgroundLabel.add(routeLabel);

        String[] routes = { "Dhaka -> Chittagong", "Chittagong<- Dhaka", "Dhaka -> Rajshahi", "Rajshahi -> Dhaka", "Dhaka -> Sylhet", "Sylhet -> Dhaka"};
        routeComboBox = new JComboBox<>(routes);
        routeComboBox.setBounds(250, 110, 200, 25);
        backgroundLabel.add(routeComboBox);

        selcpacklabel = new JLabel("Select Package");
        selcpacklabel.setBounds(40, 150, 150, 20);
        selcpacklabel.setFont(font2);
		selcpacklabel.setForeground(Color.WHITE);
        backgroundLabel.add(selcpacklabel);

        chpack = new Choice();
        chpack.add("AC C");
        chpack.add("Snigdha");
        chpack.add("S Chair");
        chpack.setBounds(250, 150, 200, 20);
        backgroundLabel.add(chpack);

        personlabel = new JLabel("Total Person");
        personlabel.setBounds(40, 190, 150, 25);
        personlabel.setFont(font2);
		personlabel.setForeground(Color.WHITE);
        backgroundLabel.add(personlabel);

        personch = new Choice();
        personch.add("1");
        personch.add("2");
        personch.add("4");
        personch.setBounds(250, 190, 200, 25);
        backgroundLabel.add(personch);

        idlabel = new JLabel("ID");
        idlabel.setBounds(40, 230, 150, 20);
        idlabel.setFont(font2);
		idlabel.setForeground(Color.WHITE);
        backgroundLabel.add(idlabel);

        tfId = new JTextField();
        tfId.setBounds(250, 230, 200, 20);
        tfId.setFont(font2);
        backgroundLabel.add(tfId);

        maillabel = new JLabel("Email");
        maillabel.setBounds(40, 270, 150, 20);
        maillabel.setFont(font2);
		maillabel.setForeground(Color.WHITE);
        backgroundLabel.add(maillabel);

        tfEmail = new JTextField();
        tfEmail.setBounds(250, 270, 200, 20);
        tfEmail.setFont(font2);
        backgroundLabel.add(tfEmail);

        phonelabel = new JLabel("Phone");
        phonelabel.setBounds(40, 310, 150, 20);
        phonelabel.setFont(font2);
		phonelabel.setForeground(Color.WHITE);
        backgroundLabel.add(phonelabel);

        tfPhone = new JTextField();
        tfPhone.setBounds(250, 310, 200, 20);
        tfPhone.setFont(font2);
        backgroundLabel.add(tfPhone);

        timeDatelabel = new JLabel("Select Time and Date");
        timeDatelabel.setBounds(40, 350, 200, 25);
        timeDatelabel.setFont(font2);
		timeDatelabel.setForeground(Color.WHITE);
        backgroundLabel.add(timeDatelabel);

        String[] days = { "26", "27", "28", "29", "30", "31" , "1", "2"};
        String[] months = { "May", "June" };
        String[] years = { "2024" };

        dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(250, 350, 60, 25);
        backgroundLabel.add(dayComboBox);

        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(320, 350, 100, 25);
        backgroundLabel.add(monthComboBox);

        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(430, 350, 70, 25);
        backgroundLabel.add(yearComboBox);

        String[] times = { "08:00 AM", "02:00 PM", "04:00 PM", "11:00 PM" };
        timeComboBox = new JComboBox<>(times);
        timeComboBox.setBounds(510, 350, 100, 25);
        backgroundLabel.add(timeComboBox);

        totallabel = new JLabel("Total Price");
        totallabel.setBounds(40, 390, 150, 25);
        totallabel.setFont(font2);
        backgroundLabel.add(totallabel);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        tfPrice = new JTextField();
        tfPrice.setBounds(250, 390, 200, 25);
        tfPrice.setFont(font3);
        tfPrice.setForeground(Color.BLUE);
        tfPrice.setEditable(false);
        backgroundLabel.add(tfPrice);

        chpack.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateTotalPrice();
            }
        });

        personch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateTotalPrice();
            }
        });

        updateTotalPrice();

        buttonBook = new JButton("Buy");
        buttonBook.setBounds(40, 430, 100, 30);
        buttonBook.setFont(font2);
        buttonBook.setCursor(cursor);
        backgroundLabel.add(buttonBook);

        buttonBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isAnyFieldEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ticket booked successfully! Please go to the payment option to confirm your Ticket.");
                }
            }
        });

        buttonBack = new JButton("Back");
        buttonBack.setBounds(900, 430, 100, 30);
        buttonBack.setFont(font2);
        buttonBack.setCursor(cursor);
        backgroundLabel.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Hometrain hometrainFrame = new Hometrain();
                hometrainFrame.setVisible(true);
                
            }
        });
    }

    private void updateTotalPrice() {
        String selectedItem = chpack.getSelectedItem();
        int numPersons = Integer.parseInt(personch.getSelectedItem());

        if (selectedItem.equals("AC C")) {
            tfPrice.setText("Total: " + (750 * numPersons) + " TK");
        } else if (selectedItem.equals("Snigdha")) {
            tfPrice.setText("Total: " + (500 * numPersons) + " TK");
        } else if (selectedItem.equals("S Chair")) {
            tfPrice.setText("Total: " + (380 * numPersons) + " TK");
        }
    }

    private boolean isAnyFieldEmpty() {
        return tfUsername.getText().trim().isEmpty() ||
               tfId.getText().trim().isEmpty() ||
               tfEmail.getText().trim().isEmpty() ||
               tfPhone.getText().trim().isEmpty();
    }

    public static void main(String[] args) {
        BookTicket frame = new BookTicket();
        frame.setVisible(true);
    }
}
