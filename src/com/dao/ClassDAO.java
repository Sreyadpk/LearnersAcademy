package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassDAO {

	Connection con;
	Statement stmt;
	ResultSet rs;
	int log=0;
	LoginDAO da;
	
	public int insertData(String qry) {
		try {
			da=new LoginDAO();
		    con=LoginDAO.createConnection(da);
			stmt=con.createStatement();
			
			log=stmt.executeUpdate(qry);
			if(log==0) {
				System.out.println("Query not inserted" +qry);
				}
			else {
				System.out.println("Query inserted" +qry);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log; 
	}
	
	
public int updateData(String qry) {
		
		
		try {
			da=new LoginDAO();
		    con=LoginDAO.createConnection(da);
			stmt=con.createStatement();
			
			log=stmt.executeUpdate(qry);
			if(log==0) {
				System.out.println("Query not updated" +qry);
				}
			else {
				System.out.println("Query updated" +qry);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return log; 
	}
	
	public ResultSet Retrievedata(String qry) {
		
		try {
			da=new LoginDAO();
		    con=LoginDAO.createConnection(da);
			stmt=con.createStatement();
			rs=stmt.executeQuery(qry);
		}
		catch(SQLException se)
		{
	     se.printStackTrace();
	     }
		return rs;
	}
	public void closeConnection() {
		try {
			if(con!=null) {
			con.close();	
			}
		}
		catch(Exception e){ e.printStackTrace();}
	}
}
