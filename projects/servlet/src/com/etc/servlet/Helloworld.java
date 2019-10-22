package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.etc.dao.*;
import com.etc.entity.UserList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helloworld extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	//构造函数
	public Helloworld() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	//服务器崩溃
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
	//get方式传参
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*response.setCharacterEncoding("utf-8");
		doPost(request, response);*/
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.获取用户输入的信息,注意：用get方式中文字符必须转码，就是以下形式
		String username=new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
		String password=request.getParameter("password");	
		//数据库验证
		Dao d = new Dao();
	   
		try {
			
		boolean flag = d.findById(username);
		
		if(flag==false){
			out.print("用户名不存在");
		}else{
			int psw = d.findByUsername(username);
			String ss = psw+"";
			if(password.equals(ss)){
				//成功时跳转页面
				response.sendRedirect("index.jsp"); //直接转到index.jsp将不会生成session数据
			}else{out.print("密码错误");}
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//3.数据库验证
		//4.页面的跳转
			//请求转发
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			//重定向
			//response.sendRedirect("index.jsp");
		/*}else{
			out.print("用户名和密码有误");
		}*/
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
	//post方式传参
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.获取用户输入的信息,注意：用get方式中文字符必须转码,用post则不用
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		//数据库验证
		Dao d = new Dao();
	   
		try {
			
		boolean flag = d.findById(username);
		
		if(flag==false){
			out.write("{'status':'用户名不存在','flag':'0'}");
		}else{
			int psw = d.findByUsername(username);
			String ss = psw+"";
			if(password.equals(ss)){
				//成功时跳转页面
				//response.sendRedirect("AddStudentServlet?op=findAll"); //通过findAll的方法生成session数据,再转到index.jsp页面
				out.write("{'status':'AddStudentServlet?op=findAll','flag':'1'}");
			}else{out.write("{'status':'密码错误','flag':'0'}");}
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	//初始化
	public void init() throws ServletException {  
		// Put your code here
	}
}
