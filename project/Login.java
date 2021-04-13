package project;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Kishan Kumar
 */
public class Login extends JFrame implements ActionListener {

    Container c = getContentPane();

    JLabel brkp;
    JLabel wlcm = new JLabel("WELCOME");
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
    JTextField user_aa = new JTextField();
    JPasswordField pass_pf = new JPasswordField();
    JButton login_ad = new JButton("Ad. log.");
    JButton login_sf = new JButton("Stf. Log.");
    JLabel Newuser = new JLabel(" Note: New user click on Sign Up ");
    JButton sign_up = new JButton("Sign Up");
    String arial;

    public Login() {
        c.setBackground(Color.PINK);
        //this.icon = new ImageIcon("C:\\Users\\Kishan Kumar\\Documents\\NetBeansProjects\\edc1d65d02974f984164512440c93672.jpg");
        setTitle("Textile Industry");
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        brkp = new JLabel("ARRY TEXTILE");
        brkp.setBounds(180, 100, 300, 40);
        brkp.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        wlcm.setBounds(250, 1, 250, 60);
        Font e = new Font(arial, Font.BOLD, 20);
        wlcm.setFont(e);
        
        Font f = new Font(arial, Font.BOLD, 35);
        brkp.setFont(f);
        userLabel.setBounds(100, 250, 200, 32);
        passLabel.setBounds(100, 300, 200, 14);
        user_aa.setBounds(220, 250, 150, 25);
        pass_pf.setBounds(220, 300, 150, 25);
        login_ad.setBounds(150, 350, 100, 25);
        login_sf.setBounds(300, 350, 100, 25);
        Newuser.setBounds(200, 400, 200, 20);
        sign_up.setBounds(250, 450, 100, 23);

        add(userLabel);
        add(passLabel);
        add(user_aa);
        add(pass_pf);
        add(login_ad);
        add(login_sf);
        add(Newuser);
        add(sign_up);
        add(brkp);
        add(wlcm);
        login_sf.addActionListener(this);
        sign_up.addActionListener(this);
        login_ad.addActionListener(this);

    }

    public static void main(String[] args) {
        Login tx;
        tx = new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Stf. Log.".equals(e.getActionCommand())) {
            String str3 = user_aa.getText();
            String str4 = pass_pf.getText();
            if (str3.equals("admin") && str4.equals("admin")) {

                Request re = new Request();
                re.show();
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "ooo soryyy! try again");
            }
        }
        if ("Sign Up".equals(e.getActionCommand())) {

            Register req = new Register();
            req.show();
            this.setVisible(false);
        }
        if ("Ad. log.".equals(e.getActionCommand())) {

            String str5 = user_aa.getText();
            String str6 = pass_pf.getText();
            if (str5.equals("admin") && str6.equals("admin")) {
                Admin ad = new Admin();
                ad.show();
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "try again invalid credentials");
            }

        }
        int id = Integer.parseInt(user_aa.getText());
        String pass = pass_pf.getText();
        int did;
        String dpass;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/textile", "root", "12345678");
            String query = "select Emp_id,pass from edetails where Emp_id=" + id;
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);
            did = rs.getInt("Emp_id");
            dpass = rs.getString("pass");
            if (id == did && pass.equals(dpass)) {
                if ("Stf. Log.".equals(e.getActionCommand())) {
                    Request re = new Request();
                    re.show();
                    this.setVisible(false);
                }
                JOptionPane.showMessageDialog(null, "Login Succesful");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Credential");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
