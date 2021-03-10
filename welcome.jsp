<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page </title>
</head>
<body>


  <%
  
  response.setHeader("cache-control","no-cache,no-store,must-revalidate");//http>1.0
  
    if(session.getAttribute("user") == null)
    	response.sendRedirect("login.jsp");
  
  %>
  <h2>Welcome To ${user}</h2>
  <br>
  <div class="container">
  <a href="welcome.jsp">Home</a>
  <a href="about.jsp">About us</a>
  <a href="admin.jsp">Admin</a>
  <a href="login.jsp">Logout</a>
  
  </div>

<form action="logout">
<input type="submit" value="Logout">

</form>
</body>
</html>