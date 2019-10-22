package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RequestServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8"); // 解决post提交方式乱码
		PrintWriter out = response.getWriter();

		// 防止盗链
		// Referer代表请求从哪来，直接用servlet跳转时，referer为null
		String referer = request.getHeader("Referer");
		if (referer == null || !referer.startsWith("http://127.0.0.1:8080/")) {
			out.println("referer:" + referer);
			out.println("非法链接！！！");
			return; // 终止方法
		}
		out.println("合法链接！");

		// 打出所有请求头信息
		Enumeration<String> s = request.getHeaderNames();
		while (s.hasMoreElements()) {
			String name = s.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + ":" + value);
		}

		// 接收复选框的内容，一个参数可能有多个值
		String[] wars = request.getParameterValues("war");
		if (wars != null) {
			for (String name : wars) {
				System.out.println(name);
			}
		}
		String hidden = request.getParameter("hidden");
		System.out.println("隐藏控件数据：" + hidden);

		// 请求转发
		// request.setAttribute("user", "your_username"); //request域对象
		// request.getAttribute("user");
		// 请求分派器
		// request.getRequestDispatcher("ResponseServlet").forward(request,response);
		// 1.Request中的Attribute在一次请求有效，没有返回到浏览器，就为一次请求，共用request和response
		// 2.转发的servlet不需要写web应用名
		// 3.网址不变
		// 4.不能转发到外部URL
		// 5.转发速度快
		// 根本原因：请求转发在服务器内运行，并没有响应到浏览器
		

		String url = request.getRequestURL().toString(); // 客户端发出请求时的完整URL
		System.out.println(url);

		String uri = request.getRequestURI(); // 请求行中的web应用名、资源名部分
		System.out.println(uri);

		String query = request.getQueryString(); // 请求行中的参数部分(参数名+值)，以get方式提交的
		System.out.println(query);

		String addr = request.getRemoteAddr(); // 请求的客户端的IP地址
		System.out.println(addr);

		// 如果客户机没有在dns注册，则返回ip地址，如果注册，返回机器名
		String host = request.getRemoteHost(); // 请求的客户机的完整主机名
		System.out.println(host);

		// 客户机的端口号是随机选择的，由于是长连接，这个端口号在一定时间内不变（大约30s）
		int port = request.getRemotePort(); // 客户机所使用的网络端口号
		System.out.println(port);

		// web服务器的端口号是一定的
		int port2 = request.getLocalPort(); // 服务器所使用的网络端口号
		System.out.println(port2);

		String addr2 = request.getLocalAddr(); // 服务器的IP地址
		System.out.println(addr2);

		String host2 = request.getLocalName(); // 服务器的主机名
		System.out.println(host2);

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
