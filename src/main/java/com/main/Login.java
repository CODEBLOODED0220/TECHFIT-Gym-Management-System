package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.DBAccess;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class Login implements Servlet{
	ServletConfig config = null;
	ServletContext sc = null;
	DBAccess dbaccess = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
		this.sc = null;
		System.out.println("Destryoing the servlet object for Login for admin users");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.config.getInitParameter("info");
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
		
		this.sc = this.config.getServletContext();
		
		//Initialize the db object
		this.dbaccess = new DBAccess();
	
try {
    dbaccess.makeConnection(
        this.sc.getInitParameter("mysqldrivername"),
        this.sc.getInitParameter("dbUrl"),
        this.sc.getInitParameter("username"),
        this.sc.getInitParameter("password")
    );
    System.out.println("Database connection successful");
}
catch (SQLException | ClassNotFoundException e) {
    e.printStackTrace();
    throw new ServletException("Database connection failed", e);
}

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = arg1.getWriter();

		HttpServletResponse hrs = (HttpServletResponse) arg1;
		
		try {
			if(dbaccess.isValidUser(arg0.getParameter("username"),arg0.getParameter("password"))==true) {
				Cookie cookie = new Cookie("user","valid");
				hrs.addCookie(cookie);
				hrs.sendRedirect("home.jsp");
			}
			else {
				hrs.sendRedirect("index.jsp");
			}
		}
		catch(SQLException e) {
			pw.write("SQL error encountered");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			pw.write("Exception occured");
		}
	}
}
