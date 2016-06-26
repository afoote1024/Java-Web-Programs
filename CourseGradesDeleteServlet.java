package JSP;
import java.io.*;

import javax.servlet.ServletException;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CourseGradesDeleteServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Statement statement = null;
    private Connection connection = null;
    private String query = null;
    private String url = "jdbc:db2://localhost:50000/IS345";
    
    public void ConnectDB()
	 {

		Properties prop = new Properties();
		prop.setProperty("user", "db2admin");
		prop.setProperty("password", "password");

		try
		{
			Class.forName(
				  "COM.ibm.db2.jdbc.app.DB2Driver").newInstance();


			connection = DriverManager.getConnection(url, prop);

		}
		catch (ClassNotFoundException exp)
		{
			System.err.println(
			   " Failed to load driver");
			exp.printStackTrace();
			System.exit(1);
		}
		catch (IllegalAccessException exp)
		{
			System.err.println(
			   " Illegal Access");
			exp.printStackTrace();
			System.exit(1);
		}
		catch (InstantiationException exp)
		{
			System.err.println(
			   " Failed in instantiation");
			exp.printStackTrace();
			System.exit(1);
		}
		catch (SQLException exp)
		{
			System.err.println(
			 " Unable to connect");
			exp.printStackTrace();
			System.exit(1);
		}


	} // end of connection methods
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		HttpSession sesh = req.getSession();
    		ConnectDB();
    		
    		String studID = req.getParameter("StudentID");
    		sesh.setAttribute("StudentID", studID);
    		String jspurl = null;
			ResultSet rs=null;
    		query = "SELECT "
                    + "StudentName "
                    + "FROM tblStudent "
                    + "WHERE tblStudent.ID = " + studID;
    		
    		System.out.print(query);		
			boolean recFound = true;
			try
			{
			  statement = connection.createStatement();
			  rs = statement.executeQuery(query);

			  recFound = rs.next();
			  System.out.print(query);
			  if (recFound == false)
			  {
				  jspurl = "CourseGradesDeleteError.jsp";
			  }
			  else
			  {
				  sesh.setAttribute("StudName", rs.getString(1));
				  jspurl = "CourseGradeDeleteUpdate.jsp";
			  }
			  resp.sendRedirect(resp.encodeRedirectURL(jspurl));
			  
			  rs.close();
			  connection.close();
			  statement.close();
			}
			catch (Exception ex)
			{
				System.err.println("Error in doPost Method");
			}
    } // end of doPost
    
    public void destroy()
	{
	   try 
	   {
		  connection.close();
		  statement.close();
	   }
	   catch(Exception e) 
	   {
		  System.err.println( "Problem closing the database" );
	   }
	} // end of destroy

}
