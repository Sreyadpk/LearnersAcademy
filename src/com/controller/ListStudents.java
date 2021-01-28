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
import javax.servlet.http.HttpSession;

import com.dao.ClassDAO;
import com.entity.Students;

/**
 * Servlet implementation class ListStudents
 */
@WebServlet("/ListStudents")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		String qry="Select stuid,studname,age,gender,emailid,class_name from students where class_name=\"" + session.getAttribute("classname")+ "\"" ;
		Students sd=new Students();
		
		
		ResultSet rs=null;
		rs=classDAO.Retrievedata(qry);
		session.setAttribute("classname", session.getAttribute("classname"));
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		out.print("Class Report for " + session.getAttribute("classname"));
		out.print("<table style=\"width:60%\">");
		out.print("<tr><th>Student Name</th><th>Age</th><th>Gender</th><th>Email ID</th><th>Class</th></tr>");
		
		try {
			while(rs.next()) {
			   sd.setStudid(rs.getInt("stuid"));
			   sd.setStudname(rs.getString("studname"));
			   sd.setAge(rs.getInt("age"));
			   sd.setGender(rs.getString("gender"));
			   sd.setEmail(rs.getString("emailid"));
			   sd.setClassname(rs.getString("class_name"));
			   
			   out.print("<tr><td>" + sd.getStudname() + "</td><td>" + sd.getAge() + "</td><td>" +
			             sd.getGender() + "</td><td>" + sd.getEmail() + "</td><td>" + sd.getClassname() +  "</td></tr>");
			}
			
            classDAO.closeConnection();
			out.print("</table>");
			
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
