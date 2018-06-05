package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SkillChild
 */
@WebServlet("/SkillChild")
public class SkillChild extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SkillChild() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("org.h2.Driver");
			Connection connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			String skills1="";
			String skills2="";
			String[] SKILLNAME = request.getParameterValues("SKILLNAME");
			for(int i=0; i<SKILLNAME.length; i++)
			{
				skills1+=SKILLNAME[i]+" ";
			}
			String[] INTEREXAM = request.getParameterValues("INTEREXAM");
			for(int i=0; i<INTEREXAM.length; i++)
			{
				skills2+=INTEREXAM[i]+" ";
			} 
			String RID=request.getParameter("RID");
			PreparedStatement PreparedStatement = connection.prepareStatement("insert into SkillChild(SKILLNAME,INTEREXAM,RID)values(?,?,?)");
			Statement statement=connection.createStatement();
			PreparedStatement.setString(1, skills1);
			PreparedStatement.setString(2, skills2);
			PreparedStatement.setString(3, RID);
			PreparedStatement.executeUpdate();
		}
		catch(Exception t)
		{
			System.out.println(t);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
