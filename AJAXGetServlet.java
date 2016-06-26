import java.io.IOException;
import javax.servlet.ServletException;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;

/**
 * @version 	1.0
 * @author
 */
public class AJAXGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

			// Add code here
			String key = req.getParameter("fname");
			if (key != null) {

									
				System.out.print( " Servlet" + key);
				// setup the response
				String decimalString = "HI " + key; //Integer.toString(keyInt);
				resp.setContentType("text/xml");
				resp.setHeader("Cache-Control", "no-cache");
				 // write out the xml string
				resp.getWriter().write(decimalString);
				 }

		}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
		}

}
