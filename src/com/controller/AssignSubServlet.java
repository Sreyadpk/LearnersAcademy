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

import com.dao.ClassDAO;

/**
 * Servlet implementation class AssignSubServlet
 */
@WebServlet("/AssignSubServlet")
public class AssignSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubServlet() {
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
		RequestDispatcher rd=null;
		ResultSet rs=null;
		int res=0,count=0,subExists=0;
		String className=request.getParameter("classname");
		String subName=request.getParameter("subname");
		String teachName=request.getParameter("teachname");
		String qry="select classname,subname from classsub where classname=\"" + className + "\" and subname=\"" + subName +"\"";
		rs=classDAO.Retrievedata(qry);
		
		try {
			while(rs.next()) {
			   res=1;
			}
            
			classDAO.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String qry1="select subject from teachers where tname=\"" + teachName +  "\"";
		rs=classDAO.Retrievedata(qry1);
		
		try {
			while(rs.next()) {
			   if(subName.equals(rs.getString("subject"))) {
				   subExists=1;
			   }
			}
            
			classDAO.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(subExists==0) {
			rd=request.getRequestDispatcher("Mainmenu.jsp");
			out=response.getWriter();
			rd.include(request, response);
			out.print("Teacher does not teaches" + subName + "<br/>");
			out.print("Please select correct teacher name");
		}
		else {
		if(res>0) {
			qry="update classsub set teachname=\"" + teachName + "\" where classname=\"" + className + "\" and subname=\"" + subName + "\"";
			count=classDAO.updateData(qry);
			if(count>0) {
				rd=request.getRequestDispatcher("Mainmenu.jsp");
				out=response.getWriter();
				rd.include(request, response);
				out.print("Teacher updated successfully");}
		}else {
			qry="insert into classsub(classname,subname,teachname) values(\"" + className + "\",\"" + subName + "\",\"" + teachName +
					"\")";
			count=classDAO.insertData(qry);
			if(count>0) {
				rd=request.getRequestDispatcher("Mainmenu.jsp");
				out=response.getWriter();
				rd.include(request, response);
				out.print("Subject added successfully");
			}
		 }
		}
	    classDAO.closeConnection();
	}

}
