package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.UsersDao;
import com.etc.entity.Users;

public class ManagerUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManagerUser() {
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
		
		int pageNow = 1; //当前页，用户决定
		String newPage = request.getParameter("pageNow");
		if(newPage != null && newPage != ""){
			pageNow = Integer.parseInt(newPage);
		}
		int pageSize = 3; //一页显示几条数据，自定义
		int pageCount = 0; //初始化总页数
		int rowCount = 0; //初始化总共多少行 ，从数据库查询
		
		pageCount = new UsersDao().getPageCount(pageSize);  // 获得总页数
		ArrayList<Users> al = new UsersDao().getUsersByPage(pageNow, pageSize); //获取从数据库查询的数据
		
		// 将数据显示到页面
		out.println("<h1>管理页面</h1><hr>");
		out.println("<a href='/servletLoad_UserManager/IndexServlet'>返回主页面</a><hr>");
		out.println("<table border='1' cellpadding='10' cellspacing='1' >");
		out.println("<tr><th>编号</th><th>姓名</th><th>邮箱</th><th>等级</th><th colspan='2'>操作</th></tr>");
		for(Users u : al){
			out.println("<tr><td>"+u.getId()+"</td>"
						+"<td>"+u.getUsername()+"</td>"
						+"<td>"+u.getEmail()+"</td>"
						+"<td>"+u.getGrade()+"</td>"
						+"<td><a href='/servletLoad_UserManager/UserServlet?op=updatePage&pageNow="+pageNow+"&id="+u.getId()+"'>修改</a></td>"
						+"<td><a href='/servletLoad_UserManager/UserServlet?op=delete&id="+u.getId()+"&pageNow="+pageNow+"'>删除</a></td></tr>");
		}
		out.println("</table><br>");
		
		// 上一页
		int pagePrev = pageNow == 1 ? 1:pageNow-1;
		out.println("<a href='/servletLoad_UserManager/ManagerUser?pageNow="+pagePrev+"'>上一页</a>");
		
		// 页码
		for(int i = 1; i <= pageCount; i++){
			out.println("<a href='/servletLoad_UserManager/ManagerUser?pageNow="+i+"'><"+i+"></a>");
		}
		
		// 下一页
		int pageNext = pageNow == pageCount ? pageCount:pageNow+1;
		out.println("<a href='/servletLoad_UserManager/ManagerUser?pageNow="+pageNext+"'>下一页</a>");
		
		// 显示当前页
		out.println(pageNow+"/"+pageCount+"<br><br>");
		
		// 页面跳转
		out.println("跳转到<input type='text' id='text' /><button id='btn' onClick='jump()'>GO</button>");
		out.println("<script>"
				+ "function jump(){"
				+ "var value = document.getElementById('text').value;"
				+ "if(value > "+pageCount+"){value = "+pageCount+"}"
				+ "location.href='/servletLoad_UserManager/ManagerUser?pageNow='+value"
				+ "}"
				+ "</script>");
			
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
