import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;


public class mainmenu implements ActionListener{
	JFrame frame = new JFrame("Air Line Reservation System");
    Container c = frame.getContentPane();
    JMenuBar mb=new JMenuBar();
    JButton Flight_Information,Add_Customer_Details,Journey_Details,Reservation,delaccount;
    
    /*JLabel imglabel;
    JButton buttonForPicture = new JButton();
	ImageIcon icon = new ImageIcon("background.png");
    JTextArea text = new JTextArea();*/
	mainmenu() 
	{
		
		
		Flight_Information=new JButton("Flight Information");
		Flight_Information.addActionListener(this);
		
		Add_Customer_Details=new JButton("Add Customer Details");
		Add_Customer_Details.addActionListener(this);
		
		Journey_Details=new JButton("Journey Details");
		Journey_Details.addActionListener(this);
		Reservation=new JButton("Reservation");
		Reservation.addActionListener(this);
		delaccount=new JButton("Delete Account");
		delaccount.addActionListener(this);
		mb.add(Flight_Information);mb.add(Add_Customer_Details);mb.add(Journey_Details);mb.add(Reservation);mb.add(delaccount);
		mb.setBackground(new Color(30,33,41));
		mb.setForeground(new Color(30,33,41));
		mb.setBorder(BorderFactory.createLineBorder(new Color(30,33,41)));
		
		frame.setJMenuBar(mb);  
        
		//frame.setTitle("Air Line Reservation System");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBackground(new Color(30,33,41));
		
	}
public static void main(String[]args)
{
	
	new mainmenu();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==Flight_Information)
	{
		//new flightinfo();
	}
	else if(e.getSource()==Add_Customer_Details)
	{
		new Add_Customer_Details();
		frame.dispose();
	}
	else if(e.getSource()==Journey_Details)
	{
		new journeydetails();
		frame.dispose();
	}
	else if(e.getSource()==Reservation)
	{
		new reservation();
		
	}
	else if(e.getSource()==delaccount)
	{
		new delaccount();
		
	}
}
}