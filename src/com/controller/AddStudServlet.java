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
import com.entity.Students;

/**
 * Servlet implementation class AddStudServlet
 */
@WebServlet("/AddStudent")
public class AddStudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudServlet() {
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
		Students sd=new Students();
		
	
		sd.setStudname(request.getParameter("studname"));
		sd.setAge(Integer.parseInt(request.getParameter("age")));
		sd.setGender(request.getParameter("gender"));
		sd.setEmail(request.getParameter("email"));
		sd.setClassname(request.getParameter("class"));
		
		String qry="insert into students (studname,age,gender,emailid,class_name) values (\"" + sd.getStudname() + "\",\"" + sd.getAge() + "\",\"" +
		sd.getGender() + "\",\"" + sd.getEmail() + "\",\"" + sd.getClassname() + "\")";
		int count=classDAO.insertData(qry);
		if(count>0) {
			rd=request.getRequestDispatcher("AddStudent.jsp");
			out=response.getWriter();
			rd.include(request, response);
			out.print("Student added successfully");
		}
		classDAO.closeConnection();
	}

}
