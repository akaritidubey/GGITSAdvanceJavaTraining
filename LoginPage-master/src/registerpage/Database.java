package registerpage;

import java.sql.Connection;
 
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Database {
String DB_NAME="jdbc:mysql://localhost/ggits";
String DB_USER ="root";
String DB_PASS="ggits";

	
	public String register(String user, String pass) {
		String result="";
	try{
		Connection con =(Connection) DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
		Statement st=(Statement) con.createStatement();
		String query ="INSERT into login(user,pass) VALUES"+"('"+user+"','"+pass+"')";
		int rowAffected =st.executeUpdate(query);
		if(rowAffected>0){
			result="INSERT SUCCESS";
			}
		else {
			result ="INSERT FAILED";
			
		}
					
			
		
		
	}
	catch(SQLException e){
		
		e.printStackTrace();
		
		
	}
		return result;
		
		
		
		
	}
}
