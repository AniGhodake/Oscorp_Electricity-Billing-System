/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// package electricitybillingsystem;


// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;
// import java.sql.*;

// public class LastBill extends JFrame implements ActionListener{
//     JLabel l1;
//     JTextArea t1;
//     JButton b1;
//     Choice c1;
//     JPanel p1;
//     LastBill(){
//         setSize(500,900);
//         setLayout(new BorderLayout());

//         p1 = new JPanel();

//         l1 = new JLabel("Generate Bill");

//         c1 = new Choice();

//         c1.add("1001");
//         c1.add("1002");
//         c1.add("1003");
//         c1.add("1004");
//         c1.add("1005");
//         c1.add("1006");
//         c1.add("1007");
//         c1.add("1008");
//         c1.add("1009");
//         c1.add("1010");


//         t1 = new JTextArea(50,15);
//         JScrollPane jsp = new JScrollPane(t1);
//         t1.setFont(new Font("Senserif",Font.ITALIC,18));

//         b1 = new JButton("Generate Bill");

//         p1.add(l1);
//         p1.add(c1);
//         add(p1,"North");

//         add(jsp,"Center");
//         add(b1,"South");

//         b1.addActionListener(this);

//         setLocation(350,40);
//     }
//     public void actionPerformed(ActionEvent ae){
//         try{
//             conn c = new conn();

//             ResultSet rs = c.s.executeQuery("select * from emp where meter_number="+c1.getSelectedItem());

//             if(rs.next()){
//                 t1.append("\n    Customer Name:"+rs.getString("name"));
//                 t1.append("\n    Meter Number:  "+rs.getString("meter_number"));
//                 t1.append("\n    Address:            "+rs.getString("address"));
//                 t1.append("\n    State:                 "+rs.getString("state"));
//                 t1.append("\n    City:                   "+rs.getString("city"));
//                 t1.append("\n    Email:                "+rs.getString("email"));
//                 t1.append("\n    Phone Number  "+rs.getString("phone"));
//                 t1.append("\n-------------------------------------------------------------");
//                 t1.append("\n");
//             }

//             t1.append("Details of the Last Bills\n\n\n");

//             rs = c.s.executeQuery("select * from bill where meter_number="+c1.getSelectedItem());

//             while(rs.next()){
//                 t1.append("       "+ rs.getString("Month") + "           " +rs.getString("TotalBill") + "\n");
//             }






//         }catch(Exception e){
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args){
//         new LastBill().setVisible(true);
//     }
// }


package electricitybillingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LastBill extends JFrame implements ActionListener {
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1;
    JPanel p1;

    LastBill() {
        setSize(500, 900);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Generate Bill");

        c1 = new Choice();
        for (int i = 16001; i <= 16020; i++) {
            c1.add(String.valueOf(i));
        }

        t1 = new JTextArea(50, 15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Serif", Font.ITALIC, 18));

        b1 = new JButton("Generate Bill");

        p1.add(l1);
        p1.add(c1);
        add(p1, "North");
        add(jsp, "Center");
        add(b1, "South");

        b1.addActionListener(this);

        setLocation(350, 40);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c = new conn();
            String meter = c1.getSelectedItem();

            ResultSet rs = c.s.executeQuery("SELECT * FROM newcustomer WHERE MeterNumber='" + meter + "'");
            if (rs.next()) {
                t1.setText(""); // Clear previous content
                t1.append("\n    Customer Name: " + rs.getString("Name"));
                t1.append("\n    Meter Number:  " + rs.getString("MeterNumber"));
                t1.append("\n    Address:       " + rs.getString("Address"));
                t1.append("\n    State:         " + rs.getString("State"));
                t1.append("\n    City:          " + rs.getString("City"));
                t1.append("\n    Email:         " + rs.getString("Email"));
                t1.append("\n    Phone Number:  " + rs.getString("Phone"));
                t1.append("\n-------------------------------------------------------------\n");
            }

            t1.append("Details of the Last Bills\n\n");

            rs = c.s.executeQuery("SELECT * FROM bill WHERE MeterNumber='" + meter + "'");
            while (rs.next()) {
                t1.append("  " + rs.getString("Month") + "   -   ₹" + rs.getString("TotalBill") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LastBill().setVisible(true);
    }
}
