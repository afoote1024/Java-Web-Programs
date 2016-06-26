<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- Student List.jsp -->

<%-- page settings --%>
<%@ page errorPage = "CourseGradesErrorPage.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "JSP.*" %>

<%-- CourseGradesData to obtain Grades list --%>
<jsp:useBean id = "CGData" scope = "request"
   class = "JSP.CourseGradeBean" />


<html xmlns = "http://www.w3.org/1999/xhtml">

   <head>
     <title>Student Grades List  </title>

      <style type = "text/css">
         body {
            font-family: tahoma, helvetica, arial, sans-serif;
         }

         table, tr, td, th {
            text-align: center;
            font-size: .9em;
            border: 3px groove;
            padding: 5px;
            background-color: #dddddd;
         }
      </style>
   </head>

   <body>
      <p style = "font-size: 2em;">Student Grades List -
	<%= request.getParameter( "classid" ) %> </p>

      <table>
         <thead>
            <tr>
               <th style = "width: 100px;">ID</th>
               <th style = "width: 200px;">Name</th>
               <th style = "width: 100px;">Total Points</th>
               <th style = "width: 100px;">Percent</th>
  	       <th style = "width: 50px;">Grade</th>
            </tr>
         </thead>

         <tbody>

         <% // start scriptlet
		String classid = request.getParameter( "classid" );
            List studentList = CGData.getCourseGradesList
			(classid);
            Iterator studentListIterator = studentList.iterator();
            coursegrades studentb;
            CGData.Finalize();

            while ( studentListIterator.hasNext() ) {
               studentb = (JSP.coursegrades ) studentListIterator.next();

         %> <%-- end scriptlet; insert fixed template data --%>

               <tr>
               <td><%= studentb.getStuID() %></td>
               <td><%= studentb.getStuName() %></td>
		  		<td><%= studentb.getTotPoints() %></td>
             	<td><%= studentb.getTotPercent() %> </td>
		 		<td><%= studentb.letterGrade() %> </td>
                </tr>

         <% // continue scriptlet
		  //


            } // end while

         %> <%-- end scriptlet --%>

         </tbody>
      </table>

   </body>


</html>


