<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
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
<form action="<%=request.getContextPath()%>/AddStudent" method="post">
<table>
    <tr>
     <td>Student Name</td>
     <td><input type="text" name="studname" /></td>
    </tr>
    <tr>
     <td>Age</td>
     <td><input type="number" name="age" /></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><select name="gender">
            <option value="M">Male</option>
            <option value="F">Female</option>
         </select>
     </td>
    </tr>
    <tr>
     <td>Email id</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Class</td>
     <td><input type="text" name="class" /></td>
    </tr>
   </table>
   <input type="submit" value="Add New Student" />
   </form>
</div>
</body>
</html>