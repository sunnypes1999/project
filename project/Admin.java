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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
//import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import net.proteanit.sql.DbUtils;

public class Admin extends JFrame implements ActionListener{

	private JPanel panell;
        JTable table;
         JScrollPane sp; 
         
        
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
                Admin a=new Admin();
                a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 480);
                  setLocationRelativeTo(null);
                setTitle("ADMIN");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRequest = new JMenu("Request");
		menuBar.add(mnRequest);
                JMenuItem reqst = new JMenuItem("show");
		mnRequest.add(reqst);
                reqst.addActionListener(this);
		
		JMenu mnStock = new JMenu("Stock");
		menuBar.add(mnStock);
		
		JMenuItem mCloth = new JMenuItem("Cloth");
		mnStock.add(mCloth);
                mCloth.addActionListener(this);
               
		
		JMenuItem mThreads = new JMenuItem("Threads");
		mnStock.add(mThreads);
                mThreads.addActionListener(this);
		
		JMenuItem mBobbins = new JMenuItem("Bobbins");
		mnStock.add(mBobbins);
                mBobbins.addActionListener(this);
		
		JMenu mnImportexport = new JMenu("Import/Export");
		mnImportexport.setBackground(Color.BLUE);
		menuBar.add(mnImportexport);
		
		JMenuItem mImport = new JMenuItem("Import");
		mnImportexport.add(mImport);
		mImport.addActionListener(this);
		JMenuItem mExport = new JMenuItem("Export");
		mnImportexport.add(mExport);
                mExport.addActionListener(this);
                
		panell = new JPanel();
		panell.setBackground(Color.PINK);
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		panell.setLayout(new BorderLayout(0, 0));
		setContentPane(panell);
		
		JButton blogo = new JButton("Log Out");
		panell.add(blogo, BorderLayout.SOUTH);
                blogo.addActionListener(this);
                sp=new JScrollPane(table);
                panell.add(sp);
                
		table =new JTable();
                table.setBounds(20,110,350,90);
                panell.add(table);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
         if("show".equals(e.getActionCommand()))
            {
               
           try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
         
         Statement stat=con.createStatement();
         String query="select * from request";
               System.out.println("Running:" + query);
          ResultSet rs=stat.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
          
           }
           catch(Exception ec)
           {
               JOptionPane.showMessageDialog(null, ec);
           }
          
           
          // Request r=new Request();
           //r.show();
           //this.setVisible(false);
       
            }
            if("Log Out".equals(e.getActionCommand()))
            {
                Login lg=new Login();
                lg.show();
               this.setVisible(false);
            }
           if("Cloth".equals(e.getActionCommand()))
           {
               Cloths cl=new Cloths();
               cl.show();
               this.setVisible(false);
           }
           if("Threads".equals(e.getActionCommand()))
           {
               Threads tl=new Threads();
               tl.show();
               this.setVisible(false);
           }
         if("Bobbins".equals(e.getActionCommand()))
           {
               Bobbins b1=new Bobbins();
               b1.show();
               this.setVisible(false);
           }
         if("Import".equals(e.getActionCommand()))
           {
               Imports i1=new Imports();
               i1.show();
               this.setVisible(false);
           }
         if("Export".equals(e.getActionCommand()))
           {
               Exports e1=new Exports();
               e1.show();
               this.setVisible(false);
           }
        
    }

}

    
    


