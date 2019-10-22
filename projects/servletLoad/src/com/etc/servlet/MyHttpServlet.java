package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MyHttpServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	// servlet实例被创建后驻留在内存中，直至服务器关闭、重新部署（reload）、或者重启，servlet实例才会被销毁
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
		
		this.doPost(request,response);
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
	// 成员变量ticket（共享数据）
	private int ticket = 2;
	// 每次访问servlet时，都会新建一个request和response对象，然后将这两个对象作为参数传递给service方法，service再根据请求方式去选择doXXX()方法
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应数据字符编码为utf-8，并且告诉浏览器以utf-8的编码格式来解析数据
		response.setContentType("text/html;charset=utf-8");
		// 设置响应数据的字符编码为utf-8
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//同步代码块解决ticket被共享的问题
		synchronized (this) {
			if(ticket > 0){
				System.out.println("买到票了");
				try {
					Thread.sleep(6*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ticket--;
			} else {
				System.out.println("没有买到票呢！");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	
	// servlet只在第一次被访问时才调用init()方法，创建servlet实例，并将servlet实例加载到内存中，以后每次访问都是这一个实例，所以会存在数据共享的线程安全问题
	public void init() throws ServletException {
		//System.out.println("自动初始化完成！");
	}

}
