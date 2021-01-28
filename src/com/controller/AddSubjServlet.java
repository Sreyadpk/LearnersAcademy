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
import com.entity.Subjects;

/**
 * Servlet implementation class AddSubjServlet
 */
@WebServlet("/AddSubject")
public class AddSubjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjServlet() {
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
		Subjects sd=new Subjects();
		
	    sd.setSubname(request.getParameter("subname"));
	   
		
		String qry="insert into subjects (subname) values (\"" + sd.getSubname() + "\")";
		int count=classDAO.insertData(qry);
		if(count>0) {
			rd=request.getRequestDispatcher("AddSubject.jsp");
			out=response.getWriter();
			rd.include(request, response);
			out.print("Subject added successfully");
		}
		classDAO.closeConnection();
	}

}
