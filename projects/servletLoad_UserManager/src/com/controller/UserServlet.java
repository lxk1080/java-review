package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UsersDao;
import com.etc.entity.Users;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("op");
		
		if("delete".equals(op)){
			
			delete(request, response);
			
		} else if("updatePage".equals(op)){
			
			updatePage(request, response);
			
		} else if("update".equals(op)){
			
			update(request, response);

		} else if("add".equals(op)){
			
			Add(request, response);
			
		}
		
	}
	
	// 添加用户
	private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		String password = request.getParameter("password");
		
		Users u = new Users(0,username,email,grade,password);
		
		boolean sts = new UsersDao().addUser(u);
		
		if(sts){
			response.sendRedirect("/servletLoad_UserManager/ManagerUser");
		} else {
			out.println("添加失败！");
		}
	}

	// 修改用户的信息
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String pageNow = request.getParameter("pageNow");
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
		String password = request.getParameter("password");
		
		Users u = new Users(Integer.parseInt(id),username,email,grade,password);
		
		boolean b = new UsersDao().updateUser(u);
		
		if(b){
			response.sendRedirect("/servletLoad_UserManager/ManagerUser?pageNow="+pageNow);
		} else {
			out.println("修改失败！");
		}
	}

	// 修改用户的页面
	private void updatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pageNow = request.getParameter("pageNow");
		
		request.setAttribute("pageNow", pageNow);
		
		Users u = new UsersDao().getUserById(id);
		request.setAttribute("user", u);
		
		request.getRequestDispatcher("/UpdatePage").forward(request, response);
	}

	// 删除用户
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pageNow = request.getParameter("pageNow");
		
		boolean flag = new UsersDao().delUser(id);
		
		if(flag){
			response.sendRedirect("/servletLoad_UserManager/ManagerUser?pageNow="+pageNow);
		} else {
			out.println("删除失败！");
		}
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
