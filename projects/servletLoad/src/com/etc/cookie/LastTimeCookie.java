package com.etc.cookie;

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

public class LastTimeCookie extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LastTimeCookie() {
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
		
		String lastTime = null;
		Cookie[] cookie = request.getCookies();
		boolean bl = false; //表示没有拿到记录上次登录时间的cookie
		if(cookie != null){
			for(Cookie c : cookie){
				if("lastTime".equals(c.getName())){
					String value = c.getValue();
					lastTime = "上次登录的时间是："+ URLDecoder.decode(value,"utf-8"); //将保存有中文字符的cookie解码
					getTimeCookie(response,c);
					bl = true; //设置cookie已存在
					break;
				}
			}
		}
		
		if(!bl){  // 如果没有cookie
			System.out.println("123");
			lastTime = "第一次登录!";
			getTimeCookie(response,null);
		}
		
		out.println(lastTime);
	}
	
	// 设置记录时间的cookie
	private void getTimeCookie(HttpServletResponse response, Cookie cookie) throws UnsupportedEncodingException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String time = sdf.format(date);
		time = URLEncoder.encode(time,"utf-8");  //cookie保存中文必须先编码
		if(cookie == null){
			Cookie lastTimeCookie = new Cookie("lastTime",time);
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
