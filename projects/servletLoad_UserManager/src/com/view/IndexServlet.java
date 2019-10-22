package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		// 获取用户名
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		// 获得上次登录的时间
		String time = null;
		Cookie[] cookie = request.getCookies();
		boolean bl = false; //表示没有拿到记录上次登录时间的cookie
		if(cookie != null){
			for(Cookie c : cookie){
				if(("lastTime"+username).equals(URLDecoder.decode(c.getName(),"utf-8"))){
					String value = c.getValue();
					time = "上次登录的时间是："+ URLDecoder.decode(value,"utf-8"); //将保存有中文字符的cookie解码
					getTimeCookie(response,username,c);
					bl = true; //设置cookie已存在
					break;
				}
			}
		}
		if(!bl){  // 如果没有cookie
			time = "第一次登录!";
			getTimeCookie(response,username,null);
		}
		
		out.println("<h2>欢迎"+username+"登录</h2><hr>");
		out.println("<span>本网站共被访问"+this.getServletContext().getAttribute("nums")+"次</span><hr>");
		out.println("<span>"+time+"</span><a href='/servletLoad_UserManager/LoginServlet'>　返回登录页面</a><hr>");
		out.println("<a href='/servletLoad_UserManager/ManagerUser'>管理用户</a><br>");
		out.println("<a href='/servletLoad_UserManager/AddUser'>添加用户</a><br>");
		out.println("<a href='#'>查找用户</a><br>");
		out.println("<a href='#'>退出登录</a><br>");
		out.println("<hr>");
		
	}
	
	// 设置记录时间的cookie
	private void getTimeCookie(HttpServletResponse response, String username, Cookie cookie) throws UnsupportedEncodingException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String time = sdf.format(date);
		time = URLEncoder.encode(time,"utf-8");  //cookie保存中文必须先编码
		if(cookie == null){
			Cookie lastTimeCookie = new Cookie(URLEncoder.encode(("lastTime"+username),"utf-8"),time);
			lastTimeCookie.setMaxAge(7*3600);
			response.addCookie(lastTimeCookie);
		} else {
			cookie.setValue(time);
			cookie.setMaxAge(7*3600);
			response.addCookie(cookie);
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
