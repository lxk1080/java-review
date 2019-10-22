package com.vote.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.vote.dao.VoteListDao;
import com.vote.dao.VoteStsDao;
import com.vote.domain.VoteList;
import com.vote.domain.VoteSts;

public class CenterCL extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CenterCL() {
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

		this.doPost(request, response);
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
		
		String op = request.getParameter("op");
		
		// 创建一个投票事项
		if("create".equals(op)){
			// 获取提交的数据
			String data = request.getParameter("data");
			System.out.println(data);
			// 解析为json
			JSONObject subData = JSONObject.fromObject(data.toString());
			// 创建对象
			VoteList vl = new VoteList();
			vl.setType(subData.getString("type"));
			vl.setTitle(subData.getString("title"));
			vl.setDesc(subData.getString("desc"));
			vl.setImg(subData.getString("img"));
			vl.setChoose(subData.getString("choose"));
			vl.setPattern(subData.getString("pattern"));
			vl.setPeopleNum(subData.getString("peopleNum"));
			vl.setPubDate(subData.getString("pubDate"));
			vl.setExpireDate(subData.getString("expireDate"));
			// 插入数据库
			VoteListDao vld = new VoteListDao();
			boolean flag = vld.createVote(vl);
			System.out.println("是否创建成功？ "+flag);	
			// 返回
			out.println(flag);
			
			
		// 获取所有的投票事项
		} else if("getAllVote".equals(op)){
			VoteListDao vld = new VoteListDao();
			String data = vld.getVoteList();
			System.out.println(data);
			out.println(data);
			
			
		// 通过id获取投票事项
		}  else if("getVoteById".equals(op)){
			String id = request.getParameter("vote_id");
			VoteListDao vld = new VoteListDao();
			String data = vld.getVoteById(id);
			System.out.println(data);
			out.println(data);
			
			
		// 投票
		} else if("vote".equals(op)){
			String data = request.getParameter("data");
			System.out.println(data);
			JSONObject subData = JSONObject.fromObject(data.toString());
			// 检查用户是否投过票
			VoteStsDao vsd = new VoteStsDao();
			ArrayList<String> al = vsd.getRecordByPeople("小小");
			if(al.contains(subData.getString("vote_id"))){
				out.println("{\"sts\":\"0\",\"info\":\"已经投过了，请勿重复投票OK？~(￣0￣)\"}");
			} else {
				VoteSts vs = new VoteSts();
				vs.setVote_id(subData.getString("vote_id"));
				vs.setVote_title(subData.getString("vote_title"));
				vs.setVote_man("小小");
				vs.setVote_choose(subData.getString("choose"));
				vs.setVote_date(subData.getString("vote_date"));
				// 添加到数据库
				if(vsd.addVote(vs)){
					out.println("{\"sts\":\"1\",\"info\":\"投票成功，感谢您的参与！Y(^_^)Y\"}");
				} else {
					out.println("{\"sts\":\"0\",\"info\":\"投票失败了⊙︿⊙！\"}"); 
				}
			}
			
			
			
		}
		
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
