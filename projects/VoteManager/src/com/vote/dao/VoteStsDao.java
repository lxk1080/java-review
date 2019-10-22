package com.vote.dao;

import java.util.ArrayList;

import com.vote.domain.VoteSts;
import com.vote.util.SqlHelper;

public class VoteStsDao {
	// 插入一条用户的投票信息 并 更新这条投票的参与人数
	public boolean addVote(VoteSts vs){
		String sql = "insert into votests values(0,?,?,?,?,?)";
		String[] params = {vs.getVote_id(), vs.getVote_title(), vs.getVote_man(), vs.getVote_choose(), vs.getVote_date()};
		boolean flag = true;
		try {
			new SqlHelper().executeUpdate(sql, params);
			String count = this.getVotedNum(vs.getVote_id()); // 获取此票参与人数
			VoteListDao vld = new VoteListDao();
 			vld.changeVotedNum(count, vs.getVote_id()); // 改变投票列表参与人数字段的值
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	// 获取用户投过哪些票
	public ArrayList<String> getRecordByPeople(String username){
		ArrayList<String> data = new ArrayList<>();
		String sql = "select vote_id from votests where vote_man = ? ";
		String[] params = {username};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		if(al != null){
			for(Object[] ob : al){
				data.add(ob[0].toString());
			}
		}
		return data;
	}
	
	// 获取用户的某项投票信息
	public VoteSts getResByPeople(String username,String vote_id){
		String sql = "select * from votests where username = ? and vote_id = ? ";
		String[] params = {username,vote_id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		VoteSts vs = new VoteSts();
		if(al != null){
			Object[] ob = al.get(0);
			vs.setId(Integer.parseInt(ob[0].toString()));
			vs.setVote_id(ob[1].toString());
			vs.setVote_title(ob[2].toString());
			vs.setVote_man(ob[3].toString());
			vs.setVote_choose(ob[4].toString());
			vs.setVote_date(ob[5].toString());
		} 
		return vs;
	}
	
	// 获取某项投票的结果数据
	public String getVoteRes(String vote_id){
		ArrayList<String> data = new ArrayList<>();
		String sql = "select vote_choose from votests where vote_id = ? ";
		String[] params = {vote_id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		if(al != null){
			for(Object[] ob : al){
				data.add(ob[0].toString());
			}
		}
		return data.toString();
	}
	
	// 从投票记录表中获取某项投票被投过多少次
	public String getVotedNum(String vote_id){
		String sql = "select count(*) from votests where vote_id = ? ";
		String[] params = {vote_id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		String count = null;
		if(al != null){
			Object[] ob = al.get(0);
			count = ob[0].toString();
		}
		return count;
	}
	
}
