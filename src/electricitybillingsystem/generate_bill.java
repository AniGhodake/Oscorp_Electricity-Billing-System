package electricitybillingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class generate_bill extends JFrame implements ActionListener {
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1, c2;
    JPanel p1;

    generate_bill() {
        setSize(500, 650);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Select Meter No. and Month");
        Font f8 = new Font("Comic Sans MS", Font.BOLD, 18);
        l1.setFont(f8);
        l1.setForeground(Color.black);
        l1.setBackground(Color.gray);

        c1 = new Choice();
        c2 = new Choice();

        for (int i = 16001; i <= 16020; i++) {
            c1.add(String.valueOf(i));
        }

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        for (String month : months) {
            c2.add(month);
        }

        t1 = new JTextArea(50, 15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        t1.setBackground(Color.white);
        t1.setForeground(Color.black);

        b1 = new JButton("GENERATE BILL & PRINT");
        Font f1 = new Font("Comic Sans MS", Font.BOLD, 16);
        b1.setFont(f1);
        b1.setForeground(Color.black);
        b1.setBackground(Color.lightGray);

        p1.add(l1);
        p1.add(c1);
        p1.add(c2);
        add(p1, "North");
        add(jsp, "Center");
        add(b1, "South");

        b1.addActionListener(this);

        setLocation(450, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c = new conn();
            String meter = c1.getSelectedItem();
            String month = c2.getSelectedItem();

            t1.setText("\n\tOSCORP POWER LIMITED\nELECTRICITY BILL FOR THE MONTH OF " + month + " ,2019\n\n\n");

            ResultSet rs = c.s.executeQuery("SELECT * FROM newcustomer WHERE MeterNumber='" + meter + "'");
            if (rs.next()) {
                t1.append("\n    Customer Name :         " + rs.getString("Name"));
                t1.append("\n    Meter Number :          " + rs.getString("MeterNumber"));
                t1.append("\n    Address :               " + rs.getString("Address"));
                t1.append("\n    State :                 " + rs.getString("State"));
                t1.append("\n    City :                  " + rs.getString("City"));
                t1.append("\n    Email :                 " + rs.getString("Email"));
                t1.append("\n    Phone Number:           " + rs.getString("Phone"));
                t1.append("\n*************************************************\n");
            }

            rs = c.s.executeQuery("SELECT * FROM meterinfo WHERE MeterNumber='" + meter + "'");
            if (rs.next()) {
                t1.append("\n    Meter Location: " + rs.getString("MeterLocation"));
                t1.append("\n    Meter Type:     " + rs.getString("MeterType"));
                t1.append("\n    Phase Code:     " + rs.getString("PhaseCode"));
                t1.append("\n    Bill Type:      " + rs.getString("BillType"));
                t1.append("\n    Days:           " + rs.getString("Days"));
                t1.append("\n***************************************************\n\n");
            }

            rs = c.s.executeQuery("SELECT * FROM tax");
            if (rs.next()) {
                t1.append("\n    Meter Rent:     \t" + rs.getString("MeterRent"));
                t1.append("\n    Service Charge: \t" + rs.getString("ServiceCharge"));
                t1.append("\n    Service Tax:    \t" + rs.getString("ServiceTax"));
                t1.append("\n    Swacch Bharat:  \t" + rs.getString("SwacchBharatTax"));
                t1.append("\n    Fixed Tax:      \t" + rs.getString("FixedTax"));
                t1.append("\n");
            }

            rs = c.s.executeQuery("SELECT * FROM bill WHERE MeterNumber='" + meter + "' AND Month='" + month + "'");
            if (rs.next()) {
                t1.append("\n    Current Month : \t" + rs.getString("Month"));
                t1.append("\n    Units Consumed:\t" + rs.getString("Unit"));
                t1.append("\n    Total Charges :\t" + rs.getString("TotalBill"));
                t1.append("\n********************************************************");
                t1.append("\n    TOTAL PAYABLE :\t" + rs.getString("TotalBill"));
            }

            t1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generate_bill().setVisible(true);
    }
}
