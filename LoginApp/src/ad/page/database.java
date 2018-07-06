package ad.page;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;
 

public class database {

	//constants
		String DB_NAME = "jdbc:mysql://localhost/ggits";
		String DB_USER = "root";
		String DB_PASS = "ggits";
		public String register(String user, String pass) {
			// TODO Auto-generated method stub
			String result = "ggits";
			
			//Database Connections
			try{
				//Create connection
				Connection con = (Connection)DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
				
				//create statement
				Statement st = (Statement) con.createStatement();
				//create and execute query
				String query = "insert into login(user,pass)VALUES"+"('" + user + "','" + pass + "')";
				System.out.println(query);
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
		public String login(String user, String pass) {
			// TODO Auto-generated method stub
			
			String result = "login failed";
			
			//Database Connections
			try{
				//Create connection
				Connection con = (Connection)DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);
				
				//create statement
				Statement st = (Statement) con.createStatement();
				//create and execute query
				String query = "SELECT user from login where user= '"+user+"' and pass= '"+pass+"'";
				
			ResultSet rs = st.executeQuery(query);
				while(rs.next()){
					String c_user = rs.getString("user");
					if(c_user.matches(user)){
						result = "login success";
				}
				else{
					result = "login failed";
				}
			}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}

	}
