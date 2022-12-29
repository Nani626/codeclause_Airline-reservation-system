import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import net.proteanit.sql.DbUtils;
public class reservation extends JFrame implements ActionListener{

	JFrame frame=new JFrame("Reservation");
    Container c = frame.getContentPane();
	JLabel registration_num,flightcode,flightclass,flightcode1,flightclass1,source,destination,dateandtime,fair,
	flightdetails,userdetails,registration_number,name,id_number,phone_number,addresse, gender,nationality;
	JTextField	registration_numtext,flightcodetext,flightclasstext; 
	JRadioButton cash,debit;
	JButton showdetails,add;
	JTable table,table1;
	
	reservation()
	{
		registration_num=new JLabel("Registration Number");
		flightcode=new JLabel("Flight Code");
		flightclass=new JLabel("Flight Class");
		
		registration_numtext=new JTextField();
		flightcodetext=new JTextField();
		flightclasstext=new JTextField();
		
		cash=new JRadioButton();
		debit=new JRadioButton();
		
		registration_num.setBounds(30,50,200,20);
		flightcode.setBounds(30,150,200,20);
		flightclass.setBounds(30,250,200,20);
		
		registration_numtext.setBounds(230,50,200,20);
		flightcodetext.setBounds(230,150,200,20);
		flightclasstext.setBounds(230,250,200,20);
		
		registration_num.setFont(new Font("Times New Roman",Font.PLAIN,20) );registration_num.setForeground(new Color(59,114,252));
		flightcode.setFont(new Font("Times New Roman",Font.PLAIN,20) );flightcode.setForeground(new Color(59,114,252));
		flightclass.setFont(new Font("Times New Roman",Font.PLAIN,20) );flightclass.setForeground(new Color(59,114,252));
		
		registration_numtext.setFont(new Font("Times New Roman",Font.PLAIN,20) );registration_numtext.setForeground(new Color(59,114,252));
		flightcodetext.setFont(new Font("Times New Roman",Font.PLAIN,20) );flightcodetext.setForeground(new Color(59,114,252));
		flightclasstext.setFont(new Font("Times New Roman",Font.PLAIN,20) );flightclasstext.setForeground(new Color(59,114,252));
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(cash);bg.add(debit);  
		cash=new JRadioButton("Cash");    
		debit=new JRadioButton("Debit");
		cash.setBackground(new Color(255, 0, 0, 20));cash.setForeground(new Color(59,114,252));
		cash.setOpaque(false);
		cash.setBounds(40,350,100,50);
		debit.setBackground(new Color(255, 0, 0, 20));debit.setForeground(new Color(59,114,252));
		debit.setOpaque(false);
		debit.setBounds(110,350,100,50);
		
		showdetails=new JButton("Show Customer Details");
		showdetails.setBounds(230,360,210,25);
		showdetails.addActionListener(this);
		
		add=new JButton("ADD");
		add.setBounds(450,360,100,25);
		add.addActionListener(this);
		
		flightdetails=new JLabel("Flight Details");
		flightcode1=new JLabel("Flight Code");
		flightclass1=new JLabel("Flight Class");
		source=new JLabel("Source");
		destination=new JLabel("Destination");
		dateandtime=new JLabel("Date and Time");
		fair=new JLabel("Fair");
		
		flightdetails.setBounds(415,430,150,30);flightdetails.setForeground(new Color(123,247,243));
		flightdetails.setFont( new Font("",Font.BOLD,16));
		flightcode1.setBounds(70,460,70,30);flightcode1.setForeground(new Color(123,247,243));
		flightclass1.setBounds(220,460,70,30);flightclass1.setForeground(new Color(123,247,243));
		source.setBounds(370,460,70,30);source.setForeground(new Color(123,247,243));
		destination.setBounds(520,460,70,30);destination.setForeground(new Color(123,247,243));
		dateandtime.setBounds(660,460,150,30);dateandtime.setForeground(new Color(123,247,243));
		fair.setBounds(820,460,70,30);fair.setForeground(new Color(123,247,243));
		
		userdetails=new JLabel("User Details");
		registration_number=new JLabel("Registration Number");
		name=new JLabel("Name");
		id_number=new JLabel("ID Number");
		phone_number=new JLabel("Phone Number");
		addresse=new JLabel("Address");
		gender=new JLabel("Gender");
		nationality=new JLabel("Nationality");
		
		userdetails.setBounds(415,550,150,30);userdetails.setForeground(new Color(123,247,243));
		userdetails.setFont( new Font("",Font.BOLD,16));
		registration_number.setBounds(60,580,130,30);registration_number.setForeground(new Color(123,247,243));
		name.setBounds(220,580,70,30);name.setForeground(new Color(123,247,243));
		id_number.setBounds(370,580,70,30);id_number.setForeground(new Color(123,247,243));
		phone_number.setBounds(520,580,130,30);phone_number.setForeground(new Color(123,247,243));
		addresse.setBounds(660,580,150,30);addresse.setForeground(new Color(123,247,243));
		gender.setBounds(820,580,70,30);gender.setForeground(new Color(123,247,243));
		nationality.setBounds(920,580,70,30);nationality.setForeground(new Color(123,247,243));
		
		
		
		table = new JTable();
		table1=new JTable();
		table.setBounds(45, 500, 850, 30);
		table1.setBounds(45, 620, 1020, 30);
		
		
		
		
		
		
		
		
		
		
		
		frame.add(registration_num);frame.add(flightcode);frame.add(flightclass);frame.add(flightcode1);
		frame.add(flightclass1);frame.add(source);frame.add(destination);
		frame.add(dateandtime);frame.add(fair);
		frame.add(registration_numtext);frame.add(flightcodetext);frame.add(flightclasstext);
		frame.add(cash);frame.add(debit);frame.add(showdetails);frame.add(table);frame.add(table1);
		frame.add(flightdetails);frame.add(userdetails);frame.add(registration_number);frame.add(name);
		frame.add(id_number);frame.add(phone_number);frame.add(addresse);frame.add(gender);
		frame.add(nationality);frame.add(add);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500,200,1200,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBackground(new Color(30,33,41));


	}
	public static void main(String []args)
	{
		new reservation();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String registration_num2=  registration_numtext.getText();
		String flightcode2=flightcodetext.getText();
		String flightclass2=flightclasstext.getText();
		try {
		
		if (e.getSource()==showdetails)
		{
			connection c = new connection();

	        String str = "select * from flight where flight_code = '"+flightcode2+"'and flight_class = '"+flightclass2+"'";
	        ResultSet rs=c.s.executeQuery(str);
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        String str1 = "select registration_num,name,id_number,phone_number,addresse,gender,nationality from passenger where registration_num = '"+registration_num2+"'";
	        ResultSet rs2=c.s.executeQuery(str1);
	        table1.setModel(DbUtils.resultSetToTableModel(rs2));
	            
	       
		}
		
	}catch(Exception ae){JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");}

}}
