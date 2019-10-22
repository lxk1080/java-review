package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		// 设置字符编码为utf-8，并且告诉浏览器以utf-8的字符编码来解析数据
		response.setContentType("text/html;charset=utf-8");
		// 设置响应数据的字符编码为utf-8
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		// 判断是否有cookie保存用户名
		String username = "";
		Cookie[] cookie = request.getCookies();
		if(cookie != null){
			for(Cookie c : cookie){
				if("keepUsername".equals(c.getName())){
					username = URLDecoder.decode(c.getValue(),"utf-8");
					break;
				}
			}
		}
		
		out.println("<h1>用户登录</h1><hr/>");
		// 这里action的写法，/web应用名/servlet路径名
		out.println("<form action='/servletLoad_UserManager/LoginCLServlet' method='post'>");
		out.println("用户名：<input type='text' name='username' value='"+username+"'><br>");
		out.println("密　码：<input type='password' name='password'><br>");
		out.println("验证码：<input type='text' name='checkCode' />"
					+"<img style='vertical-align:middle;margin-left:5px' src='/servletLoad_UserManager/RanCodeServlet'><br>");
		// checkbox只在被选中的时候才会传递值
		out.println("<input type='checkbox' name='checkbox' value='keep' checked />是否保存用户名<br>");
		out.println("<input type='submit' value='登录'>");
		out.println("</form>");
		
		
		
		// 验证失败返回错误信息
		String err = (String) request.getAttribute("err");
		if(err != null){
			out.println("<span style='color:red'>"+err+"</span>");
		}
		
		out.flush();
		out.close();
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
