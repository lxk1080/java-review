package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import util.PageSupport;
import bean.User;
import dao.UserDao;

public class UserServlet extends HttpServlet{
	UserDao userDao = new UserDao();
	User user=new User();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if(action.equals("login")){
			login(req,resp);
		}else if(action.equals("list")){
			list(req,resp);
		}else if(action.equals("delete")){
			delete(req,resp);
		}else if(action.equals("view")){
			view(req,resp);
		}
	}
	
	private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userDao.view(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("userView.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userDao.delete(id);
		resp.sendRedirect("user?action=list");
	}

	

	//获取数据库中的数据，并且跳转到index.jsp
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		User user = new User();
		user.setSname(sname);
		int pageSize = 5;//一页显示多少条
		int pageIndex = 1;//页码
		if(null!=req.getParameter("pageIndex")&&!"".equals(req.getParameter("pageIndex"))){
			pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
		}
		int totalCount = userDao.getTotalCount(user);//总条数
		//计算总页数
		PageSupport pageSupport= new PageSupport();
		pageSupport.setPageSize(pageSize);//页面总量
		pageSupport.setCurrPageNo(pageIndex);//当前页码
		pageSupport.setRecordCount(totalCount);//计算总页数
        //获取总页数
		int totalPageCount = pageSupport.getTotalPageCount();
		List<User>list = userDao.list(user,pageIndex,pageSize);
		req.setAttribute("list", list);
		
		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPageCount", totalPageCount);
		req.getRequestDispatcher("showuser.jsp").forward(req, resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userDao.login(username,password);
		if(null!=user){
			//登陆成功
			//HttpSession  会话
			HttpSession session = req.getSession();
			resp.sendRedirect("user?action=list");
			System.out.println("okkk");
			
		}else{
		
			//登陆失败	
			req.setAttribute("message", "登陆失败啦！");
			/*req.getAttribute("message");
			${message}*/
			req.getRequestDispatcher("pages-login.jsp").forward(req, resp);
		}
	}
}
