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
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/Classes")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		String qry="Select classid,classname,tot_strength from classes";
		Classes cls=new Classes();
		
		
		ResultSet rs=classDAO.Retrievedata(qry);
		
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		
		out.print("<table style=\"width:60%\">");
		out.print("<tr><th>S No.</th><th>Class Name</th><th>Class strength</th></tr>");
		
        
		try {
			while(rs.next()) {
			  cls.setClassid(rs.getInt("classid"));
			  cls.setClassname(rs.getString("classname"));
			  cls.setTotstrength(rs.getInt("tot_strength"));
			   
			   
			  out.print("<tr><td>" + cls.getClassid() + "</td><td>" + cls.getClassname() + "</td><td>" + cls.getTotstrength() +  "</td>");
			   
			}
			classDAO.closeConnection();
			out.print("</table>");
			out.print("<a href=\"AddClasses\">Add New Class</a>");
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
