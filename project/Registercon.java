/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

/**
 *
 * @author Girdhari lal
 */
public class Registercon {
    public static void main(String[] args) {
         
try{  
Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306","root","12345678");
      Statement stmt=con.createStatement();
      
}
catch(ClassNotFoundException())
{
    
}
   
    
}

   
}
