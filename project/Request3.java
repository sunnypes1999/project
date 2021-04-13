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

    
import java.sql.*;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class Request3 extends JFrame implements ActionListener{

	JPanel pannell;
	 JTextField tf;
          JTable table;
         

	

	
	public Request3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setTitle("REQUEST STATUS");
		pannell = new JPanel();
		pannell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannell);
		pannell.setLayout(null);
                pannell.setBackground(Color.PINK);
		
		JLabel lblNewLabel = new JLabel("CHECK STATUS");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setBounds(156, 13, 226, 26);
		pannell.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REQ_ID");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1.setBounds(90, 82, 87, 30);
		pannell.add(lblNewLabel_1);
		
		tf = new JTextField();
		tf.setBounds(178, 82, 139, 26);
		pannell.add(tf);
		tf.setColumns(10);
		
		JButton submit = new JButton("SUBMIT");
		//submit.setBackground(Color.LIGHT_GRAY);
		//submit.setForeground(Color.DARK_GRAY);
		submit.setFont(new Font("Tahoma", Font.ITALIC, 14));
		submit.setBounds(178, 215, 97, 25);
		pannell.add(submit);
                submit.addActionListener(this);
               
                JScrollPane sp=new JScrollPane(table);
                pannell.add(sp);
                
		table =new JTable();
                table.setBounds(20,110,350,90);
                pannell.add(table);
                //crollPane.setViewPortView(table);
                
		JButton back = new JButton("BACK");
		//back.setForeground(Color.DARK_GRAY);
		//back.setBackground(Color.LIGHT_GRAY);
		back.setFont(new Font("Tahoma", Font.ITALIC, 14));
		back.setBounds(323, 215, 97, 25);
		pannell.add(back);
                back.addActionListener(this);
	}
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request3 frame = new Request3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
       if("SUBMIT".equals(e.getActionCommand()))
       {
           try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
         
         Statement stat=con.createStatement();
         String str7=tf.getText();
         String query="select * from request where Emp_id="+str7;
               System.out.println("Running:" + query);
          ResultSet rs=stat.executeQuery(query);
          table.setModel(DbUtils.resultSetToTableModel(rs));
           }
           catch(Exception ec)
           {
               JOptionPane.showMessageDialog(null, ec);
           }
       
       }
    }


    
}
