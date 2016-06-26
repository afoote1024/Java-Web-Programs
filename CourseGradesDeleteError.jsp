<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%-- page settings --%>
<%@ page errorPage = "CourseGradesErrorPage.jsp" %>

<%-- beans used in this JSP --%>


<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
   <title>Student Delete Error</title>

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
 	    <p style = "font-size: 2em;">Error on Student Delete</p>
            <p>  Student ID not on the database.
                         <br />
Please go back to  Delete Info Page and try again
               </p>

            <table>
               <tr>
                  <td>CourseID</td>

                  <td style = "width: 75px;"> 
               
                   <%= (String)session.getAttribute("CourseID") %>
                  </td>
               </tr>

				 <tr>
                  <td>Student ID</td>

                  <td>
                     <%= (String)session.getAttribute("StudentID") %>
                  </td>
               </tr>
				
               <tr>
                  <td>Student name</td>

                  <td>
                     <%= (String)session.getAttribute("StudName") %> 
                  </td>
               </tr>


              
            </table>
         <form>
<p><a href="CourseGradesDeleteServlet.html">Delete Info Page</a></p>
<p><a href="CourseGradesMenu.jsp">Main Menu</a></p>
</form>

 
</body>

</html>

