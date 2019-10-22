package com.etc.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.BS;
import com.etc.entity.Book;

public class IndexServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
		
		// 获取图书库
		HashMap<Integer,Book> bookStack = BS.getBookStack();
		
		// 将书库存入session
		HttpSession session = request.getSession();
		session.setAttribute("bookStack", bookStack);
		
		// 为了使用户关闭浏览器后再打开还能访问到之前的购物车，设置 JSESSIONID 为另一个cookie
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
		
		// 将图书库中所有的书展示出来
		Set<Integer> set = bookStack.keySet();
		out.println("<h2>木木书库</h2><hr>");
		for(Integer key : set){
			// 如果用户禁用了cookie，为了保证session的使用，给需要接收session的url重写，这样的话请求的url就会自带一个JSESSIONID
			//String url = response.encodeURL("/servletLoad_MyCart/BuyCLServlet?id="+bookStack.get(key).getId());
			//out.println(bookStack.get(key).getName()+"书<a href='"+url+"'>　购买</a><hr>");
			
			out.println(bookStack.get(key).getName()+"书<a href='/servletLoad_MyCart/BuyCLServlet?id="+bookStack.get(key).getId()+"'>　购买</a><hr>");
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
