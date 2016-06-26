<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!-- StudentMenu.jsp -->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
   <title>Student Menu to forward request to another JSP</title>
</head>

<body>
<% session.setAttribute("CourseID", request.getParameter("classid")); %>
 
         <c:if test="${param.Stu =='List'}">
        	 <jsp:forward page="CourseGradesList.jsp"></jsp:forward>
       </c:if>


         <c:if test="${param.Stu =='Del'}">
        	 <jsp:forward page="CourseGradesDeleteServlet.html"></jsp:forward>
       </c:if>

   
         <c:if test="${param.Stu =='Ins'}">
        	 <jsp:forward page="CourseGradesInsert.jsp"></jsp:forward>
       </c:if>


 	 <%-- end scriptlet to insert fixed template data --%>

         <form action = "CourseGradesMenu.jsp" method = "get">
             <h1>
                Student Grades </h1>
    

           <br><input type="radio" name="Stu" value="List" checked="checked">List Students Grades
            <br><input type="radio" name="Stu" value="Ins">Insert Student Grades
            <br><input type="radio" name="Stu" value="Del">Delete Student Grades
                   

           <p>Type your course id and press Submit</p>
            <p><input type = "text" name = "classid" />
               <input type = "submit" value = "Submit" />
            </p>
         </form>

  
</body>

</html>  <!-- end XHTML document -->


