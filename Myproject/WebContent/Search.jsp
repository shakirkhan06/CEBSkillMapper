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
<form name="form" action="Search" method="get">
			<table border="0" style="top: 50px; left: 550px; position: relative;">
				<caption>Registration Form</caption>
				<tr>
					<td>RID:</td>
					<td><input type="text" name="SKILLNAME" value="" /></td>
				</tr>
				<tr>
					<td>BATCHES HANDLED:</td>
					<td><input type="text" name="BATCHANDLED"
						<%-- value="<%=BATCHANDLED%>" --%> /></td>
				</tr>
				<tr>
					<td>YOEXP:</td>
					<td><input type="text" name="YOEXP" <%-- value="<%=YOEXP%>" --%> /></td>
				</tr>
				<tr>
					<td>NOOFSTUDENT:</td>
					<td><input type="text" name="NOOFSTUDENT"
						<%-- value="<%=NOOFSTUDENT%>" --%> /></td>
				</tr>
				<tr>
					<td>STUDENTPLACED:</td>
					<td><input type="text" name="STUDENTPLACED"
						<%-- value="<%=STUDENTPLACED%>"  --%>/></td>
				</tr>
				<tr>
					<td>RID:</td>
					<td><input type="text" name="RID"
						<%-- value="<%=STUDENTPLACED%>"  --%>/></td>
				</tr>
				<tr>
					<td>INTEREXAM:</td>
					<td><input type="text" name="INTEREXAM"
						<%-- value="<%=STUDENTPLACED%>"  --%>/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search" /></td>
				</tr>
				</table>
</body>
</html>