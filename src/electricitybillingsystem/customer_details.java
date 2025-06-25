// /*
//  * To change this template, choose Tools | Templates
//  * and open the template in the editor.
//  */

// package electricitybillingsystem;

// /**
//  *
//  * @author Aniket
//  */
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;
// import java.sql.*;

// public class customer_details extends JFrame implements ActionListener{

//     JTable t1;
//     JButton b1;
//     String x[] = {"CUSTOMER DETAILS","METER NO.","ADDRESS","STATE","CITY","EMAIL ID","PHONE NO."};
//     String y[][] = new String[20][7];
//     int i=0, j=0;
//     customer_details(){
//         super("CUSTOMER DETAILS");
//         setSize(1200,450);
//         setLocation(100,200);

//         try{
//             conn c1  = new conn();
//             String s1 = "select * from emp";
//             ResultSet rs  = c1.s.executeQuery(s1);
//             while(rs.next()){
//                 y[i][j++]=rs.getString("name");
//                 y[i][j++]=rs.getString("meter_number");
//                 y[i][j++]=rs.getString("address");
//                 y[i][j++]=rs.getString("state");
//                 y[i][j++]=rs.getString("city");
//                 y[i][j++]=rs.getString("email");
//                 y[i][j++]=rs.getString("phone");
//                 i++;
//                 j=0;
//             }
//             t1 = new JTable(y,x);
//             t1.setFont(new Font("Comic Sans MS",Font.PLAIN,15));

//         }catch(Exception e){
//             e.printStackTrace();
//         }


//         b1 = new JButton("Print");
//         Font f6 = new Font("Comic Sans MS",Font.PLAIN,20);
//         b1.setFont(f6);
//          b1.setForeground(Color.WHITE);
//          b1.setBackground(Color.darkGray);

//         add(b1,"South");
//         JScrollPane sp = new JScrollPane(t1);
//         add(sp);
//         b1.addActionListener(this);
//     }
//     public void actionPerformed(ActionEvent ae){
//         try{
//             t1.print();
//         }catch(Exception e){}
//     }

//     public static void main(String[] args){
//         new customer_details().setVisible(true);
//     }

// }




package electricitybillingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class customer_details extends JFrame implements ActionListener {

    JTable t1;
    JButton b1;
    String[] headers = {"NAME", "METER NO.", "ADDRESS", "STATE", "CITY", "EMAIL ID", "PHONE NO."};
    String[][] data = new String[20][7];

    customer_details() {
        super("CUSTOMER DETAILS");
        setSize(1200, 450);
        setLocation(100, 200);
        setLayout(new BorderLayout());

        try {
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM newcustomer");

            int row = 0;
            while (rs.next() && row < 20) {
                data[row][0] = rs.getString("Name");
                data[row][1] = rs.getString("MeterNumber");
                data[row][2] = rs.getString("Address");
                data[row][3] = rs.getString("State");
                data[row][4] = rs.getString("City");
                data[row][5] = rs.getString("Email");
                data[row][6] = rs.getString("Phone");
                row++;
            }

            t1 = new JTable(data, headers);
            t1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        add(sp, BorderLayout.CENTER);

        b1 = new JButton("Print");
        b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.DARK_GRAY);

        JPanel bottom = new JPanel();
        bottom.add(b1);
        add(bottom, BorderLayout.SOUTH);

        b1.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            t1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new customer_details().setVisible(true);
    }
}

