package com.book.dao;

import java.util.ArrayList;

import com.book.domain.User;
import com.book.util.SqlHelper;

public class UserDao {
	// 登录验证
	public boolean checkUser(User u){
		String sql = "select * from user where username = ? and password = ?";
		String[] params = {u.getUsername(),u.getPassword()};
		ArrayList<Object[]> al= new SqlHelper().executeQuery(sql, params);
		if(al.size() == 0){
			return false;
		} else {
			Object[] ob = al.get(0); //获取第一行
			u.setId(Integer.parseInt(ob[0].toString())); //获取第一列
			//u.setUsername(ob[1].toString());
			//u.setPassword(ob[2].toString());
			u.setEmail(ob[3].toString()); // 获取第三列
			u.setPhone(Integer.parseInt(ob[4].toString()));
			u.setGrade(Integer.parseInt(ob[5].toString()));
			return true;
		}
	}
	
}
