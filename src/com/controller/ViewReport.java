package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.ClassDAO;
import com.entity.Classes;

/**
 * Servlet implementation class ViewReport
 */
@WebServlet("/ViewReport")
public class ViewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ClassDAO classDAO=new ClassDAO();
		  String qry="Select classid,classname from classes";
		  Classes cls=new Classes();
		  
		  ResultSet rs=classDAO.Retrievedata(qry);
		  
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.print("<html><head>");
		  out.print("<title>View Class Report</title>");
		  out.print("</head>");
		  out.print("<body>");
		  out.print("<div align=\"center\">");
		  out.print("<h1>Welcome to Learners Academy</h1>");
		  out.print("<br/>");
		  out.print("<br/>");
		  out.print("<h2>Excellence and beyond</h2>");
		  out.print("<h2>----------------------------------------------</h2>");
		  out.print("<div align=\"right\">");
		  out.print("<a href=\"index.jsp\">Log out</a>");
		  out.print("</div>");
		  out.print("<a href=\"Classes\">Classes </a>");
		  out.print("<a href=\"Students\">Students </a>");
		  out.print("<a href=\"Teachers\">Teachers </a>");
		  out.print("<a href=\"Subjects\">Subjects </a>");
		  out.print("<a href=\"ViewReport\">View class Report</a>");
		  out.print("<br/>");
		  out.print("<form action=\"ViewReport.jsp\">");
		  out.print("<table class=\"center\"><tr><td>Class Name</td>");
		  out.print("<td><select name=\"classname\">");
		  
		  try {
				while(rs.next()) {
				  cls.setClassid(rs.getInt("classid"));
				  cls.setClassname(rs.getString("classname"));
				  out.print("<option>" + cls.getClassname() + "</option>"); 
				}
				classDAO.closeConnection();
			  } catch (SQLException e) {
				e.printStackTrace();
			  }
		  
		  out.print("</select></td></tr>");
		  out.print("</table>");
		  out.print("<input type=\"submit\" value=\"Submit\" />");
		  out.print("</form></div>");
		  out.print("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
