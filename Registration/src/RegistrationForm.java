import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.UUID;

public class RegistrationForm extends JFrame implements ActionListener {
    // Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mobile;
    private JTextField tmobile;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox<String> date;
    private JComboBox<String> month;
    private JComboBox<String> year;
    private JLabel address;
    private JTextArea taddress;
    private JCheckBox term;
    private JButton submit;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    // Constructor to initialize the components
    public RegistrationForm() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        container.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        container.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        container.add(tname);

        mobile = new JLabel("Mobile");
        mobile.setFont(new Font("Arial", Font.PLAIN, 20));
        mobile.setSize(100, 20);
        mobile.setLocation(100, 150);
        container.add(mobile);

        tmobile = new JTextField();
        tmobile.setFont(new Font("Arial", Font.PLAIN, 15));
        tmobile.setSize(150, 20);
        tmobile.setLocation(200, 150);
        container.add(tmobile);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        container.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        container.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        container.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 250);
        container.add(dob);

        String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31" };
        date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 250);
        container.add(date);

        String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec" };
        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(260, 250);
        container.add(month);

        String years[] = { "1990", "1991", "1992", "1993", "1994", "1995",
                "1996", "1997", "1998", "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010", "2011", "2012", "2013", "2014", "2015", "2016",
                "2017", "2018", "2019" };
        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(330, 250);
        container.add(year);

        address = new JLabel("Address");
        address.setFont(new Font("Arial", Font.PLAIN, 20));
        address.setSize(100, 20);
        address.setLocation(100, 300);
        container.add(address);

        taddress = new JTextArea();
        taddress.setFont(new Font("Arial", Font.PLAIN, 15));
        taddress.setSize(200, 75);
        taddress.setLocation(200, 300);
        taddress.setLineWrap(true);
        container.add(taddress);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        container.add(term);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(150, 450);
        submit.addActionListener(this);
        container.add(submit);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        container.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        container.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        container.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        container.add(resadd);

        setVisible(true);
    }

    // Method actionPerformed()
    // To get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (term.isSelected()) {
                String name = tname.getText();
                String mobile = tmobile.getText();
                String gender = male.isSelected() ? "Male" : "Female";
                String dob = (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem();
                String address = taddress.getText();

                String userData = "Name: " + name + "\n" +
                                  "Mobile: " + mobile + "\n" +
                                  "Gender: " + gender + "\n" +
                                  "DOB: " + dob + "\n" +
                                  "Address: " + address;

                int response = JOptionPane.showOptionDialog(
                        this,
                        userData,
                        "Confirm Registration",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new String[]{"Register", "Exit"},
                        "Register"
                );

                if (response == JOptionPane.YES_OPTION) {
                    boolean inserted = DatabaseConnection.insertUser(name, mobile, gender, dob, address);
                    if (inserted) {
                        res.setText("Registration Successfully..");
                        tout.setText(userData);
                      
                    } else {
                        res.setText("Failed to register..");
                    }
                } else if (response == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }

            } else {
                res.setText("Please accept the terms & conditions..");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            taddress.setText(def);
            tmobile.setText(def);
            res.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            tout.setText(def);
            resadd.setText(def);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}

class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASSWORD = "7804";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean insertUser(String name, String mobile, String gender, String dob, String address) {
        Connection conn = getConnection();
        if (conn != null) {
            String query = "INSERT INTO users (id, name, mobile, gender, dob, address) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                String id = UUID.randomUUID().toString();
                stmt.setString(1, id);
                stmt.setString(2, name);
                stmt.setString(3, mobile);
                stmt.setString(4, gender);
                stmt.setString(5, dob);
                stmt.setString(6, address);
                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}