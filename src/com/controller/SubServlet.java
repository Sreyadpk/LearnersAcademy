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
import com.entity.Subjects;

/**
 * Servlet implementation class SubServlet
 */
@WebServlet("/Subjects")
public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		String qry="Select subid,subname from subjects";
		Subjects subjects=new Subjects();
		
		ResultSet rs=null;
		rs=classDAO.Retrievedata(qry);
		
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		
		out.print("<table style=\"width:50%\">");
		out.print("<tr><th>  S.NO </th><th>Subject Name</th></tr>");
		
		try {
			while(rs.next()) {
			   subjects.setSubid(rs.getInt("subid"));
			   subjects.setSubname(rs.getString("subname"));
			  
			   out.print("<tr><td>" + subjects.getSubid() + "</td><td>" + subjects.getSubname() + "</td></tr>");
			}
            
			classDAO.closeConnection();
			out.print("</table>");
			out.print("<a href=\"AddSubjects\">Add New Subject</a>");
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
