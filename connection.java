import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
Connection c;
Statement s;
public connection(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///airlinereservation", "root", "");
    s=c.createStatement();
}
    catch(Exception e){
        System.out.println(e);
               
    }
}
}