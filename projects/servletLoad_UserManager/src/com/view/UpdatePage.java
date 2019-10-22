package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.entity.Users;

public class UpdatePage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Users u = (Users) request.getAttribute("user");
		String pageNow = (String) request.getAttribute("pageNow");
		
		out.println("<h1>修改用户</h1><hr>");
		out.println("<form action='/servletLoad_UserManager/UserServlet?op=update&pageNow="+pageNow+"' method='post'>");
		out.println("用户名:<input type='text' name='username' value='"+u.getUsername()+"'><br>");
		out.println("密　码:<input type='password' name='password' value='"+u.getPassword()+"'><br>");
		out.println("邮　箱:<input type='text' name='email' value='"+u.getEmail()+"'><br>");
		out.println("等　级:<input type='text' name='grade' value='"+u.getGrade()+"'><br>");
		out.println("<input type='hidden' name='id' value='"+u.getId()+"'>");
		out.println("<input type='submit' value='修改'>");

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
