

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;


public class login implements ActionListener  {


	
	JFrame f=new JFrame();
	JLabel username,password;
	JTextField usernametext,passwordtext;
	JButton login;
	login()
	{
		
		
		username=new JLabel("username");
		username.setBounds(10,50,150,20);
		password = new JLabel("Passowrd");
		password.setBounds(10,100,150,20);
		usernametext=new JTextField();
		usernametext.setBounds(70,50,150,20);
		passwordtext=new JTextField();
		passwordtext.setBounds(70,100,150,20);
		login=new JButton("login");
		login.setBounds(75,200,150,50);
		login.addActionListener(this);
		f.add(username);f.add(password);f.add(usernametext);f.add(passwordtext);f.add(login);
		f.setTitle("Air Line Reservation System");
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(750,300,300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==login)
		{
			try {
			connection c1=new connection();
			String s1=usernametext.getText();
			String s2=passwordtext.getText();
			String str="select * from login where username ='"+s1+"'and password ='"+s2+"'";
	    	ResultSet rs=c1.s.executeQuery(str);
	        if(rs.next()) {
	    		new mainmenu();
	    		 f.dispose();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null,"invalid login");
	    		//setVisible(false);
	    	}
	        }
	        catch(Exception ae){
	            
	        }
			
		}
	}
	
public static void main(String[] args) {
    new login();
}}