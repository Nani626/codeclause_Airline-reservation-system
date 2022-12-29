import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class delaccount implements ActionListener {
	JFrame frame=new JFrame("Air Line Reservation System");
    Container c = frame.getContentPane();
    JLabel delaccount,registration;
    JTextField registrationtext ;
    JButton delete,back;
delaccount(){
	delaccount=new JLabel("DELETE ACCOUNT");
	registration=new JLabel("Registration Number");
	registrationtext=new JTextField();
	
	delaccount.setBounds(170,100,350,30);
	registration.setBounds(65,245,300,30);
	registrationtext.setBounds(250,250,200,22);
	
	delaccount.setFont(new Font("Times New Roman",Font.BOLD,32) );delaccount.setForeground(new Color(13,255,196));
	registration.setFont(new Font("Times New Roman",Font.PLAIN,20) );registration.setForeground(new Color(13,255,196));
	registrationtext.setBackground(new Color(255, 0, 0, 20));registrationtext.setForeground(new Color(13,255,196));
	registrationtext.setOpaque(false);registrationtext.setFont(new Font("Times New Roman",Font.PLAIN,20) );
	
	delete=new JButton("DELETE");
	delete.setBounds(250,300,100,30);
	delete.addActionListener(this);
	
	frame.add(delaccount);frame.add(registration);frame.add(registrationtext);frame.add(delete);
	
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setBounds(700,250,650,650); 
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setBackground(new Color(33, 47, 61 ));
	
}
public static void main(String[]args)
{
	new delaccount();
}
@Override
public void actionPerformed(ActionEvent e) {
	String registration1=registrationtext.getText();
	// TODO Auto-generated method stub
	try {
		
		if(e.getSource()==delete)
		{
			
			connection c = new connection();
			String str="DELETE FROM passenger where registration_num = '"+registration1+"'";
			 int rs=c.s.executeUpdate(str);
			
		}
	}catch(Exception ae){JOptionPane.showMessageDialog(null,"No record");}
	
}
}
