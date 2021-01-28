<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy</title>
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

</div>
</body>
</html>