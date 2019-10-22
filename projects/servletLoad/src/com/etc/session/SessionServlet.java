package com.etc.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SessionServlet() {
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
		
		// session 小结:
		// 1.session是存在服务器的内存中
		// 2.一个用户浏览器，独享一个session域对象，（JSESSIONID）
		// 3.session中的属性的默认生命周期是30min ，你可以通过 web.xml来修改
		// 4.重启tomcat、reload、关机 session失效

		// 3 种session生命周期的设置
	 	/*（1） 一个地方是 tomcat/conf/web.xml
		<session-config>
		        <session-timeout>30</session-timeout>//表示30分钟的意思
		</session-config>
		对所有的web应用生效
		（2）另外一个地方，就是在单个web应用的下去修改 web.xml
		<session-config>
		  		<session-timeout>30</session-timeout>session精确到分钟,cookie精确到秒
		</session-config>
		如果发生冲突，则以自己的web应用优先级高
		（3）session.setMaxInactiveinterval(60)发呆六十秒后session失效*/
		
		HttpSession session = request.getSession(); // 有就拿，没有就创建，如果给个参数false，那没有就算了
		
		session.setAttribute("user", "your_username");
		
		// 发呆时间，发呆60秒后，session失效，如果在第59秒时访问了session，又会重新计时
		// session是指 超时时间
		session.setMaxInactiveInterval(60); // 单位: 秒   设置为0或负数，则永不超时
		
		session.getAttribute("user");
		
		session.removeAttribute("user"); 
		
		session.invalidate();  // 让session中所有的属性失效，该方法通常用于安全退出
		
		// 如果用户禁用了cookie，则人为的传递一个JSESSIONID，重写URL
		String url = response.encodeURL("/servletLoad/SessionServlet");
		
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
