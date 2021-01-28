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
import com.entity.Teachers;

/**
 * Servlet implementation class AddTeachServlet
 */
@WebServlet("/AddTeacher")
public class AddTeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachServlet() {
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
		Teachers ts=new Teachers();

	
		ts.setTname(request.getParameter("tname"));
		ts.setAge(Integer.parseInt(request.getParameter("age")));
		ts.setGender(request.getParameter("gender"));
		ts.setEmail(request.getParameter("email"));
		ts.setSubject(request.getParameter("subname"));
		
		String qry="insert into teachers (tname,age,gender,email,subject) values (\"" + ts.getTname() + "\",\"" + ts.getAge() + "\",\"" +
		ts.getGender() + "\",\"" + ts.getEmail() + "\",\"" + ts.getSubject() + "\")";
		int count=classDAO.insertData(qry);
		if(count>0) {
			rd=request.getRequestDispatcher("AddTeacher.jsp");
			out=response.getWriter();
			rd.include(request, response);
			out.print("Teacher added successfully");
		}
		classDAO.closeConnection();
	}

}
