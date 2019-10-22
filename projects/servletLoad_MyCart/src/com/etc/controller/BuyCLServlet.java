package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Book;

public class BuyCLServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BuyCLServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		// 判断是否存在购物车，不存在则创建
		if(session.getAttribute("cart") == null){
			// 创建一个购物车集合
			HashMap<Integer, Book> cart = new HashMap<Integer, Book>();
			
			// 通过书的id在书库中获取书对象
			HashMap<Integer, Book> bookStack = (HashMap<Integer, Book>) session.getAttribute("bookStack");

			Book book = bookStack.get(id);

			// 将书放入到购物车
			cart.put(id, book);
			
			// 将购物车放入session传递
			session.setAttribute("cart", cart);
			
		} else {
			// 存在则获得这个购物车
			HashMap<Integer, Book> cart = (HashMap<Integer, Book>) session.getAttribute("cart");
			
			// 购物车则判断购物车中是否存在这本书
			if(cart.containsKey(id)){
				// 存在这本书的话就使这本书的数量加1
				int number = cart.get(id).getNumber();
				cart.get(id).setNumber(++number);
				
			} else {
				// 如果不存在这本书
				// 通过书的id在从书库中获取书对象
				HashMap<Integer, Book> bookStack = (HashMap<Integer, Book>) session.getAttribute("bookStack");
				Book book = bookStack.get(id);
				
				// 将书放入到购物车
				cart.put(id, book);
				
				// 购物车已经在session中，不需要再次存放
				//session.setAttribute("cart", cart);
			}
		}
		
		// 防止cookie被禁用
		//String url = response.encodeURL("/servletLoad_MyCart/ShowBookServlet");
		//response.sendRedirect(url);
		
		// 到展示页面
		response.sendRedirect("/servletLoad_MyCart/ShowBookServlet");

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
