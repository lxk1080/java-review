package com.etc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.etc.entity.Users;
import com.etc.util.DBUtil;
import com.etc.util.SqlHelper;

public class UsersDao {
	
	// 登录验证
	public boolean checkUser(Users u){
		boolean b = false;
		String sql="select * from users where username = ? and password = ?";
		String[] params = {u.getUsername(),u.getPassword()};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		try {
			if(al.size() == 1){
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	// 添加用户
	public boolean addUser(Users u){
		boolean sts = true;
		String sql = "insert into users values(0,?,?,?,?)";
		String[] params = {u.getUsername(),u.getEmail(),u.getGrade(),u.getPassword()};
		try {
			new SqlHelper().executeUpdate(sql, params);
		} catch (Exception e) {
			sts = false;
		}
		return sts;
	}
	
	// 通过用户id获得用户信息
	public Users getUserById(String id){
		Users u = new Users();
		String sql = "select * from users where id = ?";
		String[] parameters = {id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, parameters);
		try {
			for(Object[] ob : al){
				u.setId(Integer.parseInt(ob[0].toString()));
				u.setUsername(ob[1].toString());
				u.setEmail(ob[2].toString());
				u.setGrade(ob[3].toString());
				u.setPassword(ob[4].toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	// 修改指定用户id的用户信息
	public boolean updateUser(Users u){
		boolean flag = true;
		String sql = "update users set username=?,email=?,grade=?,password=? where id=?";
		String[] parameters = {u.getUsername(),u.getEmail(),u.getGrade(),u.getPassword(),u.getId()+""};
		try{
			new SqlHelper().executeUpdate(sql, parameters);
		} catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	
	// 删除用户
	public boolean delUser(String id){
		boolean b = true;
		String sql = "delete from users where id = ?";
		String[] params = {id};
		try{
			new SqlHelper().executeUpdate(sql, params);
		} catch(Exception e){
			b = false;
		}
		return b;
	}
	
	// 获得总页数
	public int getPageCount(int pageSize){
		String countSql = "select count(*) from users";
		ArrayList<Object[]> al = new SqlHelper().executeQuery(countSql, null);
		int rowCount = 0;
		try {
			Object[] ob = al.get(0); //相当于获取结果集的第一行数据
			rowCount = Integer.parseInt(ob[0].toString());  //获取总共多少条数据 （第一行的第一列）
		} catch (Exception e) {
			e.printStackTrace();
		} 
		int pageCount = (rowCount-1)/pageSize+1; //获得总共多少页
		
		return pageCount;
	}
		
	// 获得某一页显示的数据
	public ArrayList<Users> getUsersByPage(int pageNow, int pageSize){
		ArrayList<Users> data = new ArrayList<Users>();
		String sql = "select * from users limit "+(pageNow-1)*pageSize+","+pageSize; //从某个索引开始，取几条数据（索引从0开始）
		ArrayList<Object[]> al =  new SqlHelper().executeQuery(sql, null);
		try {
			for(Object[] ob : al){
				Users u = new Users();
				u.setId(Integer.parseInt(ob[0].toString()));
				u.setUsername(ob[1].toString());
				u.setEmail(ob[2].toString());
				u.setGrade(ob[3].toString());
				data.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}
	
}
