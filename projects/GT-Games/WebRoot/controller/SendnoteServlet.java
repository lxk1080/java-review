package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.SendnoteDao;
import bean.SendNote;
import bean.User;

public class SendnoteServlet extends HttpServlet {
SendnoteDao sendnotedao=new SendnoteDao();
	/**
	 * Constructor of the object.
	 */
	public SendnoteServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if("sendnote".equals(action)){
			sendnote(request,response);
		}
	}

	private void sendnote(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		boolean bRet = false;//增加是否成功
		String ttopic=request.getParameter("ttopic");
		String tcontents=request.getParameter("tcontents");
		SendNote sendnote=new SendNote();
			sendnote.setTtopic(ttopic);
			sendnote.setTcontents(tcontents);
			User user = (User)request.getSession().getAttribute("user");
			sendnote.setTuid(user.getId());
			sendnote.setTtime(new Date());
		//调用后台的方法，将信息插入数据库中
		bRet = sendnotedao.add(sendnote);
		if(bRet)
			//response.sendRedirect("");
			//System.out.println("ok");
			response.sendRedirect("ShowallnoteForuser?action=allMessage");
		else
			//request.getRequestDispatcher("userAdd.jsp").forward(request, response);
			System.out.println("error");
		
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
