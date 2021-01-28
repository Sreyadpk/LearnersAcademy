package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassDAO;
import com.entity.Classes;


/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClass")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		ClassDAO classDAO=new ClassDAO();
		RequestDispatcher rd;
		Classes cl=new Classes();
		
	    cl.setClassname(request.getParameter("classname"));
	    cl.setTotstrength(Integer.parseInt(request.getParameter("totstrength")));
		
		String qry="insert into classes (classname,tot_strength) values (\"" + cl.getClassname() + "\",\"" + cl.getTotstrength() + "\")";
		int count=classDAO.insertData(qry);
		if(count>0) {
			rd=request.getRequestDispatcher("AddClass.jsp");
			out=response.getWriter();
			rd.include(request, response);
			out.print("Class added successfully");
		}
		classDAO.closeConnection();
	}

}
