package ad.page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class getDirections
 */
@WebServlet("/getDirections")
public class getDirections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDirections() {
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
		// get request parameters  from client
		String  src = request.getParameter("Source");
		String dst = request.getParameter("destination");
		
		// Process -> Get destination from google
		//URL: origin & destination
		
		
		//1.)Specify REST Service URL
		String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+src+"&destination="+dst;
		
		//2.)CREATE a new URL
		URL myurl = new URL(url);
		//3.)Open the connection to url
		URLConnection con = myurl.openConnection();
		
		//4.)Read the response/input Stream
		InputStream inp_stream = con.getInputStream();
		
		//5.)read the input stream
		InputStreamReader str_rdr = new InputStreamReader(inp_stream);
		
		//6. convert binary to human readable language
		 BufferedReader br = new BufferedReader(str_rdr);
		 
		 //7. using buffered reader store data into JSON
		 String json_data ="";
		 String line = "";
		 //read data line by line using while loop
		 while((line = br.readLine())!= null){
			 json_data = json_data +line +"\n";
			 
		 }
		 //Parse JSON data to extract meaningful information
		PrintWriter output = response.getWriter();
		//output.print(json_data);
		//import JSON simple jar -copy to WEB-INF
		//8. create a new json parser
		JSONParser parser = new JSONParser();
		//9. parse json data using json object
		try{
			
		JSONObject JSON = (JSONObject)parser.parse(json_data);
		//10.) get roots json array
		JSONArray routes = (JSONArray)JSON.get("routes");
		
		// get index 0 from routes
		JSONObject route_zero = (JSONObject)routes.get(0);
		//12. get legs
		JSONArray legs = (JSONArray)route_zero.get("legs");
		//13.
		JSONObject legs_zero = (JSONObject)legs.get("legs_zero");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
