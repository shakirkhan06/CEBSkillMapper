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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Class.forName("org.h2.Driver");
			Connection connection=DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test1", "sa",""); 
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String skillname=request.getParameter("skillname");
			String sql="select A.BATCHANDLED,A.YOEXP,A.NOOFSTUDENT,A.STUDENTPLACED,A.STATUS,A.RID,B.SKILLNAME,B.INTEREXAM FROM SKILLMASTER A INNER JOIN  SKILLChild B  ON A.RID=B.RID where B.SKILLNAME=?";
			//String s2=request.getParameter("s1");
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, skillname);
			ResultSet resultset=preparedStatement.executeQuery();
			HttpSession session=request.getSession(true);
			while(resultset.next())
			{
				String SKILLNAME=request.getParameter("SKILLNAME");  
				String BATCHANDLED=resultset.getString("BATCHANDLED");
				String YOEXP=resultset.getString("YOEXP");
				String NOOFSTUDENT=resultset.getString("NOOFSTUDENT");
				String STUDENTPLACED=resultset.getString("STUDENTPLACED");
				String RID=resultset.getString("RID");
				String INTEREXAM=resultset.getString("INTEREXAM");
		        session.setAttribute("RID",RID); 
		        session.setAttribute("BATCHANDLED",BATCHANDLED);
		        session.setAttribute("YOEXP",YOEXP);
		        session.setAttribute("NOOFSTUDENT",NOOFSTUDENT);
		        session.setAttribute("STUDENTPLACED",STUDENTPLACED);
		        session.setAttribute("SKILLNAME",SKILLNAME);
		        session.setAttribute("INTEREXAM",INTEREXAM);
		        RequestDispatcher dispatch=request.getRequestDispatcher("Search.jsp");
				dispatch.forward(request, response);
			}
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
