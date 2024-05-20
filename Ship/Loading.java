package Ship;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Loading extends JFrame implements Runnable{
	
	private Container con;
	private Font font, font2;
	private JLabel headingLabel, loadingLabel, userLabel;
	private JProgressBar bar;
	private Thread t;
	Loading(){
		
		initComponents();
		t = new Thread(this);
	}
	
	public void  initComponents(){
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500,200,650,400);
		this.setTitle("Loading");
		
	    con= this.getContentPane();
		con.setLayout(null);
	    con.setBackground(Color.WHITE);
		
	     font = new Font("Raleway", Font.BOLD, 35);
	     font2 = new Font("Raleway", Font.BOLD, 16);
		
		headingLabel = new JLabel("Ship Ticket and Booking");
		headingLabel.setBounds(50,20,600,40);
		headingLabel.setForeground(Color.BLUE);
		headingLabel.setFont(font);
		con.add(headingLabel);
		
		bar = new JProgressBar();
		bar.setBounds(150,100,300,35);
		bar.setStringPainted(true);
		con.add(bar);
		
		loadingLabel = new JLabel("Loading, Please Wait");
		loadingLabel.setBounds(230,130,150,30);
		loadingLabel.setForeground(Color.RED);
		loadingLabel.setFont(font2);
		con.add(loadingLabel);
		
		userLabel = new JLabel("Welcome");
		userLabel.setBounds(20,310,400,40);
		userLabel.setForeground(Color.RED);
		userLabel.setFont(font2);
		con.add(userLabel);
		
	
	}
     
	 public void run(){
		 try{
			 for(int i = 1; i<=101; i++){
				 int max = bar.getMaximum();
				 int value = bar.getValue();
				 
				 if(value< max){
					 bar.setValue(bar.getValue() + 1);
				 }
				 else{
					 new Dashboard();
					 setVisible(false);
					 new Dashboard().setVisible(true);
				 }
				 Thread.sleep(50);
			 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
   public static void main(String[]args){
	   
	    Loading frame = new Loading();
		frame.t.start();
		frame.setVisible(true);
	   
   }
}