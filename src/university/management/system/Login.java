package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton loginbtn;
    JButton cancelbtn;
    JTextField tfUsername;
    JTextField tfpassword;
    
    Login(){
//        getContentPane().setBackground(Color.gray);
        setLayout(null);
        // for username 
        JLabel labelUsername = new JLabel("Username");
        labelUsername.setBounds(40,40,120,25);
        add(labelUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(150, 40, 130 ,25);
        add(tfUsername);
        
        // For password
        JLabel labelpassword = new JLabel("Password");
        add(labelpassword);
        labelpassword.setBounds(40,70,120,25);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,130,25);
        add(tfpassword);
        
        // adding buttons 
        // login button
        loginbtn = new JButton("Login");
        loginbtn.setBounds(40, 120, 115, 25);
        add(loginbtn);
        loginbtn.addActionListener(this);
        loginbtn.setBackground(Color.ORANGE);
        loginbtn.setForeground(Color.black);
        loginbtn.setFont(new Font("Tahoma" , Font.BOLD, 14));
        
        // cancel button
        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(165, 120, 115, 25);
        add(cancelbtn);
        cancelbtn.addActionListener(this); 
        cancelbtn.setBackground(Color.orange);
        cancelbtn.setForeground(Color.black);
        cancelbtn.setFont(new Font("Tahoma" , Font.BOLD, 14));
        
        // adding image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(320,10, 250, 250);
        add(image);
        
        // frame 
        setVisible(true);
        setSize(600,300);
        setLocation(500,250);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==loginbtn){
            String username = tfUsername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where uername='"+username+"' and password='"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch(Exception e){
                e.getStackTrace();
            }
        }
        else if(ae.getSource()==cancelbtn){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        Login login = new Login();
    }
}
