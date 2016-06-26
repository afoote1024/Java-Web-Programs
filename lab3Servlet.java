
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab3Servlet
 */
@WebServlet("/lab3Servlet")
public class lab3Servlet extends HttpServlet {
	private Statement statement = null;
	private Connection connection = null;
	private String query = null;
	String strreq = " ";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lab3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/IS345", "is345", "password");
		} catch (Exception e) {
			e.printStackTrace();
			connection = null;
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = req.getParameter("studentname");
		if (key != null) {
			String retString = AccessEmployee(key);
			resp.setContentType("text/html");
			resp.setHeader("cache-Control", "no-cache");
			resp.getWriter().write(retString);
		}
	}

	public synchronized String AccessEmployee(String name) {

		query = "SELECT * From tblStudent Where StudentName = '" + name + "'";
		String studname = " ";
		System.out.print(query);
		boolean readgood = true;

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			readgood = rs.next();

			if (readgood) {
				studname = rs.getString(1);
			}

			statement.close();
		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
		return studname;
	}

	public void destroy() {
		try {
			connection.close();
		} catch (Exception e) {
			System.err.println("Problem closing the database");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
