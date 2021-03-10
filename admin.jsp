<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.fujitsu.loginAndRegister.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


  <%
  
    if(session.getAttribute("user") == null)
    	response.sendRedirect("login.jsp");
  
  %>
  <br>
  <h3>This is ADMIN Module </h3>
    
    
  <a href="CreateController">Detials</a><br> 
   <c:forEach var="user" items="${users}">
   <br>
   <c:out value="${user}"></c:out>
   
   
   
   </c:forEach>
   
   
   
  
</body>
</html>