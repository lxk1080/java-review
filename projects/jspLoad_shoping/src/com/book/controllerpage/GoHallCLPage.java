package com.book.controllerpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.domain.Book;
import com.book.util.Pager;

public class GoHallCLPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoHallCLPage() {
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
		
		// 购买时可能发生的错误
		String buyErr = request.getParameter("buyErr");
		if(buyErr != null){
			if(Integer.parseInt(buyErr) == 1){
				request.setAttribute("buyErr", "已经没有库存了!");
			} else if(Integer.parseInt(buyErr) == 2){
				request.setAttribute("buyErr", "购买失败！");
			}
		}
		
		// 将页面分页显示
		// 接收要显示的页数
		String pageNow = request.getParameter("pageNow");
		// 实例化页面控制器
		Pager<Book> pager = (Pager<Book>) request.getSession().getAttribute("pager");
		// 当前页（默认第一页）
		pager.setPageNow(1);  
		if(pageNow != null){
			pager.setPageNow(Integer.parseInt(pageNow));
		}
		// 页面大小
		pager.setPageSize(3); 
		// 总数据数
		pager.setRowCount(new BookDao().getRowCount(pager.getPageSize())); 
		// 要显示到页面上的数据
		ArrayList<Book> al = new BookDao().getUsersByPage(pager.getPageNow(), pager.getPageSize());
		pager.setContent(al);  
		// 准备数据
		request.setAttribute("pager", pager);
		
		request.getRequestDispatcher("/WEB-INF/jsps/hall.jsp").forward(request, response);
		
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
