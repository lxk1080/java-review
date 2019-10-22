package com.vote.dao;

import java.util.ArrayList;

import net.sf.json.JSONObject;

import com.vote.domain.VoteList;
import com.vote.util.SqlHelper;

public class VoteListDao {
	// 创建一个投票
	public boolean createVote(VoteList vl){
		String sql = "insert into votelist values(0,?,?,?,?,?,?,?,?,?,0)";
		String[] params = {vl.getType(), vl.getTitle(), vl.getDesc(), vl.getImg(), vl.getChoose(), vl.getPattern(), vl.getPeopleNum(), vl.getPubDate(), vl.getExpireDate()};
		boolean flag = true;
		try {
			new SqlHelper().executeUpdate(sql, params);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	// 改变一个投票项的已投票人数
	public void changeVotedNum(String votedNum, String id){
		String sql = "update votelist set votedNum = ? where id = ? ";
		String[] params = {votedNum, id};
		try{
			new SqlHelper().executeUpdate(sql, params);
		} catch(Exception e){
			System.out.println("改变已投票人数时发生错误！");
		}
	}
	
	// 删除一个投票
	public boolean delVote(String id){
		String sql = "delete from votelist where id = ?";
		String[] params = {id};
		boolean flag = true;
		try{
			new SqlHelper().executeUpdate(sql, params);
		} catch(Exception e){
			flag = false;
		}
		return flag;
	}
	
	// 获得所有投票
	public String getVoteList(){
		ArrayList<VoteList> data = new ArrayList<VoteList>();
		String sql = "select * from votelist";
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, null);
		for(Object[] ob : al){
			VoteList vl = new VoteList();
			vl.setId(Integer.parseInt(ob[0].toString()));
			vl.setType(ob[1].toString());
			vl.setTitle(ob[2].toString());
			vl.setDesc(ob[3].toString());
			vl.setImg(ob[4].toString());
			vl.setChoose(ob[5].toString());
			vl.setPattern(ob[6].toString());
			vl.setPeopleNum(ob[7].toString());
			vl.setPubDate(ob[8].toString());
			vl.setExpireDate(ob[9].toString());
			vl.setVotedNum(ob[10].toString());
			vl.toString(); //转化成json格式			
			data.add(vl);
		}
		return data.toString();
	}
	
	// 通过id找到投票
	public String getVoteById(String id){
		String sql = "select * from votelist where id = ? ";
		String[] params = {id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		Object[] ob = al.get(0);
		VoteList vl = new VoteList();
		vl.setId(Integer.parseInt(ob[0].toString()));
		vl.setType(ob[1].toString());
		vl.setTitle(ob[2].toString());
		vl.setDesc(ob[3].toString());
		vl.setImg(ob[4].toString());
		vl.setChoose(ob[5].toString());
		vl.setPattern(ob[6].toString());
		vl.setPeopleNum(ob[7].toString());
		vl.setPubDate(ob[8].toString());
		vl.setExpireDate(ob[9].toString());
		vl.setVotedNum(ob[10].toString());
		return vl.toString();
	}
	
}
