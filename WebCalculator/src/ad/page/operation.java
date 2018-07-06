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
 * Servlet implementation class operation
 */
@WebServlet("/operation")
public class operation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int result;
	
	//Database CONSTANTS
	String DB_NAME = "jdbc:mysql://localhost/ggits";
	String DB_USER = "root";		
	String DB_PASS ="ggits";
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operation() {
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
		//receive the parameters from user
		// intA,intB and operation
		int intA = Integer.parseInt(request.getParameter("intA"));
		int intB = Integer.parseInt(request.getParameter("intB"));
		String op = request.getParameter("opn");
		
		//Process 1 -> Mathematical operation
		if(op.matches("opAdd")){
			result = intA + intB;
		}
		else if (op.matches("opSub")){
			result = intA - intB;
		}
		else if (op.matches("opMultiply")){
			result = intA * intB;
		}
		else if (op.matches("opDivide")){
			result = intA / intB;
		}
		else{
			//Do nothing
		}
			
		//process 2 -> Database operations	
		// 1.) register the mysql database driver
		try{
			
		
		DriverManager.registerDriver(new Driver());
		
		//2.) get connection into database
		Connection con = (Connection)DriverManager.getConnection(DB_NAME, DB_USER, DB_PASS);
		//3.) create a statement
		Statement st = (Statement)con.createStatement();
		//4.) Create a query
		String query = "INSERT into calculator(intA,intB,operation,result) VALUES('"+intA+"', '"+intB+"', '"+op+"', '"+result+"')";
		//5.)execute query and get rows affected
		int rowsAffected = st.executeUpdate(query);
		//6.) check and respond the result
		PrintWriter output = response.getWriter();
		if(rowsAffected > 0){
			output.print("Result is = "+result+" and  data saved sucessfully");
		}
		else{
			output.print("Result is = "+result+" and  data saved failed");
		}
	
	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		

	}

}
