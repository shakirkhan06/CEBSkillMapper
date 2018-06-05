<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyProject</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
//JavaScript Start code
function validate()//function
{
    //var empid = document.getElementById("empid").value;
    var empname = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var pass = document.getElementById("pass").value;
    var age = document.getElementById("age").value;
    var age = document.getElementById("mobile").value;
    var myDate = new Date(dateString);
    var today = new Date();
    if(name==="")//condition -1
    {
        document.getElementById("div2").innerHTML="Enter a employee name";
        document.getElementById("div2").style.color="Red";
        
    }
    else
    {
        document.getElementById("div2").innerHTML="";
    }
    if(email.indexOf("@")> -1)//condition -2
    {
        document.getElementById("div4").innerHTML="";
    }
     else
    {
        document.getElementById("div4").innerHTML="Enter the correct email address";
        document.getElementById("div4").style.color="Red";
        
    }
    if(pass.length<=6)//condition -3
    {
        document.getElementById("div3").innerHTML="Password is weak";
        document.getElementById("div3").style.color="Red";
    }
     else
    {
        document.getElementById("div3").innerHTML="";
    }
    if(age==="")//condition -4
    {
        document.getElementById("div5").innerHTML="Enter a age";
        document.getElementById("div5").style.color="Red";
        
    }
    else
    {
        document.getElementById("div5").innerHTML="";
    } 
  
}    
//JavaScript end Code
    </script>
</head>
<body bgcolor="">
<jsp:include page="Header.jsp" /> 
<form name="form" action="RegisterClass" method="post">
<!--  onsubmit="return validate()">-->
<div>
<table border="0" style="top:50px;left:550px;position:relative;">
<caption>Registration Form</caption>
<tr><td>User Name</td><td><input type="text" name="name" onClick="validate()" requried/></td><td><h6 id="div2"></h6></td></tr>
<tr><td>Password</td><td><input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" type="password" name="password" required onClick="validate()"/></td><td><h6 id="div3"></h6></td></tr>
<tr><td>Confirm Password</td><td><input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" type="password" name="conpassword" required="required"/></td></tr>
<tr><td>Age</td><td><input pattern="\d{3}" type="number" name="age" onClick="validate()"/></td><td><h6 id="div5"></h6></td></tr>
<tr><td>DOB</td><td><input type="date"  name="dob" placeholder="dd/mm/yyyy" required/></td></tr>
<tr><td>Gender</td><td><input type="radio" name="gender" value="Male"/>M<input type="radio" value="Female" name="gender"/>F</td></tr>
<tr><td>Mobile No</td><td><input type="number" name="mobile" required="required"/></td></tr>
<tr><td>Qualification</td><td><input type="text" name="qualification" required="required"/></td></tr>
<tr><td>Email Id</td><td><input type="email" name="email"/></td><td><h6 id="div4"></h6></td></tr>
<tr><td>Role</td><td><select name="role"><option>-Select-</option><option>CEO</option><option>GM</option><option>Manager</option><option>Academic Advisor</option><option>Tech Mentor</option></select></td></tr>
<tr><td><input style="width:100%;" class="w3-container w3-blue"  type="submit"/></td><td><input style="width:100%;" class="w3-container w3-blue"  type="reset"/></td></tr>
</table>
</div>
</form>
</body>
</html>