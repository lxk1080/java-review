package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.Dao;
import com.etc.entity.UserList;
import com.etc.entity.UserList;

public class AddStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStudentServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 1.设置请求和响应的编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 2.获取用户输入的信息（获取请求参数）
		String op = request.getParameter("op");
		if ("add".equals(op)) {// op是一个标识，标识你是什么操作 add说明是添加
			try {
				
				add(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("findAll".equals(op)) {
			try {
				
				findAll(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("delete".equals(op)){
			   try {
				   
				delete(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("deletePage".equals(op)){
				try {
					deletePage(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if("update".equals(op)){
			
			try {
				
				update(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("findOldData".equals(op)){
			
			try {
				
				findOldData(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	
	//更新时获取原数据
	private void findOldData(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//获取请求参数
		String id = request.getParameter("id");
		//调用dao
		Dao dao = new Dao();
		UserList ul = dao.findOldData(Integer.parseInt(id));
		//把查找出来的信息放到作用域,让页面可以取到
		request.getSession().setAttribute("ul", ul);//放的是session作用域
		//根据结果跳转页面
		if (ul!=null) {
			try {
				
				request.getRequestDispatcher("updatePage.jsp").forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	//更新
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 调用dao(要调用dao的方法，首先要创建dao的对象)
		Dao dao = new Dao();
		UserList ul = new UserList(Integer.parseInt(id),username, Integer.parseInt(password));
		boolean flag = dao.update(ul);
		if (flag) {
			request.getRequestDispatcher("AddStudentServlet?op=findAll").forward(request, response);
		} else {
			System.out.println("修改失败");
		}
	}
	//删除,表格通过id直接删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		// 3.调用dao(要调用dao的方法，首先要创建dao的对象)
		Dao dao = new Dao();
		if(dao.delete(Integer.parseInt(id))){
			request.getRequestDispatcher("AddStudentServlet?op=findAll").forward(request, response);
		}else{
			System.out.println("删除失败");
			}
	}
	//删除,单独的删除页面
	private void deletePage(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
			// TODO Auto-generated method stub
			String username = request.getParameter("username");
			
			// 3.调用dao(要调用dao的方法，首先要创建dao的对象)
			Dao dao = new Dao();
			if(dao.deletePage(username)){
				request.getRequestDispatcher("AddStudentServlet?op=findAll").forward(request, response);
			}else{
				System.out.println("删除失败");
				}
		}

	/**
	 * 查询所有学生
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	//查询所有数据
	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		Dao dao = new Dao();
		
		List<UserList> list = dao.findAll();//这个list是我们查询出来的所有学生信息，接下来页面要显示这些信息
		//页面要显示这些信息：1.要先把这些数据放到某个地方(session) 2.页面从这个地方(session)读取数据
		request.getSession().setAttribute("list", list);
		response.sendRedirect("index.jsp");
	}

	/**
	 * 添加学生的方法
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	//添加
	private void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 3.调用dao(要调用dao的方法，首先要创建dao的对象)
		Dao dao = new Dao();
		UserList ul = new UserList(0,username,Integer.parseInt(password));
		boolean flag = dao.add(ul);
		if (flag) {
			request.getRequestDispatcher("AddStudentServlet?op=findAll").forward(request, response);
		} else {
			System.out.println("添加失败");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
