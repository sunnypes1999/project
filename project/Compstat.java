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
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Compstat extends JFrame implements ActionListener{

	JPanel pannell;
	JTextField tf;
        JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compstat frame = new Compstat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Compstat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pannell = new JPanel();
		pannell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannell);
		pannell.setLayout(null);
                pannell.setBackground(Color.PINK);
                setTitle("COMPLAIN STATUS");
		
		JLabel lblNewLabel = new JLabel("REQ_ID");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
		lblNewLabel.setBounds(71, 85, 73, 16);
		pannell.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(197, 82, 116, 22);
		pannell.add(tf);
		tf.setColumns(10);
		
		JLabel lbl1= new JLabel("CHECK STATUS");
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lbl1.setBounds(160, 13, 175, 25);
		pannell.add(lbl1);
		
		JButton blog = new JButton("LOGOUT");
		blog.setFont(new Font("Tahoma", Font.ITALIC, 14));
		blog.setBounds(323, 216, 97, 25);
		pannell.add(blog);
                blog.addActionListener(this);
		
		JButton bsub = new JButton("SUBMIT");
		bsub.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bsub.setBounds(167, 215, 97, 25);
		pannell.add(bsub);
		bsub.addActionListener(this);
		JButton bbck = new JButton("BACK");
		bbck.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bbck.setBounds(26, 217, 97, 25);
		pannell.add(bbck);
                bbck.addActionListener(this);
                 JScrollPane sp=new JScrollPane(table);
                pannell.add(sp);
                
		table =new JTable();
                table.setBounds(20,110,350,90);
                pannell.add(table);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
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
       if("BACK".equals(e.getActionCommand()))
        {
            Request rq =new Request();
            rq.show();
            this.setVisible(false);
        }
       if("LOGOUT".equals(e.getActionCommand()))
       {
        
           Login lg=new Login();
           lg.show();
           this.setVisible(false);
       }
         
    }

}

    
