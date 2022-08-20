
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash(){
        // adding heading
        JLabel heading = new JLabel("Dr. Balasaheb Sawant Konkan Krishi Vidyapeeth, Dapoli");
        heading.setBounds(200,10,800,25);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setForeground(Color.black);
        add(heading);
        
        // adding image in the frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        t = new Thread(this);
        t.start();
        setVisible(true);
        int x=1;
        for(int i=2;i<=220; i+=4, x+=1){
        setSize(1050-((i+x)/2), 650 - (i/2));
        setLocation(i+(2*x), i-(x));
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        
        }
    }
    public void run(){
        try{
            Thread.sleep(3500);
            setVisible(false);
            
            new Login();
        }catch(Exception e){}
    }
    public static void main(String []args){
        Splash s = new Splash();
        
    }
}
