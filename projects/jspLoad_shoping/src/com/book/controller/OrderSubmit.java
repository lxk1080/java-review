package com.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.OrderDao;
import com.book.domain.Book;
import com.book.domain.OrderDetail;
import com.book.domain.OrderForm;
import com.book.domain.User;
import com.book.service.CartService;
import com.book.service.MailService;
import com.book.service.OrderService;

public class OrderSubmit extends HttpServlet {

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
		
		CartService cs = (CartService) request.getSession().getAttribute("cs");
		User user = (User) request.getSession().getAttribute("user");
		
		try {
			// 订单对象
			OrderForm order = new OrderForm();
			order.setUser_id(user.getId());  //用户编号
			order.setOrd_allprice(cs.getAllPrice());  // 所有商品总价
			order.setOrd_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); //订单日期
			
			// 订单细节对象
			HashMap<Integer,Book> cart = cs.getCart();  //获取购物车
			HashMap<Integer,Integer> buyNum = cs.getBuyNum();  //获取装载购物数量的容器
			Set<Integer> set = cart.keySet();
			ArrayList<OrderDetail> al = new ArrayList<>();
			for(Integer bookid : set){
				OrderDetail detail = new OrderDetail();
				detail.setGoods_id(bookid);  // 商品编号
				detail.setGoods_name(cart.get(bookid).getName()); // 商品名称
				detail.setGoods_num(buyNum.get(bookid));  // 商品数量
				detail.setGoods_allprice(buyNum.get(bookid) * (cart.get(bookid)).getPrice()); // 商品总价
				al.add(detail);
			}
			// 将订单信息插入数据库（面向对象）
			new OrderDao().submitOrder(order, al);
			
			// 将订单信息插入数据库（直接插入）
			//new OrderService().submitOrder(cs, user);
			
		} catch (SQLException e) {
			e.printStackTrace();  
			request.getRequestDispatcher("/WEB-INF/jsps/err.jsp").forward(request, response);
		}
		
		// 发送邮件
		String email = ((User) request.getSession().getAttribute("user")).getEmail();
		MailService smts = new MailService();
		smts.send("WODEBOOKS", "订单已提交成功哦！", email, 
				"worldbooks@sohu.com", "xxx", "smtp.sohu.com");
		
		response.sendRedirect("/jspLoad_shoping/OrderSubmitPage");
		
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
