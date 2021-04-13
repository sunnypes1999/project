/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Request extends JFrame implements ActionListener{

    JPanel panell;
     JLabel lbl1 ,lbl2,lbl3;
     JButton breq,bstatus,bsta,bcom;
	

	
	 
	public Request() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                setTitle("STAFF ");
		panell = new JPanel();
		panell.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panell);
		panell.setLayout(null);
                panell.setBackground(Color.PINK);
		
		JLabel lbl1 = new JLabel("REQUEST ");
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbl1.setBounds(71, 74, 93, 28);
		panell.add(lbl1);
		
		JButton breq= new JButton("request");
		//breq.setBackground(Color.LIGHT_GRAY);
		//breq.setForeground(Color.DARK_GRAY);
		breq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		breq.setBounds(175, 77, 97, 25);
		panell.add(breq);
                breq.addActionListener(this);
		
		JButton bstatus= new JButton("req_status");
		bstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//bstatus.setBackground(Color.LIGHT_GRAY);
		//bstatus.setForeground(Color.DARK_GRAY);
		bstatus.setBounds(283, 76, 120, 25);
		panell.add(bstatus);
                bstatus.addActionListener(this);
		
		JLabel lbl2= new JLabel("COMPLAIN");
		lbl2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbl2.setBounds(67, 148, 76, 25);
		panell.add(lbl2);
		
		JButton bcom= new JButton("complain");
		bcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//bcom.setBackground(Color.LIGHT_GRAY);
		//bcom.setForeground(Color.DARK_GRAY);
		bcom.setBounds(175, 148, 97, 25);
		panell.add(bcom);
                bcom.addActionListener(this);
		
		JButton bsta = new JButton("com_status");
		bsta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//bsta.setBackground(Color.LIGHT_GRAY);
		//bsta.setForeground(Color.DARK_GRAY);
		bsta.setBounds(283, 148, 120, 25);
		panell.add(bsta);
                bsta.addActionListener(this);
		
		JLabel lbl3= new JLabel("STAFF");
		lbl3.setBackground(Color.CYAN);
		lbl3.setForeground(Color.GRAY);
		lbl3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lbl3.setBounds(175, 13, 170, 51);
		panell.add(lbl3);
		
		JButton blog= new JButton("LOG OUT");
		//blog.setBackground(Color.LIGHT_GRAY);
		blog.setBounds(175, 215, 97, 25);
		panell.add(blog);
                blog.addActionListener(this);
               // jButtontionPerformed(breq);
	}
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request frame = new Request();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if("request".equals(e.getActionCommand()))
        {
            Request1 r1=new Request1();
       r1.show();
       this.setVisible(false);
        }
        if("req_status".equals(e.getActionCommand()))
        {
            Request3 r3=new Request3();
            r3.show();
            this.setVisible(false);
        }
        if("complain".equals(e.getActionCommand()))
        {
            Complain c1=new Complain();
            c1.show();
            this.setVisible(false);
        }
        if("com_status".equals(e.getActionCommand()))
        {
            Compstat cs=new Compstat();
            cs.show();
            this.setVisible(false);
        }
        if("LOG OUT".equals(e.getActionCommand()))
        {
            Login  lgn=new Login();
            lgn.show();
            this.setVisible(false);
        }
        
        
    }
   
    

       
   
}
