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
import com.entity.Subjects;
import com.entity.Teachers;

/**
 * Servlet implementation class AssignSubject
 */
@WebServlet("/AssignSubject")
public class AssignSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  ClassDAO classDAO=new ClassDAO();
		  
		  Classes cls=new Classes();
		  Subjects sb=new Subjects();
		  Teachers ts=new Teachers();
		   
		  ResultSet rs=null;
		  String qry1="Select classname from classes";
		  String qry2="Select subname from subjects";
		  String qry3="Select tname from teachers";
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  out.print("<!DOCTYPE html>");
		  out.print("<html><head>");
		  out.print("<title>Assign Subject to a class</title>");
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
		  out.print("<form action=\"AssignSubServlet\" method=\"post\">");
		  out.print("<table class=\"center\"><tr><td>Class Name </td>");
		  out.print("<td><select name=\"classname\">");
		  
		  rs=classDAO.Retrievedata(qry1);
		  try {
				while(rs.next()) {
				  cls.setClassname(rs.getString("classname"));
				  out.print("<option>" + cls.getClassname() + "</option>"); 
				}
				classDAO.closeConnection();
			  } catch (SQLException e) {
				e.printStackTrace();
			  }	
		  
		  out.print("</select</td></tr>");
		  out.print("<tr><td>Subject Name </td>");
		  out.print("<td><select name=\"subname\">");
		  
		  rs=classDAO.Retrievedata(qry2);
		  try {
				while(rs.next()) {
				  sb.setSubname(rs.getString("subname"));
				  out.print("<option>" + sb.getSubname() + "</option>"); 
				}
				classDAO.closeConnection();
			  } catch (SQLException e) {
				e.printStackTrace();
			  }	
		  out.print("</select</td></tr>");
		  out.print("<tr><td>Teacher Name </td>");
		  out.print("<td><select name=\"teachname\">");
		  
		  rs=classDAO.Retrievedata(qry3);
		  try {
				while(rs.next()) {
				  ts.setTname(rs.getString("tname"));
				  out.print("<option>" + ts.getTname() + "</option>"); 
				}
				classDAO.closeConnection();
			  } catch (SQLException e) {
				e.printStackTrace();
			  }	
		  out.print("</select</td>");
		  out.print("</tr></table>");
		  out.print("<input type=\"submit\" value=\"Assign\" ");
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
