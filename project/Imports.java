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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Imports extends JFrame implements ActionListener{

	 JPanel panell;
	 JTextField tf;
	 JTextField tf_1;
         JComboBox cmb,cmb_1,cmb_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imports frame = new Imports();
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
	public Imports() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 520);
                setTitle("IMPORT");
		panell = new JPanel();
		panell.setBackground(Color.PINK);
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panell);
		panell.setLayout(null);
                setLocationRelativeTo(null);
		
		JLabel lbl = new JLabel("IMPORT DETAILS");
		lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lbl.setBounds(285, 13, 300, 47);
		panell.add(lbl);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblItem.setBounds(34, 82, 56, 16);
		panell.add(lblItem);
		
		cmb = new JComboBox();
		cmb.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Cloth", "Threads", "Bobbins"}));
		cmb.setBounds(171, 78, 135, 29);
		panell.add(cmb);
		
		JLabel color = new JLabel("COLOR");
		color.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		color.setBounds(34, 140, 116, 29);
		panell.add(color);
		
		 cmb_1 = new JComboBox();
		cmb_1.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Black", "Red", "Blue", "Yellow", "Brown"}));
		cmb_1.setBounds(171, 143, 135, 27);
		panell.add(cmb_1);
		
		JLabel quality = new JLabel("QUALITY");
		quality.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		quality.setBounds(34, 219, 105, 29);
		panell.add(quality);
		
		cmb_2 = new JComboBox();
		cmb_2.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Super", "Delux", "Kohinoor"}));
		cmb_2.setBounds(171, 222, 135, 27);
		panell.add(cmb_2);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblQuantity.setBounds(34, 287, 116, 29);
		panell.add(lblQuantity);
		
		tf = new JTextField();
		tf.setBounds(170, 285, 150, 29);
		panell.add(tf);
		tf.setColumns(10);
		
		JLabel amt = new JLabel("AMOUNT");
		amt.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		amt.setBounds(34, 342, 95, 36);
		panell.add(amt);
		
		tf_1 = new JTextField();
		tf_1.setBounds(171, 342, 149, 31);
		panell.add(tf_1);
		tf_1.setColumns(10);
		
		JButton sbmt = new JButton("Submit");
		sbmt.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		sbmt.setBounds(285, 407, 116, 36);
		panell.add(sbmt);
                sbmt.addActionListener(this);
		
		JButton display = new JButton("Display");
		display.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		display.setBounds(480, 407, 116, 36);
		panell.add(display);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		back.setBounds(672, 409, 97, 34);
		panell.add(back);
                back.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
       if("Submit".equals(e.getActionCommand()))
       {
           Admin dm=new Admin();
           dm.show();
           this.setVisible(false);
       }
      /* if("Display".equals(e.getActionCommand()))
       {
           Admin dm=new Admin();
           dm.show();
       }*/
       if("Back".equals(e.getActionCommand()))
       {
           Admin dm=new Admin();
           dm.show();
           this.setVisible(false);
       }
       String it=(String)cmb.getSelectedItem();
       String clr=(String)cmb_1.getSelectedItem();
       String qual=(String)cmb_2.getSelectedItem();
       String quan=tf.getText();
       String amt=tf_1.getText();
       if("Submit".equals(e.getActionCommand()))
       {
           try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
               String query="insert into imports (Item,color,quality,quantity, amount) values (?,?,?,?,?)";
               PreparedStatement stat=con.prepareStatement(query);
               stat.setString(1, it);
               stat.setString(2, clr);
               stat.setString(3, qual);
               stat.setString(4, quan);
               stat.setString(5, amt);
               stat.execute();
               
               
               
           }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
       }
    }
}


