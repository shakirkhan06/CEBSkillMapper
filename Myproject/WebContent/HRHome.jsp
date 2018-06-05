<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp" /> 
<%
String query="select rid from skillmaster where status='NotApproved'";
//register driverclass
Class.forName("org.h2.Driver");
//create a connection
Connection connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test1", "sa","");
//create a statement
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery(query);
HttpSession session1=request.getSession();
session1.setAttribute("regid",request.getParameterValues("rids"));
%>
<form action="Approval.jsp" method="get">

<table>

<tr><td>EmpId:</td><td>
<select name="rids">
<% while(resultSet.next()){%>
<option><%=resultSet.getString(1)%></option>
<%} %>
</select>
</td></tr>
<tr><td><input type="submit" value="View"/></td></tr>
</table>
</form>
</body>
</html>