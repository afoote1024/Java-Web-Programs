package JSP;
import java.io.*;
import java.sql.*;

/**
 * Date: 12/2/13
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class coursegrades {
    private String cID;
    private String cName;
    private String stuName;
    private int totPoints;
    private double totPercent;
    private int stuID;
    
    

    public int getStuID() {
		return stuID;
	}


	public void setStuID(int stuID) {
		this.stuID = stuID;
	}


	public String getcID() {
        return cID;
    }
    public String getcName() {
        return cName;
    }
    public String getStuName() {
        return stuName;
    }
    public int getTotPoints() {
        return totPoints;
    }
    public double getTotPercent() {
        return totPercent;
    }
    public void setcID(String val) {
        cID = val;
    }
    public void setcName (String val) {
        cName = val;
    }
    public void setStuName (String val) {
        stuName = val;
    }
    public void setTotPoints (int val) {
        totPoints = val;
    }
    public void setTotPercent (double val) {
        totPercent = val;
    }

    public coursegrades(String iD, String pCName, String pSName) {
        cID = iD;
        cName = pCName;
        stuName = pSName;
    }
    public coursegrades() {
        cID = "IS110B";
        cName = "Intro to Computers";
        stuName = " ";
    }
    public int testScores(int test1, int test2, int test3, int test4) {
        totPoints = 0;
        totPoints = test1 + test2 + test3 + test4;
        return totPoints;
    }
    public double gradePercent(double pPoss) {
        totPercent = totPoints / pPoss;
        totPercent = totPercent * 100;
        return totPercent;
    }
    public String letterGrade() {
        double grade = totPercent;
    	if (grade >= 90)
        {
            return "A";
        }
        else if (grade >= 80)
        {
            return "B";
        }
        else if (grade >= 70)
        {
            return "C";
        }
        else if (grade >= 60)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }

    public boolean readStudent(ObjectInputStream input) {
        boolean gtg = true;
        try {
            cID = input.readUTF().toString();
            cName = input.readUTF().toString();
            stuName = input.readUTF().toString();
            totPoints = input.readInt();
            totPercent = input.readDouble();
            stuID = input.readInt();
            gtg = true;
        }
        catch (EOFException ex)
        {
            System.out.println("End of File ");
            gtg = false;
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file ");
            System.err.println(" File Error " + ex.toString());
            gtg = false;
        }
        return gtg;
    }
    public boolean writeStudent(ObjectOutputStream output) {
        boolean gtg = true;
        try
        {
            output.writeUTF(cID);
            output.writeUTF(cName);
            output.writeUTF(stuName);
            output.writeDouble(totPoints);
            output.writeDouble(totPercent);
            output.writeInt(stuID);
            gtg = true;
        }
        catch(IOException ex)
        {
            gtg = false;
            System.out.println("Error writing file ");
            System.err.println(" File Error " + ex.toString());
            System.exit(1);
        }
        return gtg;
    }

    public void querySet(ResultSet rs) throws SQLException
    {
        cID = rs.getString(1);
        cName = rs.getString(2);
        stuName = rs.getString(3);
        totPoints = rs.getInt(4);
        totPercent = rs.getDouble(5);
        stuID = rs.getInt(6);
    }

}
