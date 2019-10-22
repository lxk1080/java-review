package com.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.UsersDao;
import com.etc.entity.Users;

public class LoginCLServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginCLServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		
		String nums = (String) this.getServletContext().getAttribute("nums");
		FileWriter fw = null;
		if(nums != null){
			InputStream is = LoginCLServlet.class.getClassLoader().getResourceAsStream("count.properties");
			Properties pp = new Properties();
			try {
				pp.load(is);
				String count = pp.getProperty("count");
				pp.setProperty("count", nums);
				
				// 获取在WebRoot下文件的全路径
				String path = this.getServletContext().getRealPath("/WEB-INF/classes/count.properties");
				
				fw  = new FileWriter(path);
				pp.store(fw, "the web counter");
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if( fw != null && is != null){
					try {
						fw.close();
						is.close();
						pp.clone();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
			
		}
		super.destroy(); 
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkbox = request.getParameter("checkbox");
		String checkCode = request.getParameter("checkCode");
		String ranCheckCode = (String) request.getSession().getAttribute("checkcode");
		if(checkCode != null && ranCheckCode != null){
			if(!checkCode.equals(ranCheckCode)){
				request.setAttribute("err", "验证码错误！");
				request.getRequestDispatcher("LoginServlet").forward(request, response);
				return; // 直接结束方法
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		// 这里之所以把字符串写到前面，是为了防止变量的值为空，空指针是没有equals()方法的
		/*if("your_username".equals(username) && "123456".equals(password)){
			out.println("登录成功！");
		} else {
			out.println("登录失败！");
		}*/
		
		Users u = new Users();
		u.setUsername(username);
		u.setPassword(password);
		UsersDao ud = new UsersDao();
		boolean flag = ud.checkUser(u);
		
		// 登录成功
		if(flag){ 
			if(checkbox != null && "keep".equals(checkbox)){  //复选框被选中，创建一个新的cookie来保存用户信息（因为时间要重新算的）
				String value = URLEncoder.encode(username,"utf-8");
				Cookie cookie = new Cookie("keepUsername",value);
				cookie.setMaxAge(3600);
				response.addCookie(cookie);
			} else { // 复选框没被选中（如果有就删除，没有就算了）
				Cookie[] cookie = request.getCookies();
				if(cookie != null){
					for(Cookie c : cookie){
						if("keepUsername".equals(c.getName())){
							c.setMaxAge(0); // 设置为0,删除cookie
							response.addCookie(c);
							break;
						}
					}
				}
			}
			
			// 将用户对象存入session
			session.setAttribute("loginUser", u); 
			
			// 网站计数器			
			String nums = (String) this.getServletContext().getAttribute("nums");
			this.getServletContext().setAttribute("nums", (Integer.parseInt(nums)+1)+"");
			
			request.getRequestDispatcher("IndexServlet").forward(request, response);
		} else {
			request.setAttribute("err", "用户名或密码错误！");
			request.getRequestDispatcher("LoginServlet").forward(request, response);
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
		Properties pp = new Properties();
		InputStream is = LoginCLServlet.class.getClassLoader().getResourceAsStream("count.properties");
		try {
			pp.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String count = pp.getProperty("count");
		this.getServletContext().setAttribute("nums",count);
		pp.clone();
		
	}

}
