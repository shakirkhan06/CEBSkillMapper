package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SkillSet
 */
@WebServlet("/SkillMaster")
public class SkillMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillMaster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Class.forName("org.h2.Driver");
			Connection connection=DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String BATCHANDLED=request.getParameter("BATCHANDLED");
			String YOEXP=request.getParameter("YOEXP"); 
			String NOOFSTUDENT=request.getParameter("NOOFSTUDENT"); 
			String STUDENTPLACED=request.getParameter("STUDENTPLACED");
			//String CURRENTROLE=request.getParameter("CURRENTROLE");
			//String REQUESTEDROLE=request.getParameter("REQUESTEDROLE"); 
			String RID=request.getParameter("RID");
			String STATUS=request.getParameter("STATUS");
			PreparedStatement PreparedStatement = connection.prepareStatement("insert into skillmaster(BATCHANDLED,YOEXP,NOOFSTUDENT,STUDENTPLACED,RID,STATUS)values(?,?,?,?,?,?)");
			PreparedStatement.setString(1, BATCHANDLED);
			PreparedStatement.setString(2, YOEXP);
			PreparedStatement.setString(3, NOOFSTUDENT);
			PreparedStatement.setString(4, STUDENTPLACED);
			//PreparedStatement.setString(5, CURRENTROLE);
			//PreparedStatement.setString(6, REQUESTEDROLE);
			PreparedStatement.setString(5, RID);
			PreparedStatement.setString(6, STATUS);
			PreparedStatement.executeUpdate();
	        out.println("Skills Inserted");
			}
			catch(Exception t)
			{
				System.out.println(t);
			}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
}