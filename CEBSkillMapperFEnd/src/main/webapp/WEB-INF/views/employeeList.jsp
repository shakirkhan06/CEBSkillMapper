<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Employee List</h3>
<jsp:include page="Header.jsp" /> 
<c:url var="addAction" value="/employee/modify" ></c:url>

<form:form action="${addAction}" modelAttribute="employees">
<table>

	<tr>
		<td>
			<form:label path="employeeid">
				<spring:message text="employeeid"/>
			</form:label>
		</td>
		<td>
			<form:input path="employeeid" />
		</td>
	</tr>
       <tr>
		<td>
			<form:label path="age">
				<spring:message text="age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="employeename">
				<spring:message text="employeename"/>
			</form:label>
		</td>
		<td>
			<form:input path="employeename" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="gender"/>
			</form:label>
		</td>
		<td>
			<form:input path="gender" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="mobile">
				<spring:message text="mobile"/>
			</form:label>
		</td>
		<td>
			<form:input path="mobile" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="pass">
				<spring:message text="pass"/>
			</form:label>
		</td>
		<td>
			<form:input path="pass" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="qualification">
				<spring:message text="qualification"/>
			</form:label>
		</td>
		<td>
			<form:input path="qualification" />
		</td> 
	</tr>
	
	<tr>
		<td colspan="2">
			
			
				<input type="submit"
					value="<spring:message text="Update Employee"/>" />
			
		</td>
	</tr>
</table>	
</form:form>

<br>
<h3>Employee List</h3>
<c:if test="${!empty list}">
	<table class="tg">
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Email</th>
		<th>password</th>
		<th>Mobile</th>
		<th>Gender</th>
		<th>Qualification</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${list}" var="emps">
		<tr>
			<td>${emps.employeeid}</td>
			<td>${emps.employeename}</td>
			<td>${emps.email}</td>
			<td>${emps.pass}</td>
			<td>${emps.mobile}</td>
			<td>${emps.gender}</td>
			<td>${emps.qualification}</td>
			<td><a href="<c:url value='/edit/${employees.employeeid}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${employees.employeeid}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>