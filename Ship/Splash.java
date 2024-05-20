package Ship;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Splash extends JFrame implements Runnable{
	Thread thread;
	private Container c;
	private ImageIcon icon1;
	private JLabel label1;
	public Splash(){

		initComponents();
	}
	
	public void  initComponents(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ship Booking");
		
	    c= this.getContentPane();
	
		 icon1 = new ImageIcon(getClass().getResource("image/splash.jpg"));
        Image image = icon1.getImage().getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image);

        label1 = new JLabel(icon1);
		c.add(label1);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		try{
			Thread.sleep(4000);
			new Dashboard();
		     this.setVisible(false);
			  new Dashboard().setVisible(true);
		} catch(Exception e){
			
		}
	}
   public static void main(String[]argszz){
	    
	    Splash frame = new Splash();
		frame.setVisible(true);
    frame.setLocationRelativeTo(null);
		int x=1;
		for (int i =1; i<=500; x+=7, i+=6) {
			frame.setLocation(500-(x+1)/2, 400-(i/2));
			frame.setSize(x+ i,i);
			
			try{
				Thread.sleep(10);
			}
			catch(Exception e){}
		}
	   
   }
}