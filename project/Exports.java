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
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exports  extends JFrame implements ActionListener{

	 JPanel panell;
	 JTextField tf_1;
	 JTextField tf_2;
	 JTextField tf_3;
         JComboBox cmb,cmb_1,cmb_2,cmb_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exports frame = new Exports();
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
	public Exports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 540);
                setTitle("EXPORTS");
		panell = new JPanel();
		panell.setBackground(Color.PINK);
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panell);
		panell.setLayout(null);
                setLocationRelativeTo(null);
		
		JLabel lblImportDetails = new JLabel("EXPORT DETAILS");
		lblImportDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblImportDetails.setBounds(285, 14, 300, 47);
		panell.add(lblImportDetails);
		
		JLabel item = new JLabel("ITEM");
		item.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		item.setBounds(34, 82, 56, 16);
		panell.add(item);
		
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
		
		JLabel quantity = new JLabel("QUANTITY");
		quantity.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		quantity.setBounds(34, 287, 116, 29);
		panell.add(quantity);
		
		
		
		JLabel amount = new JLabel("AMOUNT");
		amount.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		amount.setBounds(34, 342, 95, 36);
		panell.add(amount);
		
		
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		submit.setBounds(285, 407, 116, 36);
		panell.add(submit);
                submit.addActionListener(this);
		
		JButton btn = new JButton("Display");
		btn.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		btn.setBounds(480, 407, 116, 36);
		panell.add(btn);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		back.setBounds(672, 409, 97, 34);
		panell.add(back);
                back.addActionListener(this);
		
		tf_1 = new JTextField();
		tf_1.setBounds(171, 287, 135, 27);
		panell.add(tf_1);
		tf_1.setColumns(10);
		
		tf_2 = new JTextField();
		tf_2.setBounds(171, 346, 135, 27);
		panell.add(tf_2);
		tf_2.setColumns(10);
		
		JLabel state = new JLabel("STATE");
		state.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		state.setBounds(448, 84, 88, 23);
		panell.add(state);
		
		cmb_3 = new JComboBox();
		cmb_3.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Delhi", "Chandigarh", "Kolkata", "Assam", "Mumbai"}));
		cmb_3.setBounds(569, 84, 144, 27);
		panell.add(cmb_3);
		
		JLabel cmpy = new JLabel("COMPANY NAME");
		cmpy.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		cmpy.setBounds(444, 152, 269, 29);
		panell.add(cmpy);
		
		tf_3 = new JTextField();
		tf_3.setBounds(444, 194, 269, 36);
		panell.add(tf_3);
		tf_3.setColumns(10);
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
       String quan=tf_1.getText();
       String amt=tf_1.getText();
       String state=(String)cmb_3.getSelectedItem();
       String comp=tf_3.getText();
       if("Submit".equals(e.getActionCommand()))
       {
           try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
               String query="insert into exports(Item,color,quality,quantity, amount,state,company_name) values (?,?,?,?,?,?,?)";
               PreparedStatement stat=con.prepareStatement(query);
               stat.setString(1, it);
               stat.setString(2, clr);
               stat.setString(3, qual);
               stat.setString(4, quan);
               stat.setString(5, amt);
                stat.setString(6, state);
                 stat.setString(7, comp);
               stat.execute();
               
               
               
           }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
       }
    }

}

    

