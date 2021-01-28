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

import com.dao.*;
import com.entity.*;


/**
 * Servlet implementation class TeachServlet
 */
@WebServlet("/Teachers")
public class TeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		String qry="Select tid,tname,age,gender,email,subject from teachers";
		Teachers ts=new Teachers();
		
	    ResultSet rs=null;
		rs=classDAO.Retrievedata(qry);
		
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		
		out.print("<table style=\"width:60%\">");
		out.print("<tr><th>S No.</th><th>Teacher Name</th><th>Age</th><th>Gender</th><th>Email ID</th><th>Subject</th></tr>");
		
		try {
			while(rs.next()) {
			    ts.setTid(rs.getInt("tid"));
			    ts.setTname(rs.getString("tname"));
			    ts.setAge(rs.getInt("age"));
			    ts.setGender(rs.getString("gender"));
			    ts.setEmail(rs.getString("email"));
			    ts.setSubject(rs.getString("subject"));
			   
			   out.print("<tr><td>" + ts.getTid() + "</td><td>" + ts.getTname() + "</td><td>" + ts.getAge() + "</td><td>" +
			             ts.getGender() + "</td><td>" + ts.getEmail() + "</td><td>" + ts.getSubject() +  "</td></tr>");
			}
			
			classDAO.closeConnection();
			out.print("</table>");
			out.print("<a href=\"AddTeachers\">Add New Teacher</a>");
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
