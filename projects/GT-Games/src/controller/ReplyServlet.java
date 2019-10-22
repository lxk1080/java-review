package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import bean.Reply;
import bean.User;

import dao.ReplyDao;

public class ReplyServlet extends HttpServlet {
	
	ReplyDao replyDao = new ReplyDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action.equals("getReplysByTid")){
			getReplysByTid(req,resp);
		}else if(action.equals("reply")){
			reply(req,resp);
		}

	}
	private void reply(HttpServletRequest req, HttpServletResponse resp) {
		String mess = "";
		if(req.getSession().getAttribute("user")==null){
			mess = "回复失败，请先登陆！";
		}else{
			String contentText = req.getParameter("contentText");
			int rtid = Integer.parseInt(req.getParameter("tid"));
			Reply reply = new Reply();
			reply.setRtid(rtid);
			reply.setRcontents(contentText);
			reply.setRtime(new Date());
			reply.setUser((User)req.getSession().getAttribute("user"));
			
			boolean flag = replyDao.add(reply);
			if(flag){
				mess = "success";
			}
		}
		try {
			//服务端往客户端写回数据的格式
			resp.setContentType("text/html;charset=utf-8");
			//通过response获取PrintWriter对象
			PrintWriter printWriter = resp.getWriter();
			//调用write(要写回的数据)
			printWriter.write(mess);
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void getReplysByTid(HttpServletRequest req, HttpServletResponse resp) {
		int tid = Integer.parseInt(req.getParameter("tid"));
		List<Reply>list = replyDao.getReplysByTid(tid);
		String s = JSONArray.toJSONString(list);
		try {
			//服务端往客户端写回数据的格式
			resp.setContentType("application/json;charset=utf-8");
			//通过response获取PrintWriter对象
			PrintWriter printWriter = resp.getWriter();
			//调用write(要写回的数据)
			printWriter.write(s);
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
