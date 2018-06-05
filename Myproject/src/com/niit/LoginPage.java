package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*String newrid;*/
			HttpSession session=request.getSession(true); 
			String rids=request.getParameter("rid");
			String Password=request.getParameter("password");
			Class.forName("org.h2.Driver");
			/*Class.forName("org.h2.Driver");
			Connection connection1 = DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			String sql1="select * from skillMaster where rid="+rids+"";
			PreparedStatement preparedStatement1 = connection1.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement1.executeQuery();
			while(resultSet.next()) 
			{
				session.setAttribute("BATCHANDLED",resultSet.getString(1));
				session.setAttribute("YOEXP",resultSet.getString(2));
				session.setAttribute("NOOFSTUDENT",resultSet.getString(3));
				session.setAttribute("STUDENTPLACED",resultSet.getString(4));
				session.setAttribute("newrid",resultSet.getString(5));
				session.setAttribute("STATUS",resultSet.getString(6));
				//String a=resultSet.getString(1);
				//String url="SkillMaster.jsp?BATCHANDLED="+a+"";
				//RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
				//requestDispatcher.forward(request, response);
			}
			connection1.close();*/
			Connection connection = DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			String sql="select * from register where rid=? and password=?";
			//String s2=request.getParameter("s1");
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, rids);
			preparedStatement.setString(2, Password);
			ResultSet resultset=preparedStatement.executeQuery();
			
			while(resultset.next())
			{
				//System.out.println(role);
				String rid=request.getParameter("rid");  
				String name=resultset.getString("name");
				String role=resultset.getString("role");
		        session.setAttribute("rid",rid); 
		        session.setAttribute("name",name);
		        session.setAttribute("role",role);
		        if("HR".equals(role))
		        {
		        RequestDispatcher dispatch=request.getRequestDispatcher("HRHome.jsp");
				dispatch.forward(request, response);
		       }
		       else
		       {
		        RequestDispatcher dispatch=request.getRequestDispatcher("SkillMaster.jsp");
		        dispatch.forward(request, response);
		       }
		    }
			
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	

	}

}
