package webDynamic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.*;

@SuppressWarnings("unused")
public class database {

	//constants
	String DB_NAME = "jdbc:mysql://localhost/ggits";
	String DB_USER = "root";
	String DB_PASS = "ggits";
	public String register(String user, String pass) {
		// TODO Auto-generated method stub
		String result = "";
		
		//Database Connections
		try{
			//Create connection
			Connection con = (Connection)DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
			
			//create statement
			Statement st = (Statement) con.createStatement();
			//create and execute query
			String query = ("insert into login(user,pass)VALUES"+"('" + user + "','" + pass + "')" );
			int rowAffected = st.executeUpdate(query);
			if(rowAffected>0){
				result = "insert success";
			}
			else{
				result = "insert failed";
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

}
