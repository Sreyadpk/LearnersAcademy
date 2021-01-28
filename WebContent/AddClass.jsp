<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Class</title>
</head>
<body>
<div align="center">
<h1>Welcome to Learners Academy</h1>
<br/>
<br/>
<h2>Excellence and beyond</h2>
<h2>----------------------------------------------</h2>
<div align="right">
<a href="index.jsp">Log out</a>
</div>
<a href="<%=request.getContextPath()%>/Classes">Classes</a>
<a href="<%=request.getContextPath()%>/Students">Students</a>
<a href="<%=request.getContextPath()%>/Teachers">Teachers</a>
<a href="<%=request.getContextPath()%>/Subjects">Subjects</a>
<a href="<%=request.getContextPath()%>/ViewReport">View class Report</a>

<form action="<%=request.getContextPath()%>/AddClass" method="post">
<table>
    <tr>
     <td>Class Name</td>
     <td><input type="text" name="classname" /></td>
    </tr>
    <tr>
     <td>Class Strength</td>
     <td><input type="number" name="totstrength" /></td>
    </tr>
   </table>
   <input type="submit" value="Add New Class" />
   </form>
</div>
</body>
</html>