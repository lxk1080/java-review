package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;



public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.获取参数
		String action=request.getParameter("action");
		if("success".equals(action)){
		    success(request,response);
		}
	}

	private void success(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDao userdao=new UserDao();
		 User user=userdao.check(username, password);
		 if(user!=null){
			 request.getSession().setAttribute("user", user);
			/*User u = (User)request.getSession().getAttribute("user");*/
			 request.getRequestDispatcher("mainFirst1.jsp").forward(request,response);
			
		 }
		 else{
			 response.sendRedirect("login.jsp");
		 }
		/*String checkcode=request.getParameter("checkcode");
		String code=(String) request.getSession().getAttribute("code");*/
		/*if(checkcode.toLowerCase().equals(code.toLowerCase())){
			UserDao userdao=new UserDao();
			 boolean flag=userdao.check(username, password);
			 if(flag){
				 request.getRequestDispatcher("index.jsp").forward(request,response);
			 }
			 else{
				 System.out.println("登录失败");
			 }
		}
		else{
			System.out.println("验证码error");
		}*/
		
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
