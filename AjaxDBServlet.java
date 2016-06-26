import java.io.IOException;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.sql.*;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;

/**
 * @version 	1.0
 * @author
 */
public class AjaxDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	private Statement statement = null;
    private Connection connection = null;
    private String query = null;
    String strreq = " ";
    
    public void init(ServletConfig config) throws ServletException
    {
    	super.init(config);
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(
    		"jdbc:mysql://localhost/IS345", "is345","password");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace(); 
    		connection = null;
    	}
    	
    }
	   

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
		String key = req.getParameter("name");
		if(key != null){
			String retString = AccessEmployee(key);
			resp.setContentType("text/html");
			resp.setHeader("cache-Control", "no-cache");
			resp.getWriter().write(retString);
		}
	
		 
	
	  }


	public synchronized String AccessEmployee(String name)
	{


		query = "SELECT * From Employees Where EmpName = '"
		   + name + "'";
		String Homephone = " ";
		System.out.print(query);
		boolean readgood = true;

		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			readgood = rs.next();

			if (readgood)
			{
				Homephone = rs.getString(3);
			}

			// }


			statement.close();
		}
		catch (Exception e)
		{
			System.err.println("Error");
			e.printStackTrace();
		}
		return Homephone;
	}

	  public void destroy()
	  {
		 try {
			connection.close();
		 }
		 catch( Exception e ) {
			System.err.println( "Problem closing the database" );
		 }
	  }

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
		}

}
