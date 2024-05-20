package Ship;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookPackage extends JFrame {

    private Container c;
    private JLabel text, lblusername, selcpacklbl, lblperson, lblid, labeemail, lblphone, lbltotal, lbltimeDate, backgroundLabel;
    private Font font1, font2, font3;
    private Choice chpack, personch;
    private JTextField tfusername, tfid, tfemail, tfphone, tfprice;
    private Cursor cursor;
    private JButton btnBook, btnBack;
    private JComboBox<String> dayComboBox, monthComboBox, yearComboBox, timeComboBox;
    private ImageIcon icon1;

    BookPackage() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(350, 200, 1100, 500);
        this.setTitle("Book Packages");

        c = this.getContentPane();
        c.setLayout(null);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("image/book.jpg"));
        Image img = icon2.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(img);
        backgroundLabel = new JLabel(icon2);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        c.add(backgroundLabel);

        font1 = new Font("Tahoma", Font.BOLD, 20);
        font2 = new Font("Tahoma", Font.PLAIN, 16);
        font3 = new Font("Tahoma", Font.PLAIN, 12);

        text = new JLabel("Book Packages");
        text.setBounds(100, 10, 200, 30);
        text.setFont(font1);
        backgroundLabel.add(text);

        lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(font2);
        backgroundLabel.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(250, 70, 200, 20);
        tfusername.setFont(font2);
        backgroundLabel.add(tfusername);

        selcpacklbl = new JLabel("Select Package");
        selcpacklbl.setBounds(40, 110, 150, 20);
        selcpacklbl.setFont(font2);
        backgroundLabel.add(selcpacklbl);

        chpack = new Choice();
        chpack.add("Bay Cruise");
        chpack.add("My Bay One");
        chpack.setBounds(250, 110, 200, 20);
        backgroundLabel.add(chpack);

        lblperson = new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 25);
        lblperson.setFont(font2);
        backgroundLabel.add(lblperson);

        personch = new Choice();
        personch.add("1");
        personch.add("2");
        personch.add("4");
        personch.setBounds(250, 150, 200, 25);
        backgroundLabel.add(personch);

        lblid = new JLabel("ID");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(font2);
        backgroundLabel.add(lblid);

        tfid = new JTextField();
        tfid.setBounds(250, 190, 200, 20);
        tfid.setFont(font2);
        backgroundLabel.add(tfid);

        labeemail = new JLabel("Email");
        labeemail.setBounds(40, 230, 150, 20);
        labeemail.setFont(font2);
        backgroundLabel.add(labeemail);

        tfemail = new JTextField();
        tfemail.setBounds(250, 230, 200, 20);
        tfemail.setFont(font2);
        backgroundLabel.add(tfemail);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(font2);
        backgroundLabel.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(250, 270, 200, 20);
        tfphone.setFont(font2);
        backgroundLabel.add(tfphone);

        lbltimeDate = new JLabel("Select Time and Date");
        lbltimeDate.setBounds(40, 310, 200, 25);
        lbltimeDate.setFont(font2);
        backgroundLabel.add(lbltimeDate);

        String[] days = { "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        String[] months = { "May", "June", "July", "August", "September", "October", "November", "December" };
        String[] years = { "2024" };

        dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(250, 310, 60, 25);
        backgroundLabel.add(dayComboBox);

        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(320, 310, 100, 25);
        backgroundLabel.add(monthComboBox);

        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(430, 310, 70, 25);
        backgroundLabel.add(yearComboBox);

        String[] times = { "10:00 AM", "12:00 PM", "02:00 PM", "04:00 PM" };
        timeComboBox = new JComboBox<>(times);
        timeComboBox.setBounds(510, 310, 100, 25);
        backgroundLabel.add(timeComboBox);

        lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 350, 150, 25);
        lbltotal.setFont(font2);
        backgroundLabel.add(lbltotal);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        tfprice = new JTextField();
        tfprice.setBounds(250, 350, 200, 25);
        tfprice.setFont(font3);
        tfprice.setForeground(Color.RED);
        tfprice.setEditable(false);
        backgroundLabel.add(tfprice);

        chpack.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateTotalPrice();
            }
        });

        personch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateTotalPrice();
            }
        });

        updateTotalPrice();

        btnBook = new JButton("Book");
        btnBook.setBounds(40, 400, 100, 30);
        btnBook.setFont(font2);
        btnBook.setCursor(cursor);
        backgroundLabel.add(btnBook);

        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAnyFieldEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                } else {
                    JOptionPane.showMessageDialog(null, "Package booked successfully! Please go to the payment option to confirm your package.");
                }
            }
        });

        btnBack = new JButton("Back");
        btnBack.setBounds(900, 400, 100, 30);
        btnBack.setFont(font2);
        btnBack.setCursor(cursor);
        backgroundLabel.add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assuming Dashboard is another JFrame
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                dispose();
            }
        });
    }

    private void updateTotalPrice() {
        String selectedItem = chpack.getSelectedItem();
        int numPersons = Integer.parseInt(personch.getSelectedItem());

        if (selectedItem.equals("Bay Cruise")) {
            tfprice.setText("Total: " + (1300 * numPersons) + " TK");
        } else if (selectedItem.equals("My Bay One")) {
            tfprice.setText("Total: " + (2800 * numPersons) + " TK");
        }
    }

    private boolean isAnyFieldEmpty() {
        return tfusername.getText().trim().isEmpty() ||
               tfid.getText().trim().isEmpty() ||
               tfemail.getText().trim().isEmpty() ||
               tfphone.getText().trim().isEmpty();
    }

    public static void main(String[] args) {
        BookPackage frame = new BookPackage();
        frame.setVisible(true);
    }
}
