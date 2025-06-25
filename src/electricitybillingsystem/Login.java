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
import javax.swing.border.*;

import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Login(){
        super("Administrator Login");

        l1 = new JLabel("Username ");
        l2 = new JLabel("Password ");
        Font f = new Font("Comic Sans MS",Font.BOLD,20);
        l1.setFont(f);
        l1.setForeground(Color.GRAY);
        Font f1 = new Font("Comic Sans MS",Font.BOLD,20);
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);


        tf1 = new JTextField(13);
        pf2 = new JPasswordField(13);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        b1 = new JButton("LOGIN");
         Font f5 = new Font("Comic Sans MS",Font.PLAIN,16);
        b1.setFont(f5);
        b1.setForeground(Color.WHITE);
         b1.setBackground(Color.GREEN);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        b2 = new JButton("CANCEL");
        Font f6 = new Font("Comic Sans MS",Font.PLAIN,16);
        b2.setFont(f6);
         b2.setForeground(Color.WHITE);
         b2.setBackground(Color.RED);


        b1.addActionListener(this);
        b2.addActionListener(this);


        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/pop.png"));
        Image i3 = ic3.getImage().getScaledInstance(128, 128,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);

        setLayout(new BorderLayout());


        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();


        add(l3,BorderLayout.WEST);
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p2,BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);

        p2.setBackground(Color.WHITE);
        p4.setBackground(Color.white);


        setSize(440,210);
        setLocation(500,300);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){

        try{
            conn c1 = new conn();
            String a  = tf1.getText();
            String b  = pf2.getText();
            String q  = "select * from signup where username = '"+a+"' and password = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){
                new Project().setVisible(true);
                this.setVisible(false);

            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }
    }

    public static void main(String[] args){
        new Login().setVisible(true);
    }


}