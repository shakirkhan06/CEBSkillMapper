<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body bgcolor="">
	<jsp:include page="Header.jsp" />
<%-- 	<%
		String RID, BATCHANDLED, YOEXP, NOOFSTUDENT, STUDENTPLACED, STATUS;
		String rids = session.getAttribute("newrid").toString();
		if (rids != null) {
			RID = session.getAttribute("rid").toString();
			BATCHANDLED = session.getAttribute("BATCHANDLED").toString();
			YOEXP = session.getAttribute("YOEXP").toString();
			NOOFSTUDENT = session.getAttribute("NOOFSTUDENT").toString();
			STUDENTPLACED = session.getAttribute("STUDENTPLACED").toString();
			STATUS = session.getAttribute("STATUS").toString();

		} else {
			//session.invalidate();
			RID = "";
			BATCHANDLED = "";
			YOEXP = "";
			NOOFSTUDENT = "";
			STUDENTPLACED = "";
			STATUS = "";
		}
	%> --%>

<%
String rid=session.getAttribute("rid").toString();
String name=session.getAttribute("name").toString();
%>

	<div>
	<h1>Welcome : <label><%=name%></label></h1>
		<form name="form" action="SkillMaster" method="get">
			<table border="0" style="top: 50px; left: 550px; position: relative;">
				<caption>Registration Form</caption>
				<tr>
					<td>RID:</td>
					<td><input type="text" name="RID" value="<%=rid%>" /></td>
				</tr>
				<tr>
					<td>NAME:</td>
					<td><input type="text" name="Name" value="<%=name%>" /></td>
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
				
				<!-- <tr><td>CURRENTROLE:</td><td><select name="CURRENTROLE">
<option>Trainer</option>
<option>Mentor</option>
<option>Manager</option>
</select></td></tr>
<tr><td>REQUESTEDROLE:</td><td><select name="REQUESTEDROLE">
<option>SeniorTrainer</option>
<option>SeniorMentor</option>
<option>SeniorManager</option>
</select></td></tr> -->
				<tr>
					<td></td>
					<td><input type="hidden" name="STATUS" value="NotApproved" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="ADD" /></td>
				</tr>
			</table>
		</form>
		<h3>SkillSet</h3>
		<hr>
		<form action="SkillChild" method="get">
			<table border="0" style="top: 50px; left: 550px; position: relative;">
				<tr>
					<td><label>Skills:</label>&nbsp;</td>
					<td><select name="SKILLNAME" size="3" multiple="multiple"
						tabindex="1">
							<option value="java">Java</option>
							<option value="j2ee">J2ee</option>
							<option value="devops">DevOps</option>
							<option value="HTML5">HTML5</option>
							<option value="Angularjs">AngularJs</option>
							<option value="NodeJs">NodeJs</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Certification:</label>&nbsp;</td>
					<td><select name="INTEREXAM" size="3" multiple="multiple"
						tabindex="1">
							<option value="OCA">OCA</option>
							<option value="OCP">OCP</option>
							<option value="OCE">OCE</option>
							<option value="OCM">OCM</option>
							<option value="OCEJWCD">OCEJWCD</option>
							<option value="OCEJPAD">OCEJPAD</option>
							<option value="OCEEJBD">OCEEJBD</option>
							<option value="OCEJWSD">OCEJWSD</option>
							
					</select></td>
				</tr>

				<tr>
					<td>RID:</td>
					<td><input type="text" name="RID" value="<%=rid%>" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="UpdateSkills" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>