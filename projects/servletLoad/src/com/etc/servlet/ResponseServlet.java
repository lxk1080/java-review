package com.etc.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ResponseServlet() {
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
		
		// response.setStatus(302);
		// response.setHeader("location", "RequestServlet");
		// 上面两句话等价
		// 注意：直接访问这个servlet重定向到RequestServlet也是盗链，因为重定向是响应到请求页面然后再次发出请求，而
		// 直接访问，就没有请求页面，所以referer为空
		// response.sendRedirect("RequestServlet");
		
		
		// 5s后刷新页面到url
		// response.setHeader("Refresh", "5,url=RequestServlet");
		
		// 设置页面不缓存
		//response.setDateHeader("Expires", -1); // IE
		//response.setDateHeader("Expires", System.currentTimeMillis()+10*1000); //设置缓存截止日期
		//response.setHeader("Cache-Control", "no-cache"); //火狐
		//response.setHeader("Pragma", "no-cache"); //其他
		
		// 不能同时存在两个流，只要其中一个流输出了信息，服务器就会自动检查与response关联的流是否关闭，如果没有关闭，他就会帮你关闭
		// 也就是说，第一个流输出信息后，第二个流在输出信息前就会被关闭，在这里会直接报错
		// Exception:getWriter() has already been called for this response
		// OutputStream os = response.getOutputStream();
		
		out.println("这是 响应页面！");
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
