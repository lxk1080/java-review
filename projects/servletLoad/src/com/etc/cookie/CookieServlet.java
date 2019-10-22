package com.etc.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CookieServlet() {
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
		
		// ***cookie概述***
		// 1.cookie在服务端创建，在浏览器端保存
		// 2.如果不设置setMaxAge，则该cookie的生命周期当浏览器关闭时，就消亡（会话cookie）
		// 3.cookie可以被多个浏览器共享（事实证明并不是）
		// 4.如果重名就会替换存在的cookie值
		// 5.一个web应用可以保存多个cookie(具体由浏览器决定),但都保存在同一个cookie文本在客户端浏览器下
		
		// 创建cookie
		Cookie cookie = new Cookie("user","your_username");
		// 设置生命周期
		cookie.setMaxAge(10*60);  //单位：秒     
		// 返回给浏览器
		response.addCookie(cookie);
		
		// ***cookie的细节***
		// 一个浏览器最多放入 300cookie,一个web站点，最多 20cookie,而且一个cookie大小限制子4k
		// cookie生命周期的再说明:
		// 1.cookie默认生命周期是会话级别
		// 2.通过setMaxAge() 可以设置生命周期
		// setMaxAge(正数) , 即多少秒后该cookie失效
		// setMaxAge(0) ,删除该cookie
		// setMaxAge(负数), 相当于该cookie生命周期是会话级别.
		
		// ***cookie存放中文，怎么处理***
		// 存放:
		// String val = URLEncoder.encode("顺平","utf-8"); //编码为base64码
		// Cookie cookie=new Cookie("name",val);
		// 取出:
		// String val = URLDecoder.decode(cookie.getValue(), "utf-8");

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
