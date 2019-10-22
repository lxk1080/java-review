package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoteDao;
import util.PageSupport;
import bean.Note;
import bean.User;


public class NoteServlet extends HttpServlet {
NoteDao notedao=new NoteDao();
	/**
	 * Constructor of the object.
	 */
	public NoteServlet() {
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
		if("shownote".equals(action)){
			shownote(request, response);
		}
		else if("showview".equals(action)){
			showview(request,response);
		}
		else if("delete".equals(action)){
			delete(request,response);
		}
	}

	private void showview(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		Note note = notedao.view(sid);
		request.setAttribute("note", note);
		request.getRequestDispatcher("noteView.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		notedao.delete(sid);
		resp.sendRedirect("NoteServlet?action=shownote");
	}

	private void shownote(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname = req.getParameter("sname");
		Note note=new Note();
		note.setSname(sname);
		int pageSize = 5;//一页显示多少条
		int pageIndex = 1;//页码
		if(null!=req.getParameter("pageIndex")&&!"".equals(req.getParameter("pageIndex"))){
			pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
		}
		int totalCount =  notedao.getTotalCount(note);//总条数
		//计算总页数
		PageSupport pageSupport= new PageSupport();
		pageSupport.setPageSize(pageSize);//页面总量
		pageSupport.setCurrPageNo(pageIndex);//当前页码
		pageSupport.setRecordCount(totalCount);//计算总页数
        //获取总页数
		int totalPageCount = pageSupport.getTotalPageCount();
		List<Note>list = notedao.list(note,pageIndex,pageSize);
		req.setAttribute("list", list);
		
		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPageCount", totalPageCount);
		req.getRequestDispatcher("showNote.jsp").forward(req, resp);
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
