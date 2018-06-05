<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyProject</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body bgcolor="">
	<jsp:include page="Header.jsp" />
	<form name="form" action="LoginPage" method="post">
		<div>
			<table border="0" style="top: 50px; left: 550px; position: relative;">
				<caption>Login Form</caption>
				<tr>
					<td>User Id</td>
					<td><input type="text" name="rid" required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td><input style="width: 100%;" class="w3-container w3-blue"
						type="submit" /></td>
					<td><input style="width: 100%;" class="w3-container w3-blue"
						type="reset" /></td>
				</tr>
			</table>
		</div>
	</form>
	<div></div>
</body>
</html>