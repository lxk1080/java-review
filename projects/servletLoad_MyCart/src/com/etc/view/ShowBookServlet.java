package com.etc.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Book;

public class ShowBookServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowBookServlet() {
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
		
		// 防止cookie被禁用
		//String url = response.encodeURL("/servletLoad_MyCart/IndexServlet");
		//out.println("<h2>购物车</h2><a href='"+url+"'> 返回书库</a><br><br>");
		
		out.println("<h2>购物车</h2><a href='/servletLoad_MyCart/IndexServlet'> 返回书库</a><br><br>");
		
		// 从session中获得购物车
		HttpSession session = request.getSession();
		HashMap<Integer, Book> cart = (HashMap<Integer, Book>) session.getAttribute("cart");
		
		int price = 0; // 总价
		
		// 遍历这个购物车，拿出商品
		Set<Integer> set = cart.keySet();
		for(Integer key : set){
			out.println("<span>"+cart.get(key).getName()+" -- "+cart.get(key).getNumber()+"本</span><hr>");
			price += (cart.get(key).getNumber())*(cart.get(key).getPrice());
		}
		
		out.println("<span>总价是：</span>"+price+"元");
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
