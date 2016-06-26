package JSP;
//import java.beans.Statement;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;


public class CourseGradeBean implements Serializable {

    private PreparedStatement getCGList, addCGrades, delCGrades;

    private Statement statement = null;
    private Connection connection = null;
    private String url = "jdbc:db2://localhost:50000/IS345";

    public CourseGradeBean() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("user", "db2admin");
        prop.setProperty("password", "password");
        try
        {
            Class.forName("COM.ibm.db2.jdbc.app.DB2Driver").newInstance();
            connection = DriverManager.getConnection(url, prop);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            connection = null;
        }

        // set up statements for later calls to the database
        getCGList = connection.prepareStatement("SELECT tblCourse.CourseID, tblCourse.CourseName, "
                + "tblStudent.StudentName, tblStudent.Total, tblStudent.Percentage, tblStudent.ID "
                + "FROM tblCourse INNER JOIN tblStudent "
                + "ON tblCourse.CourseID = tblStudent.CourseID "
                + "WHERE tblCourse.CourseID = ?");

        addCGrades = connection.prepareStatement("INSERT INTO tblStudent (ID, StudentName, Total, CourseID, Percentage) "
                + "VALUES (?, ?, ?, ?, ?)");

        delCGrades = connection.prepareStatement("DELETE FROM tblStudent WHERE ID = ?");

    } // end of constructor

    public ArrayList<coursegrades> getCourseGradesList(String classID) throws SQLException {
        ArrayList<coursegrades> stud = new ArrayList<coursegrades>();
        getCGList.setString(1, classID);
        ResultSet results = getCGList.executeQuery();
        while(results.next())
        {
            coursegrades cGrad = new coursegrades();
            cGrad.setcID(results.getString(1));
            cGrad.setcName(results.getString(2));
            cGrad.setStuName(results.getString(3));
            cGrad.setTotPoints(results.getInt(4));
            cGrad.setTotPercent(results.getDouble(5));
            cGrad.setStuID(results.getInt(6));
            stud.add(cGrad);
        }
        return stud;
    }

    public synchronized void addCourseGrades(coursegrades cGrad, String classID) throws SQLException {
        addCGrades.setInt(1, cGrad.getStuID());
    	addCGrades.setString(2, cGrad.getStuName());
        addCGrades.setInt(3, cGrad.getTotPoints());
        addCGrades.setString(4, cGrad.getcID());
        cGrad.gradePercent(400.0);
        addCGrades.setDouble(5, cGrad.getTotPercent());
        addCGrades.executeUpdate();
    }

    public synchronized void delCourseGrades(int studentID) throws SQLException{
        delCGrades.setInt(1, studentID);
        delCGrades.executeUpdate();
    }

    public synchronized void Finalize() {
        try
        {
            getCGList.close();
            addCGrades.close();
            delCGrades.close();
            connection.commit();
            connection.close();
        }
        catch (SQLException sqlex)
        {
            sqlex.printStackTrace();
        }
    }
}
