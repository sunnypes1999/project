/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Girdhari lal
 */
public class Bobbinstock extends JFrame implements ActionListener{
    JPanel panel;
    JButton sho;
    JTable table;
      JScrollPane sp;
      JLabel lb,clr,tp,qn;
    public Bobbinstock()
    {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("display cloth");
        panel=new JPanel();
        
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
                panel.setBackground(Color.PINK);
                lb = new JLabel("");
         sho=new JButton("show");
         sho.setBounds(250, 500, 100, 40);
         panel.add(sho);
         sho.addActionListener(this);
         sp=new JScrollPane(table);
                panel.add(sp);
                
		table =new JTable();
                table.setBounds(20,150,550,200);
                panel.add(table); 
                lb=new JLabel("BOBBINS STOCK");
                lb.setBounds(250,30,300,60);
                lb.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
                panel.add(lb);
                clr=new JLabel("color");
                clr.setBounds(50,105,100,60);
                clr.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
                panel.add(clr);
                tp=new JLabel("type");
                tp.setBounds(250,105,100,60);
                tp.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
                panel.add(tp);
                qn=new JLabel("quantity");
                qn.setBounds(450,105,100,60);
                qn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
                panel.add(qn);
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bobbinstock dc= new Bobbinstock();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


    @Override
    public void actionPerformed(ActionEvent e) {
      if("show".equals(e.getActionCommand()))
       {
           try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
         
         Statement stat=con.createStatement();
        
         String query="select * from bobbins";
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