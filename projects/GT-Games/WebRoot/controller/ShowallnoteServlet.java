package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AllnoteDao;
import util.PageSupport;
import bean.AllNote;
import bean.Note;
import bean.User;

public class ShowallnoteServlet extends HttpServlet {
AllnoteDao allnotedao=new AllnoteDao();
	/**
	 * Constructor of the object.
	 */
	public ShowallnoteServlet() {
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

	doPost(request, response);
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action =request.getParameter("action");
		if("allnote".equals(action)){
			allnote(request,response);
		}
		else if("showtopicview".equals(action)){
			showtopicview(request,response);
		}
		else if("delete".equals(action)){
			delete(request,response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int tid=Integer.parseInt(request.getParameter("tid"));
		allnotedao.delete(tid);
		response.sendRedirect("ShowallnoteServlet?action=allnote");
	}
	private void showtopicview(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int tid = Integer.parseInt(request.getParameter("tid"));
		AllNote allnote = allnotedao.view(tid);
		request.setAttribute("allnote", allnote);
		request.getRequestDispatcher("showtopicview.jsp").forward(request, response);
	}

	private void allnote(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		
			String ttopic= req.getParameter("ttopic");
			AllNote allnote=new AllNote();
			allnote.setTtopic(ttopic);
			int pageSize = 5;//一页显示多少条
			int pageIndex = 1;//页码
			if(null!=req.getParameter("pageIndex")&&!"".equals(req.getParameter("pageIndex"))){
				pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
			}
			int totalCount =  allnotedao.getTotalCount(allnote);//总条数
			//计算总页数
			PageSupport pageSupport= new PageSupport();
			pageSupport.setPageSize(pageSize);//页面总量
			pageSupport.setCurrPageNo(pageIndex);//当前页码
			pageSupport.setRecordCount(totalCount);//计算总页数
	        //获取总页数
			int totalPageCount = pageSupport.getTotalPageCount();
			List<AllNote>list = allnotedao.list(allnote,pageIndex,pageSize);
			req.setAttribute("list", list);
			
			req.setAttribute("pageIndex", pageIndex);
			req.setAttribute("totalCount", totalCount);
			req.setAttribute("totalPageCount", totalPageCount);
			req.getRequestDispatcher("allnote.jsp").forward(req, res);
		
		
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
