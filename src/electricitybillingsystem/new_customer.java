/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package electricitybillingsystem;

/**
 *
 * @author Aniket
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t3,t4,t5,t6,t7;
    JButton b1;
    Choice t2;
    new_customer(){
        setLocation(300,85);
        setSize(750,600);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));

        p.setBackground(Color.WHITE);

        l1 = new JLabel("         NAME");
        Font f = new Font("Comic Sans MS",Font.BOLD,22);
        l1.setFont(f);
        l1.setForeground(Color.GRAY);
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("         METER NO.");
        Font f1 = new Font("Comic Sans MS",Font.BOLD,22);
        l2.setFont(f);
        l2.setForeground(Color.GRAY);
        t2 = new Choice();
        p.add(l2);
        p.add(t2);

        t2.add("16001");
        t2.add("16002");
        t2.add("16003");
        t2.add("16004");
        t2.add("16005");
        t2.add("16006");
        t2.add("16007");
        t2.add("16008");
        t2.add("16009");
        t2.add("16010");
        t2.add("16011");
        t2.add("16012");
        t2.add("16013");
        t2.add("16014");
        t2.add("16015");
        t2.add("16016");
        t2.add("16017");
        t2.add("16018");
        t2.add("16019");
        t2.add("16020");

        l3 = new JLabel("         ADDRESS");
        Font f2 = new Font("Comic Sans MS",Font.BOLD,22);
        l3.setFont(f);
        l3.setForeground(Color.GRAY);
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("         STATE");
        Font f3 = new Font("Comic Sans MS",Font.BOLD,22);
        l4.setFont(f);
        l4.setForeground(Color.GRAY);
        t4 = new JTextField();
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("         CITY");
        Font f4 = new Font("Comic Sans MS",Font.BOLD,22);
        l5.setFont(f);
        l5.setForeground(Color.GRAY);
        t5 = new JTextField();
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("         EMAIL ID");
        Font f5 = new Font("Comic Sans MS",Font.BOLD,22);
        l6.setFont(f);
        l6.setForeground(Color.GRAY);
        t6 = new JTextField();
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("         PHONE NO.");
        Font f6 = new Font("Comic Sans MS",Font.BOLD,22);
        l7.setFont(f);
        l7.setForeground(Color.GRAY);
        t7 = new JTextField();
        p.add(l7);
        p.add(t7);

        b1 = new JButton("SAVE");
     

         Font f50 = new Font("Comic Sans MS",Font.BOLD,20);
        b1.setFont(f50);
         Font f60 = new Font("Comic Sans MS",Font.BOLD,20);
     

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.GREEN);

     
        p.add(b1);
     
        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
     

    }
    public void actionPerformed(ActionEvent ae){

        String a = t1.getText();
        String c = t2.getSelectedItem();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();

        String q1 = "insert into newcustomer values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"New Customer Created");
            this.setVisible(false);


        }catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Meter Number Already Exists");
             ex.printStackTrace();
        }

    }


    public static void main(String[] args){
        new new_customer().setVisible(true);
    }
}