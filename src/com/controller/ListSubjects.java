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
import com.entity.Classsub;

/**
 * Servlet implementation class ListSubjects
 */
@WebServlet("/ListSubjects")
public class ListSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjects() {
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
		String qry="Select classname,subname,teachname  from classsub where classname=\"" + session.getAttribute("classname")+ "\"" ;
		Classsub cs=new Classsub();
		
		
		ResultSet rs=null;
		rs=classDAO.Retrievedata(qry);
		session.setAttribute("classname", session.getAttribute("classname"));
		RequestDispatcher rd=request.getRequestDispatcher("Mainmenu.jsp");
		out=response.getWriter();
		rd.include(request, response);
		
		out.print("Class Report for " + session.getAttribute("classname"));
		out.print("<table style=\"width:60%\">");
		out.print("<tr><th>Subject Name</th><th>Teacher Name</th></tr>");
		
		try {
			while(rs.next()) {
			   cs.setClassname(rs.getString("classname"));
			   cs.setSubname(rs.getString("subname"));
			   cs.setTeachname(rs.getString("teachname"));
			   
			   out.print("<tr><td>" + cs.getSubname() + "</td><td>" + cs.getTeachname() + "</td></tr>");
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
