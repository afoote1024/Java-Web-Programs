<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- CourseGradesInsert.jsp -->

<%-- page settings --%>
<%@ page errorPage = "CourseGradesErrorPage.jsp" %>

<%-- beans used in this JSP --%>
<jsp:useBean id = "cg" scope = "request"
   class = "JSP.coursegrades" />
<jsp:useBean id = "cgData" scope = "request"
   class = "JSP.CourseGradeBean" />

<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
   <title>Student Grade Entry</title>

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
   <jsp:setProperty name = "cg" property = "cID" param=
				  "cd"  />
	<jsp:setProperty name = "cg" property = "stuID" param="StuID" />		  
   <jsp:setProperty name = "cg" property = "stuName" param="StudentName" />
   <jsp:setProperty name = "cg" property = "totPoints" param="Totpoints" />

   <% // start scriptlet

      if (cg.getStuName() == null ||
	   cg.getTotPoints() < 1
           ) {

   %> <%-- end scriptlet to insert fixed template data --%>

         <form method = "post" action = "CourseGradesInsert.jsp">
		<p> Course ID - <%= request.getParameter( "classid" ) %> </p>
            <p>Enter Student Name and Total points.
               </p>

            <table>
               <tr>
                  <td>Course ID</td>

                  <td>
                     <input type = "text" name = "cd" value =
                      <%= request.getParameter( "classid" ) %> readonly="readonly"/>
                  </td>
               </tr>

					<tr>
					 <td>StudentID</td>

                  <td>
                     <input type = "text" name = "StuID" />
                  </td>
               </tr>
               
               <tr>
                  <td>Name</td>

                  <td>
                     <input type = "text" name = "StudentName" />
                  </td>
               </tr>


               <tr>
                  <td>Total Points</td>

                  <td>
                     <input type = "text" name = "Totpoints" />
                  </td>
               </tr>

               <tr>
                  <td colspan = "2">
                     <input type = "submit"
                        value = "Submit" />
                  </td>
               </tr>
            </table>

         </form>

   <% // continue scriptlet

      }  // end if
      else {
        cgData.addCourseGrades( cg,cg.getcID());
        cgData.Finalize();

   %> <%-- end scriptlet to insert jsp:forward action --%>

         <%-- forward to display guest book contents --%>
         <jsp:forward page = "CourseGradesMenu.jsp" />

   <% // continue scriptlet

      }  // end else

   %> <%-- end scriptlet --%>
</body>

</html>

