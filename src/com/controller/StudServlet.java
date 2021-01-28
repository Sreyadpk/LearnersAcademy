package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassDAO;
import com.entity.Students;

/**
 * Servlet implementation class StudServlet
 */
@WebServlet("/Students")
public class StudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		String qry="Select stuid,studname,age,gender,emailid,class_name from students";
		Students sd=new Students();
		
		
		ResultSet rs=null;
		rs=classDAO.Retrievedata(qry);
		
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		
		out.print("<table style=\"width:60%\">");
		out.print("<tr><th>S No.</th><th>Student Name</th><th>Age</th><th>Gender</th><th>Email ID</th><th>Class</th></tr>");
		
		try {
			while(rs.next()) {
			   sd.setStudid(rs.getInt("stuid"));
			   sd.setStudname(rs.getString("studname"));
			   sd.setAge(rs.getInt("age"));
			   sd.setGender(rs.getString("gender"));
			   sd.setEmail(rs.getString("emailid"));
			   sd.setClassname(rs.getString("class_name"));
			   
			   out.print("<tr><td>" + sd.getStudid() + "</td><td>" + sd.getStudname() + "</td><td>" + sd.getAge() + "</td><td>" +
			             sd.getGender() + "</td><td>" + sd.getEmail() + "</td><td>" + sd.getClassname() +  "</td></tr>");
			}
            classDAO.closeConnection();
			out.print("</table>");
			out.print("<a href=\"AddStudents\">Add New Student</a>");
		} catch (SQLException e) {
			e.printStackTrace();
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
