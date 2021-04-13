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
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Cloths  extends JFrame implements ActionListener{

	 JPanel panell;
	JTextField tf;
        JComboBox cb1,cb2;
	
	private final JPopupMenu popupMenu = new JPopupMenu();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cloths frame = new Cloths();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Cloths() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 480);
                setTitle("CLOTH STOCK");
		panell = new JPanel();
		panell.setBackground(Color.PINK);
		panell.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panell);
		panell.setLayout(null);
                  setLocationRelativeTo(null);
                
		
		JLabel lbl1 = new JLabel("CLOTH STOCK DETAILS");
		lbl1.setBounds(227, 27, 575, 64);
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		panell.add(lbl1);
		
		JLabel lbl2 = new JLabel("Color");
		lbl2.setBounds(42, 129, 77, 22);
		lbl2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		panell.add(lbl2);
		
		
		
		
		
		JLabel lbl3 = new JLabel("Quantity");
		lbl3.setBounds(40, 270, 110, 35);
		lbl3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		panell.add(lbl3);
		
		tf = new JTextField();
		tf.setBounds(172, 272, 187, 34);
		tf.setForeground(Color.BLACK);
		panell.add(tf);
		tf.setColumns(10);
		
		JButton bsub = new JButton("Submit");
		bsub.setBounds(331, 365, 97, 34);
		bsub.setFont(new Font("Arial", Font.BOLD, 14));
		panell.add(bsub);
                bsub.addActionListener(this);
		
		JButton bsub1 = new JButton("Display");
		bsub1.setBounds(501, 365, 127, 34);
		bsub1.setFont(new Font("Arial", Font.BOLD, 14));
		panell.add(bsub1);
                bsub1.addActionListener(this);
		
		JButton bsub2 = new JButton("Back");
		bsub2.setBounds(679, 367, 97, 31);
		bsub2.setFont(new Font("Arial", Font.BOLD, 14));
		panell.add(bsub2);
                bsub2.addActionListener(this);
		
		 cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Black", "Red", "Blue", "Yellow", "Brown"}));
		cb1.setBounds(167, 129, 165, 22);
		panell.add(cb1);
		
		cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"Select...", "10's", "20's", "30's"}));
		cb2.setBounds(172, 198, 160, 22);
		panell.add(cb2);
		
		JLabel lblC = new JLabel("Color Type");
		lblC.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblC.setBounds(27, 201, 122, 19);
		panell.add(lblC);
                
		
		
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
           
          Displaycloth dcc=new Displaycloth();
           ad.show();
       }
       if("Back".equals(e.getActionCommand()))
       {
           Admin ad=new Admin();
           ad.show();
           this.setVisible(false);
       }
       String clr=(String)cb1.getSelectedItem();
       String type=(String)cb2.getSelectedItem();
       String quan=tf.getText();
       if("Submit".equals(e.getActionCommand()))
       {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
           String query="insert into cloths (color,Type,Quantity) values (?,?,?)";
           
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


