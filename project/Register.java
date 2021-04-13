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

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Kishan Kumar
 */
public class Register extends JFrame implements ActionListener{
   
  Container c=getContentPane();
  
  JLabel jl=new JLabel("Registration Form");
    
    JLabel name=new JLabel("Name");
    JTextField nm=new JTextField();
    
    JLabel pass =new JLabel("New Password");
    JPasswordField pf= new JPasswordField();
    
   JLabel cpass =new JLabel("Confirm Password");
    JPasswordField cpf= new JPasswordField();
    
    JLabel Gender= new JLabel("Gender");
    JRadioButton male= new JRadioButton("Male");
    JRadioButton female= new JRadioButton("Female");
    ButtonGroup bg =new ButtonGroup();
    
    JLabel pno=new JLabel("Mobile Number :");
    JTextField pnm=new JTextField();
    
    
    
    JLabel ad=new JLabel("Address");
    JTextField adf=new JTextField();
    
     JLabel cty=new JLabel("City");
    JComboBox cb= new JComboBox();
   
    JLabel stf=new JLabel("Staff");
    JComboBox tstf= new JComboBox();
   
    
    JButton reg= new JButton("Register");
    
    
    private String Arial;
    private String Arabian;
   

    public Register()
    {
       c.setBackground(Color.PINK);
         setTitle("Registration page");
         setVisible(true);
    setSize(1300, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    
        
        setLayout(null);
       Font e=new Font(Arabian,Font.BOLD, 14);
        name.setFont(e);
       pass.setFont(e);
       cpass.setFont(e);
       Gender.setFont(e);
       pno.setFont(e);
       ad.setFont(e);
       cty.setFont(e); 
       stf.setFont(e);
       
        Font f=new Font(Arial,Font.BOLD, 20);
       jl.setFont(f);
       jl.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
         jl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
                
        jl.setBounds(600, 10, 200, 60);
        
        name.setBounds(300, 90, 100, 24);
        nm.setBounds(500, 90, 140, 24);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        nm.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
        pass.setBounds(300, 140, 140, 24);
        pf.setBounds(500, 140, 140, 24);
        pass.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        pf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
        cpass.setBounds(300, 190, 140, 24);
        cpf.setBounds(500, 190, 140, 24);
        cpass.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        cpf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
        Gender.setBounds(300, 240, 120, 24);
        Gender.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        male.setBounds(500, 240, 100, 24);
        female.setBounds(650, 240, 100, 24);
        
        pno.setBounds(300, 340, 120, 24);
        pnm.setBounds(500, 340, 120, 24);
        pno.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        pnm.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
        ad.setBounds(300, 390, 140, 24);
        adf.setBounds(500, 390, 200, 50);
         ad.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
          adf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        
        cty.setBounds(300, 470, 100, 24);
        cb.setBounds(500, 470, 100, 30);
          cty.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
           cb.setFont(new Font("Arial", Font.ITALIC, 16));
        stf.setBounds(300, 520, 100, 24);
        tstf.setBounds(500,520 , 100, 24);
         stf.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
          tstf.setFont(new Font("Arial", Font.ITALIC, 16));
          reg.setBounds(650, 580, 100, 30);
         
             /*JLabel lbl = new JLabel("Color");
		lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lbl.setBounds(300, 290, 77, 22);
		add(lbl); 
       
         JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Black", "Red", "Blue", "Yellow", "Brown"}));
		cb.setBounds(500, 290, 165, 22);
	         add(cb);
         */
        add(jl); 
        
        add(name);
        add(nm);
        
        add(pass);
        add(pf);
        
        add(cpass);
        add(cpf);
        
        add(Gender);
        add(male);
        add(female);
        bg.add(male);
        bg.add(female); 
        
        add(pno);
        add(pnm);
        
        add(ad);
        add(adf);
        
        add(cty);
        cb.addItem("Select...");
        cb.addItem("Mohali");
        cb.addItem("Chandigarh");
        cb.addItem("GAYA");
        cb.addItem("Panipat");
        
        add(cb);
        
        add(stf);
        tstf.addItem("select..");
        tstf.addItem("weaver");
         tstf.addItem("cloth binding");
          tstf.addItem("yarn coloring");
           tstf.addItem("machine");
           
           add(tstf);
        add(reg);
        reg.addActionListener(this);
    }
     
      public static void main(String[] args)
    {
      
      java.awt.EventQueue.invokeLater( new Runnable() {
           @Override
           public void run() {
            Register tx=new Register();
               
           }
           
       });
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Register".equals(e.getActionCommand()))
        {
            String str1=pf.getText();
            String str2=cpf.getText();
            if(str1.equals(str2))
            {
                JOptionPane.showMessageDialog(null,"Registered successful!!!!");
                Login l=new Login();
            l.show();
            this.setVisible(false);
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"password and confirm password not matched!! please enter same pasword!!");
            }
            
        }
        String nam=nm.getText();
        String pas=pf.getText();
        String cpas=cpf.getText();
        String gen;
        if(male.isEnabled())
        {
             gen="male";
        }
        else
        {
            gen="female";
        }
        long mob=Long.parseLong(pnm.getText());
        String addre=adf.getText();
        String ci=(String)cb.getSelectedItem();
        String sta=(String)tstf.getSelectedItem();
        long idd=mob;
       /* if(pas==cpas)
        {
            JOptionPane.showMessageDialog(null,"Confirm password match");*/
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile","root","12345678");
           
            //Statement st=con.createStatement();
            String query="insert into edetails (Name,Pass,confirmpassword,Gender,mobno,address,city,staff,Emp_id) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stat=con.prepareStatement(query);
            stat.setString(1,nam);
            stat.setString(2, pas);
            stat.setString(3,cpas);
            stat.setString(4, gen);
            stat.setInt(5, (int) mob);
            stat.setString(6, addre);
            stat.setString(7, ci);
            stat.setString(8, sta);
            stat.setInt(9, (int) idd);
            
            stat.execute();
            
            
            
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        }}
       
    
    


    

