<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp" /> 
<%

HttpSession session1=request.getSession(true);
String rids=(String)session1.getAttribute("rid");

%>
<%
String status1=request.getParameter("status");
String query1="update SKILLMASTER  set status='"+status1+"' where rid='"+rids+"'";

//register driverclass
Class.forName("org.h2.Driver");
//create a connection
Connection connection=DriverManager.getConnection  ("jdbc:h2:tcp://localhost/~/test1", "sa","");
//create a statement
Statement statement=connection.createStatement();

statement.executeQuery(query1);

out.println("Updated...Sucess!!");
%>
<center><input type="submit" value="UPDATEDATA" /></center>
</form>


</body>
</html>