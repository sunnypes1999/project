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

    

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Threads extends JFrame implements ActionListener{

	 JPanel panell;
	 JTextField tf;
        JComboBox cb,cb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Threads frame = new Threads();
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
	public Threads() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 483);
		panell = new JPanel();
		panell.setBackground(Color.PINK);
		panell.setForeground(Color.BLUE);
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panell);
		panell.setLayout(null);
                setTitle("THREAD STOCK");
		
		JLabel lblTs = new JLabel("Threads Stock Details");
		lblTs.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblTs.setBounds(215, 13, 337, 93);
		panell.add(lblTs);
		
		JLabel lbl = new JLabel("Color");
		lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lbl.setBounds(50, 129, 77, 22);
		panell.add(lbl);
		
		
		
		JLabel lbl1 = new JLabel("Types of Threads");
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lbl1.setBounds(50, 189, 198, 55);
		panell.add(lbl1);
		
		 cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Black", "Red", "Blue", "Yellow", "Brown"}));
		cb.setBounds(270, 129, 165, 22);
		panell.add(cb);
		
		 cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Select", "10", "20", "30"}));
		cb1.setBounds(270, 207, 150, 22);
		panell.add(cb1);
		
		JLabel lbl3 = new JLabel("Quantity");
		lbl3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lbl3.setBounds(42, 272, 107, 34);
		panell.add(lbl3);
		
		
		
		JButton bsubm= new JButton("Submit");
		bsubm.setFont(new Font("Arial", Font.ITALIC, 14));
		bsubm.setBounds(331, 365, 97, 34);
		panell.add(bsubm);
		bsubm.addActionListener(this);
		JButton bdis= new JButton("Display");
		bdis.setFont(new Font("Arial", Font.ITALIC, 14));
		bdis.setBounds(501, 365, 127, 34);
		panell.add(bdis);
                bdis.addActionListener(this);
		
		tf = new JTextField();
		tf.setBounds(270, 280, 206, 22);
		panell.add(tf);
		tf.setColumns(10);
		
		JButton bbck = new JButton("Back");
		bbck.setFont(new Font("Arial", Font.ITALIC, 14));
		bbck.setBounds(679, 367, 97, 31);
		panell.add(bbck);
                bbck.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
       if("Submit".equals(e.getActionCommand()))
       {
           Admin ad=new Admin();
           ad.show();
           this.setVisible(false);
       }
       if("Display".equals(e.getActionCommand()))
       {
         Displaythread dc= new Displaythread();
           dc.show();
       }
       if("Back".equals(e.getActionCommand()))
       {
           Admin ad=new Admin();
           ad.show();
           this.setVisible(false);
       }
       String clr=(String)cb.getSelectedItem();
       String type=(String)cb1.getSelectedItem();
       String quan=tf.getText();
       if("Submit".equals(e.getActionCommand()))
       {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
           String query="insert into Threads (color,Type,Quantity) values (?,?,?)";
           
          PreparedStatement stat=con.prepareStatement(query);
          stat.setString(1,clr );
          stat.setString(2,type ); 
          stat.setString(3,quan ); 
          stat.execute();
           
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
       }
    }
}

    

