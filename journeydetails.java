
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;

public class journeydetails  implements ActionListener {

	JFrame frame=new JFrame("Air Line Reservation System");
    Container c1 = frame.getContentPane();
    JLabel flightcode,flightclass,source,destination,dateandtime,fair;
    JComboBox combobox1,combobox2;
    JButton show,back;
    JTable table;
	journeydetails()

	{
		
		
		flightcode=new JLabel("Flight Code");
		flightclass=new JLabel("Flight Class");
		source=new JLabel("Source");
		destination=new JLabel("Destination");
		dateandtime=new JLabel("Date and Time");
		fair=new JLabel("Fair");
		
		flightcode.setBounds(10,150,70,30);
		flightclass.setBounds(160,150,70,30);
		source.setBounds(310,150,70,30);
		destination.setBounds(460,150,70,30);
		dateandtime.setBounds(610,150,150,30);
		fair.setBounds(760,150,70,30);
		
		flightcode.setForeground(new Color(123,247,243));
		flightclass.setForeground(new Color(123,247,243));
		source.setForeground(new Color(123,247,243));
		destination.setForeground(new Color(123,247,243));
		dateandtime.setForeground(new Color(123,247,243));
		fair.setForeground(new Color(123,247,243));
		
		String[] src= {"KARACHI","LAHORE","ISLAMABAD"};
		combobox1=new JComboBox(src);
		combobox1.setBounds(20,5,80,20);
		
		combobox2=new JComboBox(src);
		combobox2.setBounds(300,5,80,20);
		show=new JButton("show");
		show.setBounds(400,100,150,25);
		show.addActionListener(this);
		
		back=new JButton("Go Back to Main Menu");
		back.setBounds(600,100,200,25);
		back.addActionListener(this);
		table = new JTable();
		table.setBounds(15, 180, 850, 130);
		
		
		
		frame.add(flightcode);frame.add(flightclass);frame.add(source);frame.add(destination);
		frame.add(dateandtime);frame.add(fair);frame.add(combobox1);frame.add(combobox2);frame.add(show);
		frame.add(back);frame.add(table);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(500,200,860,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c1.setBackground(new Color(30,33,41));
	}
public static void main(String[]args)
{
	new journeydetails();
}
@Override
public void actionPerformed(ActionEvent e) {
	try{
		if (e.getSource()==show) {
			
        String src  = (String) combobox1.getSelectedItem();
        String dst  = (String) combobox2.getSelectedItem();

        connection c = new connection();

        String str = "select * from flight where src = '"+src+"' and dst = '"+dst+"'";
        ResultSet rs=c.s.executeQuery(str);

        if(rs.next()){
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }else{
            JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
            
        }}
else if(e.getSource()==back) {
			frame.dispose();
			new mainmenu();
		}
	}
		catch(Exception ae){}
}

}
