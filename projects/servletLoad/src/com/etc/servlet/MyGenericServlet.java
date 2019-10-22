package com.etc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class MyGenericServlet extends HttpServlet {

	public  void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		
		res.getWriter().println("hello,world,i am geneirc servlet");
		
	}
	
}
