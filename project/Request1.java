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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Request1 extends JFrame implements ActionListener{

	JPanel panell;
	 JTextField tf,tf1,tf2;
	JLabel stf;
        JComboBox tstf;

	
	


	public Request1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setTitle("REQUEST");
		panell = new JPanel();
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panell);
		panell.setLayout(null);
                panell.setBackground(Color.PINK);
		
		JLabel lbl1 = new JLabel("REQUEST BOX");
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lbl1.setBounds(144, 13, 213, 28);
		panell.add(lbl1);
		
		JLabel lbl2 = new JLabel("EMPLOYEE_ID");
		lbl2.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl2.setBounds(44, 57, 106, 16);
		panell.add(lbl2);
		
		tf = new JTextField();
		tf.setBounds(174, 54, 116, 22);
		panell.add(tf);
		tf.setColumns(10);
		
		/*JLabel lbl3 = new JLabel("GROUP_ID");
		lbl3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl3.setBounds(44, 96, 106, 16);
		panell.add(lbl3);
		
		tf1 = new JTextField();
		tf1.setBounds(174, 89, 116, 22);
		panell.add(tf1);
		tf1.setColumns(10);*/
		
		JLabel lbl4= new JLabel("REQUEST");
		lbl4.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl4.setBounds(56, 150, 94, 19);
		panell.add(lbl4);
		
		tf2 = new JTextField();
		tf2.setBounds(174, 150, 233, 56);
		panell.add(tf2);
		tf2.setColumns(10);
		
		JButton back = new JButton("BACK");
		back.addActionListener(this);
		
		back.setFont(new Font("Tahoma", Font.ITALIC, 14));
		back.setBounds(310, 215, 97, 25);
		panell.add(back);
		
		JButton submit =  new JButton("submit");
		submit.setFont(new Font("Tahoma", Font.ITALIC, 14));
		submit.setBounds(174, 215, 97, 25);
		panell.add(submit);
                submit.addActionListener(this);
                  stf=new JLabel("Staff");
                  tstf= new JComboBox();
                 add(stf);
                 stf.setBounds(56, 100, 100, 20);
                 tstf.addItem("select..");
                 tstf.addItem("weaver");
                   tstf.addItem("cloth binding");
                  tstf.addItem("yarn coloring");
                   tstf.addItem("machine");
           tstf.setBounds(174, 100, 115, 20);
                    add(tstf);
                    stf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	}
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request1 frame = new Request1();
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

    @Override
    public void actionPerformed(ActionEvent e) {
       if("BACK".equals(e.getActionCommand()))
       {
           Request r=new Request();
           r.show();
           this.setVisible(false);
       }
       if("submit".equals(e.getActionCommand()))
       {
           Request r=new Request();
           r.show();
           this.setVisible(false);
       }
       if("submit".equals(e.getActionCommand()))
       {
       String empid= tf.getText();
       String sta=(String)tstf.getSelectedItem();
       String reqst=tf2.getText();
       String sr="unsolved";
       
       
                JOptionPane.showMessageDialog(null,"request sent!! you will receive SMS");
                
       
       
       
       
      try
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
           String query="insert into Request(Emp_id,Staff,Staff_req,status) values (?,?,?,?)";
            PreparedStatement stat=con.prepareStatement(query);
            stat.setString(1, empid);
            stat.setString(2, sta);
            stat.setString(3, reqst);
            stat.setString(4, sr);
            stat.execute();
          
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
      
    }
       
    }
}