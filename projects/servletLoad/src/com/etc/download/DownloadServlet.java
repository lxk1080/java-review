package com.etc.download;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadServlet() {
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
		// 响应只能有一个
		// PrintWriter out = response.getWriter();
		
		// 判断是否是盗链
		String referer = request.getHeader("Referer");
		if(referer == null || !referer.startsWith("http://127.0.0.1:8080")){
			PrintWriter out = response.getWriter();
			out.println("非法链接！");
			return;
		} 
		
		String fileName = request.getParameter("fileName");
		String num = request.getParameter("num");
		
		// 当下载文件的时候，可能提示框是中文乱码 
		// String newFileName = java.net.URLEncoder.encode(fileName,"utf-8");
		
		// 告诉浏览器，有文件下载
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		
		String src = "/images/x.jpg";
		src = src.replace("x", num);
		// 可以获得相对路径下文件的绝对路径
		String path = this.getServletContext().getRealPath(src);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		OutputStream os = response.getOutputStream();
		
		byte[] bys = new byte[1024];
		int len = 0;
		while((len=bis.read(bys))!=-1){
			os.write(bys,0,len);
		}
		
		os.close();
		bis.close();
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
