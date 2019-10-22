package com.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.domain.Book;
import com.book.service.CartService;

public class GoCartCL extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoCartCL() {
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
		
		String op = request.getParameter("op");
		
		if("add".equals(op)){
			String id = request.getParameter("id");
			
			// 通过id获取书
			BookDao bd = new BookDao();
			Book book = bd.getBookById(id); 
			
			// 拿到购物车，加入一本书
			CartService cs = (CartService) request.getSession().getAttribute("cs");
			String mes = cs.addBook(book);
			if("已经没有库存了!".equals(mes)){
				response.sendRedirect("/jspLoad_shoping/GoHallCLPage?buyErr=1");
				return ;
			} else if("购买失败！".equals(mes)){
				response.sendRedirect("/jspLoad_shoping/GoHallCLPage?buyErr=2");
				return ;
			}
		} else if ("del".equals(op)){
			
			String id = request.getParameter("id");
			
			// 通过id获取书
			BookDao bd = new BookDao();
			Book book = bd.getBookById(id); 
			
			// 拿到购物车，删除一本书
			CartService cs = (CartService) request.getSession().getAttribute("cs");
			cs.delBook(book);
			
		} else if("clear".equals(op)){
			
			// 购物车服务对象（清空购物车）
			CartService cs = (CartService) request.getSession().getAttribute("cs");
			cs.clearBook();
			
		} else if("update".equals(op)){
			
			String[] id = request.getParameterValues("id");
			String[] nums = request.getParameterValues("nums"); 
			
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int i = 0; i < id.length; i++){
				hm.put(Integer.parseInt(id[i]), Integer.parseInt(nums[i]));  
			}
			
			// 购物车服务对象（更新购物车）
			CartService cs = (CartService) request.getSession().getAttribute("cs");
			cs.updateBook(hm);
		}
			
		response.sendRedirect("/jspLoad_shoping/GoCartCLPage");
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
