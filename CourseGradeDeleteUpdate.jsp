<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%-- page settings --%>
<%@ page errorPage = "CourseGradesErrorPage.jsp" %>
<%@ page import = "JSP.*" %>
<%-- beans used in this JSP --%>
<jsp:useBean id = "cgdata" scope = "page"
   class = "JSP.coursegrades" />
<jsp:useBean id = "cgbean" scope = "request"
 class = "JSP.CourseGradeBean" />


<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
   <title>Delete Bank Account </title>

   <style type = "text/css">
      body {
         font-family: tahoma, helvetica, arial, sans-serif;
      }

      table, tr, td {
         font-size: .9em;
         border: 3px groove;
         padding: 5px;
         background-color: #dddddd;
      }
      
   </style>
</head>

<body> 


 	    <p style = "font-size: 2em;">Delete Student</p>
            <p>  Student ID, Account Name, and Course ID have been deleted.
                         </p>

            <table>
               <tr>
                  <td>Student ID</td>

                  <td style = "width: 75px;"> 
               
                   <%= (String)session.getAttribute("StudentID") %>
                  </td>
               </tr>

				 <tr>
                  <td>Student Name</td>

                  <td>
                     <%= (String)session.getAttribute("StudName") %>
                  </td>
               </tr>
				
               <tr>
                  <td>Course ID</td>

                  <td>
                     <%= (String)session.getAttribute("CourseID") %> 
                  </td>
               </tr>


            </table>
            
            
            
         <form><p><a href="CourseGradesMenu.jsp">Main Menu</a></p>
</form>
 <%  //scriptlet
	  try  {
      cgbean.delCourseGrades(
          Integer.parseInt(session.getAttribute("StudentID").toString()));  
  
         cgbean.Finalize();
         session.invalidate();
	  }
 catch(Exception ex) 
 {
	 ex.printStackTrace();
 }

   %> <%-- end scriptlet --%>

</body>
</html>

