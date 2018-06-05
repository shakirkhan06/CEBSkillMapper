<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-

1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-

8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>ApprovalPage</h4>
<hr/>
<center>

<%

String rid=request.getParameter("rid");
/* HttpSession session1=request.getSession(true);
String regids=(String)session1.getAttribute("regid"); */
String query="select A.BATCHANDLED,A.YOEXP,A.NOOFSTUDENT,A.STUDENTPLACED,A.STATUS,A.RID,B.SKILLNAME,B.INTEREXAM FROM SKILLMASTER A INNER JOIN  SKILLChild B  ON A.RID=B.RID where A.status='NotApproved'";

//register driverclass
  Class.forName("org.h2.Driver");
  //create a connection
  Connection connection=DriverManager.getConnection

		  ("jdbc:h2:tcp://localhost/~/test1", "sa","");
  //create a statement
  Statement statement=connection.createStatement();
   //execute a query
  ResultSet rs=statement.executeQuery(query);
  
   while(rs.next()){%>
<form action="approvalupdate.jsp" method="get">
<table border="1">
<th>BATCHANDLED</th>
<th>YOEXP</th>
<th>NOOFSTUDENT</th>
<th>STUDENTPLACED</th>
<th>RID</th>
<th>SKILLNAME</th>
<th>INTEREXAM</th>
<th>STATUS</th>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
<%-- <td><%=rs.getString(5)%></td> --%>
<td><label name="rids"><%=rs.getString(6)%></label></td>
<td><%=rs.getString(7)%></td>
<td><%=rs.getString(8)%></td>
<td>
<select name="status">
<option value="NotApproved">NotApproved</option>
<option value="Approved">Approved</option>
<option value="Denied">Denied</option>
</select>
</td>
</tr>

</table>

<%}%>


<center><input type="submit" value="UPDATEDATA" /></center>
</center>
</body>
</html>