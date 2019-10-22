package com.etc.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServContext extends HttpServlet {

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/* ServletContext 
		1.	ServletContext 存在服务器
		2.	ServletContext 是被所有客户端共享
		3.	ServletContext 是当web应用启动的时候，自动创建
		4.	ServletContext 当web应用关闭/tomcat关闭/对web应用reload 会造成servletContext销毁.*/
		
		// ServletContext的用处
		// 1.多个servlet通过ServletContext对象实现共享数据
		// 2.获取web应用的初始化参数
		// 3.实现servlet的转发
		// 4.利用servlet对象读取资源文件

		
		ServletContext sc = this.getServletContext();
		//ServletContext sc = this.getServletConfig().getServletContext();
		
		// 基本操作
		sc.setAttribute("user", "your_username");
		sc.getAttribute("user");
		sc.removeAttribute("user");
		
		// 转发
		//sc.getRequestDispatcher("/url").forward(request, response);
		
		// 获取全局的参数
		String version = this.getServletContext().getInitParameter("version");
		out.println(version+"<br>");
		
		// 读取文件 （如果在WebRoot下）
		//InputStream is =  this.getServletContext().getResourceAsStream("info.properties");
		
		// 如果文件放在src下，用类加载器读取文件
		InputStream is = ServContext.class.getClassLoader().getResourceAsStream("info.properties");
		Properties pp = new Properties();
		pp.load(is);
		String username = pp.getProperty("username");
		out.println(username+"<br>");
		
		// 读取文件的全路径 （在服务器中的位置）
		String path = this.getServletContext().getRealPath("/images/01.jpg");
		out.println(path+"<br>");
		
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
