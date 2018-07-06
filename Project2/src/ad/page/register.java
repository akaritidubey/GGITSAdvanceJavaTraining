package ad.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Database connection CONSTANTS
	String DB_NAME = "jdbc:mysql://localhost/ggits";
	String DB_USER = "root";		
	String DB_PASS ="ggits";
	
	private String result;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//receive the parameters using POST
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//processing - save the parameters into database
		// 1.)register the driver in apache tomcat
		try{
			
			DriverManager.registerDriver(new Driver());
			//2.)create a connection DB_NAME, DB_USER, DB_PASS
			
			Connection con = (Connection)DriverManager.getConnection(DB_NAME, DB_USER, DB_PASS);
			//3.) create a statement
			Statement st = (Statement)con.createStatement();
			//4.) Create a query
			String query = "INSERT into mylogin(email,pass) VALUES"+"( '"+email+"', '"+ pwd +"' )";
			//5.)execute query and get rows affected
			int rowsAffected = st.executeUpdate(query);
			//6.) check if rowsAffected
			if(rowsAffected > 0){
				//INSERTED
				result = "DATA INSERT SUCCESS";
			}
			else{
				result = "DATA INAERT FAILED";
			}
		//	7.) Display result on a Wab page
			PrintWriter output = response.getWriter();
			output.print(result);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		// Pre-requestics = MySQL connector JAR
		//Project properties -> JAva build path -> Libraries
		//Apply -> ok
		
		
		
		
	}

}
