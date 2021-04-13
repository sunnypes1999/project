/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Girdhari lal
 */



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class Bobbins extends JFrame implements ActionListener {

    JPanel panell;
    JTextField tf;
    JComboBox cmb_1, cmb_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bobbins frame = new Bobbins();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Bobbins() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 861, 500);
        panell = new JPanel();
        panell.setBackground(Color.PINK);
        panell.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panell);
        panell.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lbl = new JLabel("Bobbins Stock Details");
        lbl.setBounds(201, 13, 687, 90);
        lbl.setBackground(Color.PINK);
        lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        panell.add(lbl);

        JLabel lbl_1 = new JLabel("Color");
        lbl_1.setBounds(42, 129, 77, 22);
        lbl_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(lbl_1);

        JLabel lbl_2 = new JLabel("Amount");
        lbl_2.setBounds(42, 272, 107, 34);
        lbl_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(lbl_2);

        JButton btn_1 = new JButton("Submit");
        btn_1.setBounds(331, 365, 97, 34);
        btn_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(btn_1);
        btn_1.addActionListener(this);

        JButton btn_2 = new JButton("Display");
        btn_2.setBounds(484, 365, 127, 34);
        btn_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(btn_2);
        btn_2.addActionListener(this);

        JLabel lbl_3 = new JLabel("Types of Threads");
        lbl_3.setBounds(44, 189, 198, 55);
        lbl_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(lbl_3);

        cmb_1 = new JComboBox();
        cmb_1.setBounds(254, 207, 152, 22);
        cmb_1.setModel(new DefaultComboBoxModel(new String[]{"Select...", "10", "20", "30"}));
        panell.add(cmb_1);

        tf = new JTextField();
        tf.setBounds(254, 274, 216, 34);
        panell.add(tf);
        tf.setColumns(10);

        JButton btn_3 = new JButton("Back");
        btn_3.setBounds(679, 367, 97, 31);
        btn_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        panell.add(btn_3);
        btn_3.addActionListener(this);

        cmb_2 = new JComboBox();
        cmb_2.setModel(new DefaultComboBoxModel(new String[]{"Select...", "Black", "Red", "Blue", "Yellow", "Brown"}));
        cmb_2.setBounds(254, 131, 127, 22);
        panell.add(cmb_2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Submit".equals(e.getActionCommand())) {
            Admin admi = new Admin();
            admi.show();
            this.setVisible(false);
        }
        if ("Display".equals(e.getActionCommand())) {
            Bobbinstock bs = new Bobbinstock();
            bs.show();
        }
        if ("Back".equals(e.getActionCommand())) {
            Admin admi = new Admin();
            admi.show();
            this.setVisible(false);
        }
        String clr = (String) cmb_2.getSelectedItem();
        String type = (String) cmb_1.getSelectedItem();
        String quan = tf.getText();
        if ("Submit".equals(e.getActionCommand())) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile", "root", "12345678");
                String query = "insert into bobbins (color,Type,Quantity) values (?,?,?)";

                PreparedStatement stat = con.prepareStatement(query);
                stat.setString(1, clr);
                stat.setString(2, type);
                stat.setString(3, quan);
                stat.execute();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
