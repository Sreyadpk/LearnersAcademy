package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.entity.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		LoginDAO loginDAO=new LoginDAO();
		con=LoginDAO.createConnection(loginDAO);
		RequestDispatcher rd=null;
		PrintWriter out;
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        try {
            if (loginDAO.validate(admin,con)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                rd=request.getRequestDispatcher("Mainmenu.jsp");
    			rd.forward(request, response);
            } else {
            	rd=request.getRequestDispatcher("index.jsp");
    			out=response.getWriter();
    			rd.include(request, response);
    			out.print("<center><span style='color:red'>Invalid credentials!!!</span></center>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
