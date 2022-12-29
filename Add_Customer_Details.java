import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.Color;

public class Add_Customer_Details extends JFrame implements ActionListener{

	JFrame frame=new JFrame("Air Line Reservation System");
    Container c = frame.getContentPane();
    JLabel name,id_number,phone_number,address,nationality;
    JTextField nametext,id_numbertext,phone_numbertext,addresstext,nationalitytext;
    JRadioButton radiobutton1,radiobutton2;
    JButton add,back;
	Add_Customer_Details()
	{
		
		name=new JLabel("Name");
		id_number=new JLabel("ID Number");
		phone_number=new JLabel("Phone Number");
		address=new JLabel("Address");
		nationality=new JLabel("Nationality");
		
		
		nametext=new JTextField();
		id_numbertext=new JTextField();
		phone_numbertext=new JTextField();
		addresstext=new JTextField();
		nationalitytext=new JTextField();
		
		
		//jlabel setting
		name.setBounds(30,50,50,20);
		id_number.setBounds(30,200,200,20);
		phone_number.setBounds(30,350,200,20);
		address.setBounds(30,500,200,20);
		nationality.setBounds(30,425,200,20);
		
		
		name.setFont(new Font("Times New Roman",Font.PLAIN,20) );name.setForeground(new Color(59,114,252));
		id_number.setFont(new Font("Times New Roman",Font.PLAIN,20) );id_number.setForeground(new Color(59,114,252));
		phone_number.setFont(new Font("Times New Roman",Font.PLAIN,20) );phone_number.setForeground(new Color(59,114,252));
		address.setFont(new Font("Times New Roman",Font.PLAIN,20) );address.setForeground(new Color(59,114,252));
		nationality.setFont(new Font("Times New Roman",Font.PLAIN,20) );nationality.setForeground(new Color(59,114,252));
		
		
		nametext.setBounds(250,50,200,20);
		id_numbertext.setBounds(250,200,200,20);
		phone_numbertext.setBounds(250,350,200,20);
		addresstext.setBounds(250,500,200,20);
		nationalitytext.setBounds(250,425,200,20);
		
		nametext.setFont(new Font("Times New Roman",Font.PLAIN,20) );nametext.setForeground(new Color(59,114,252));
		id_numbertext.setFont(new Font("Times New Roman",Font.PLAIN,20) );id_numbertext.setForeground(new Color(59,114,252));
		phone_numbertext.setFont(new Font("Times New Roman",Font.PLAIN,20) );phone_numbertext.setForeground(new Color(59,114,252));
		addresstext.setFont(new Font("Times New Roman",Font.PLAIN,20) );addresstext.setForeground(new Color(59,114,252));
		nationalitytext.setFont(new Font("Times New Roman",Font.PLAIN,20) );nationalitytext.setForeground(new Color(59,114,252));
		  
		radiobutton1=new JRadioButton("Male");    
		radiobutton2=new JRadioButton("Female");
		radiobutton1.setBackground(new Color(255, 0, 0, 20));radiobutton1.setForeground(new Color(59,114,252));
		radiobutton1.setOpaque(false);
		radiobutton2.setBackground(new Color(255, 0, 0, 20));radiobutton2.setForeground(new Color(59,114,252));
		radiobutton2.setOpaque(false);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(radiobutton1);bg.add(radiobutton2);  
		radiobutton1.setBounds(300,650,100,50);
		radiobutton2.setBounds(600,650,100,50);
		
		add=new JButton("ADD");
		add.setBounds(300,700,100,30);
		add.addActionListener(this);
		back=new JButton("Go Back to Main Menu");
		back.setBounds(420,700,200,30);
		back.addActionListener(this);
		
		
		
		frame.add(name);frame.add(id_number);frame.add(phone_number);frame.add(address);frame.add(nationality);
		
		frame.add(nametext);frame.add(id_numbertext);frame.add(phone_numbertext);frame.add(addresstext);
		frame.add(nationalitytext);
		frame.add(radiobutton1);frame.add(radiobutton2);frame.add(add);frame.add(back);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(600,100,800,1000); 
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBackground(new Color(33, 47, 61 ));
		
		
	}
	public static void main(String[] args)
	{
		new Add_Customer_Details();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
        if (e.getSource()==add) {
        	String name1 = nametext.getText();
        	String id_numbertext1 = id_numbertext.getText();
        	String phone_numbertext1 =  phone_numbertext.getText();
        	String addresstext1 = addresstext.getText();
        	String nationality1 = nationalitytext.getText();
        	int registration=0;
        	String gender = null;
        if(radiobutton1.isSelected()){
            gender = "Male";

        }
        else if(radiobutton2.isSelected()){
            gender = "Female";
        }
        try {
            connection c = new connection();
            String str = "INSERT INTO passenger values('"+registration+"','"+name1+"','"+id_numbertext1+"','"+phone_numbertext1+"','"+addresstext1+"','"+gender+"','"+nationality1+"')";
            String str1 = "select registration_num from passenger where name = '"+name1+"'";
            
            c.s.executeUpdate(str);
            ResultSet rs=c.s.executeQuery(str1);
            rs.next();
            
            String registernum = rs.getString("registration_num");
          
            
            JOptionPane.showMessageDialog(null,registernum);
            setVisible(false);
            }
       
         catch (Exception a) {
            a.printStackTrace();
    

	}}
 else if(e.getSource()==back) {
	 	frame.dispose();
		new mainmenu();
        }
	}
	}

