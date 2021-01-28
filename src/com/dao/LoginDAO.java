package com.dao;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.entity.Admin;



public class LoginDAO {

	private static String driver;
	private static String db_url;
	private static String username;
	private static String password;
	InputStream in;


	public LoginDAO() {
		super();
		
	}

	public void getDetails() throws IOException {
		Properties prop= new Properties();
		String filename="dbconfig.properties";
		in= getClass().getClassLoader().getResourceAsStream(filename);
		if(in!=null) {
			prop.load(in);
			driver= prop.getProperty("JDBC_DRIVER");
			db_url= prop.getProperty("DB_URL");
			username= prop.getProperty("Username");
			password= prop.getProperty("Password");
			System.out.println(""+driver+db_url+username+password+"creating connection" );

		}else {
			throw new FileNotFoundException("file could not be found");
			}

	}

	public static Connection createConnection(LoginDAO da) {
		Connection con = null;
		try {
			//System.out.println(""+driver+db_url+username+password+"creating connection" );

			da.getDetails();
			System.out.println(""+driver+db_url+username+password+"creating connection" );
			Class.forName(driver);
			con= DriverManager.getConnection(db_url,username,password);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
		
		return con;
		}
	

	public boolean validate(Admin admin,Connection con) {
        boolean status = false;

        try {

            // Create a statement using connection object
            PreparedStatement preparedStatement = con
            .prepareStatement("select * from login where username = ? and password = ? ");
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
        
        return status;
    }

}
