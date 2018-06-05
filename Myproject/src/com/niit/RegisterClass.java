package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;

@WebServlet("/RegisterClass")
public class RegisterClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterClass()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		try {
			PrintWriter out = response.getWriter();
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			//String query="select top rid+1 from register order by rid desc";
			//Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery(query);
			//while(rs.next())
			//{
			//	a=rs.getInt("rid");
			//}
			String Name=request.getParameter("name");
			String Password=request.getParameter("password");
			String Age=request.getParameter("age");
			String Dob=request.getParameter("dob");
			String Gender=request.getParameter("gender");
			String Mobile=request.getParameter("mobile");
			String Emailid=request.getParameter("email");
			String Qualification=request.getParameter("qualification");
			String Role=request.getParameter("role");
			PreparedStatement PreparedStatement = connection.prepareStatement("insert into register(NAME,PASSWORD,AGE,DOB,GENDER,MOBILE,EMAIL,QUALIFICATION,ROLE) values(?,?,?,?,?,?,?,?,?)");
			PreparedStatement.setString(1, Name);
			PreparedStatement.setString(2, Password);
			PreparedStatement.setString(3, Age);
			PreparedStatement.setString(4, Dob);
			PreparedStatement.setString(5, Gender);
			PreparedStatement.setString(6, Mobile);
			PreparedStatement.setString(7, Emailid);
			PreparedStatement.setString(8, Qualification);
			PreparedStatement.setString(9, Role);
			PreparedStatement.executeUpdate();
			connection.close();
			response.sendRedirect("index.jsp");
		}
		catch(Exception e){
			System.out.println(e);
		}


	}

}
