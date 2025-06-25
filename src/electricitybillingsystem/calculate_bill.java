package electricitybillingsystem;

/**
 *
 * @author Aniket
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class calculate_bill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    Choice c1,c2;
    JButton b1,b2;
    JPanel p;
    calculate_bill(){

        p = new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);
        Font f1 = new Font("Comic Sans MS",Font.PLAIN,20);
        p.setFont(f1);
        p.setForeground(Color.BLACK);


        l1 = new JLabel("CALCULATE ELECTRICITY BILL");
       
        l2 = new JLabel("METER NO.");
        Font f100 = new Font("Comic Sans MS",Font.BOLD,20);
        l1.setFont(f100);
       
        l3 = new JLabel("UNITS CONSUMED");
        
        l5 = new JLabel("MONTH");

        t1 = new JTextField();

        c1 = new Choice();
        c1.add("16001");
        c1.add("16002");
        c1.add("16003");
        c1.add("16004");
        c1.add("16005");
        c1.add("16006");
        c1.add("16007");
        c1.add("16008");
        c1.add("16009");
        c1.add("16010");
        c1.add("16011");
        c1.add("16012");
        c1.add("16013");
        c1.add("16014");
        c1.add("16015");
        c1.add("16016");
        c1.add("16017");
        c1.add("16018");
        c1.add("16019");
        c1.add("16020");

        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");

        b1 = new JButton("SUBMIT");
        Font f5 = new Font("Comic Sans MS",Font.PLAIN,20);
        b1.setFont(f5);
      //  b2 = new JButton("CANCEL");
        //Font f6 = new Font("Comic Sans MS",Font.PLAIN,20);
        //b2.setFont(f6);

        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);

      //  b2.setBackground(Color.RED);
       // b2.setForeground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l4 = new JLabel(i3);



        l1.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
         l1.setForeground(Color.GRAY);
        //Move the label to center
        l1.setHorizontalAlignment(JLabel.CENTER);



        p.add(l2);
        p.add(c1);
        p.add(l5);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
       // p.add(b2);

        setLayout(new BorderLayout(30,30));

        add(l1,"North");
        add(p,"Center");
        add(l4,"West");


        b1.addActionListener(this);
       // b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,500);
        setLocation(250,150);
    }
    public void actionPerformed(ActionEvent ae){
        String a = c1.getSelectedItem();
        String b = t1.getText();
        String c = c2.getSelectedItem();

        int p1 = Integer.parseInt(b);

        int p2 = p1*7;
        int p3 = p2+50+12+102+20+50;

        String q = "INSERT INTO bill (MeterNumber, Month, Unit, TotalBill) VALUES ('"+a+"', '"+c+"', '"+b+"', '"+p3+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Bill Updated");
        }catch(Exception aee){
            aee.printStackTrace();
        }


    }


    public static void main(String[] args){
        new calculate_bill().setVisible(true);
    }
}