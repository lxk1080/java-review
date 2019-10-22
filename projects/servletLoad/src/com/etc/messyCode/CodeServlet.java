package com.etc.messyCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CodeServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从浏览器传输数据到服务器，默认是以ISO-8859-1的格式传输，用post提交时，提交的数据存在于请求体中，所以直接
		// 设置请求数据的字符编码为UTF-8即可，但是用get方式提交的数据存在于请求行中，不能直接设置其字符编码，需要通过获
		// 得ISO-8859-1的字节，再装换成UTF-8的编码格式

		// 超链接和sendRedirect()的本质都是get方式

		// 设置响应数据字符编码为utf-8，并且告诉浏览器以utf-8的编码格式来解析数据
		response.setContentType("text/html;charset=utf-8");
		// 设置响应数据的字符编码为utf-8
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 用post方式提交（post数据虽然在请求体中，但本质也是ISO-8859-1编码，也可以用ISO-8859-1的方式解决）
		// request.setCharacterEncoding("utf-8");
		// String username = request.getParameter("username");

		// 用get方式提交 （get数据在请求行中，只能用ISO-8859-1方式解决）
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		
		// 下载提示框中文乱码
/*		String temp = URLEncoder.encode("传奇.mp3", "utf-8");
		response.setHeader("Content-Disposition","attachment; filename="+temp);
*/
		
		// 如果浏览器是 ie6 或以下版本，则超链接和sendRedirect()情况会出现乱码(当中文是奇数的时候)，传输前先进行编码
		// 接收方还是以ISO-8859-1方式接收
/*		String info = URLEncoder.encode("你好吗.jpg", "utf-8");
		out.println("<a href=”http://www.sohu.com?name=”+ info >测试</a>");
		response.sendRedirect("servlet地址?username="+info);
*/
		System.out.println(username);
		out.println(username);

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
