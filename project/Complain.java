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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Complain extends JFrame implements ActionListener{

	JPanel pannell;
	JTextField tf,tf2;
        JLabel stf;
        JComboBox tstf;
	

	

	public Complain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setTitle("COMPLAIN");
		pannell = new JPanel();
		pannell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannell);
		pannell.setLayout(null);
                pannell.setBackground(Color.PINK);
		
		JLabel lbl1 = new JLabel("COMPLAIN BOX");
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lbl1.setBounds(165, 13, 206, 26);
		pannell.add(lbl1);
		
		JLabel lbl2 = new JLabel("EMPLOYEE_ID");
		lbl2.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl2.setBounds(48, 51, 106, 16);
		pannell.add(lbl2);
		
		/*JLabel lbl3 = new JLabel("GROUP_ID");
		lbl3.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl3.setBounds(48, 99, 87, 16);
		pannell.add(lbl3);*/
		
		JLabel lbl4 = new JLabel("COMPLAIN");
		lbl4.setFont(new Font("Rockwell", Font.BOLD, 14));
		lbl4.setBounds(48, 153, 87, 16);
		pannell.add(lbl4);
		
		tf = new JTextField();
		tf.setBounds(182, 52, 152, 22);
		pannell.add(tf);
		tf.setColumns(10);
		
		
		
		tf2 = new JTextField();
		tf2.setBounds(180, 130, 220, 60);
		pannell.add(tf2);
		tf2.setColumns(10);
		
		JButton bsub = new JButton("SUBMIT");
		//bsub.setBackground(Color.LIGHT_GRAY);
		//bsub.setForeground(Color.DARK_GRAY);
		bsub.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bsub.setBounds(146, 215, 97, 25);
		pannell.add(bsub);
                bsub.addActionListener(this);
		
		JButton bbck = new JButton("BACK");
		//bbck.setBackground(Color.LIGHT_GRAY);
		//bbck.setForeground(Color.DARK_GRAY);
		bbck.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bbck.setBounds(323, 215, 97, 25);
		pannell.add(bbck);
                bbck.addActionListener(this);
                 stf=new JLabel("Staff");
                  
                 add(stf);
                 tstf= new JComboBox();
                 stf.setBounds(56, 100, 100, 20);
                 tstf.addItem("select..");
                 tstf.addItem("weaver");
                   tstf.addItem("cloth binding");
                  tstf.addItem("yarn coloring");
                   tstf.addItem("machine");
           tstf.setBounds(180, 100, 115, 20);
                    add(tstf);
                    stf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	}
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complain frame = new Complain();
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if("SUBMIT".equals(e.getActionCommand()))
        {
            JOptionPane.showMessageDialog(null, "Complain Submitted");
            Request rq =new Request();
            rq.show();
            this.setVisible(false);
        }
       if("BACK".equals(e.getActionCommand()))
        {
            
            //Request rq =new Request();
           // rq.show();
            this.setVisible(false);
        }
       String emp=tf.getText();
       String sta=(String)tstf.getSelectedItem();
       String comp=tf2.getText();
       String status="unsolved";
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
           String query="insert into complain(Emp_id,Staff,cmplain,status) values(?,?,?,?)";
           PreparedStatement stat=con.prepareStatement(query);
           stat.setString(1, emp);
           stat.setString(2, sta);
           stat.setString(3, comp);
           stat.setString(4, status);
           stat.execute();
           
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
    }
}
    

