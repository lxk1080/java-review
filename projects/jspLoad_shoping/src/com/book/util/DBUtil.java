package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtil {
	
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1/jspLoad?characterEncoding=utf-8";
	private static String username="your_username";
	private static String password="your_password";
	
	//获取连接
	public static Connection getCon() throws ClassNotFoundException, SQLException{
		//加载驱动
		Class.forName(driver);
		//连接数据库
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	} 
	
	//关闭连接
	public static void close(ResultSet rs,PreparedStatement ps,Connection con) throws SQLException{
		if(rs!=null){rs.close();}
		if(ps!=null){ps.close();}
		if(con!=null){con.close();}
	}
	
	//查询方法
	public static ArrayList doQuery(String sql,Object...params) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.getCon(); //加载驱动,连接数据库
		
		PreparedStatement ps = con.prepareStatement(sql); //预编译
		
		if(params!=null){   	//传递参数
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i,params[i-1]);
			}
		}
		ResultSet rs = ps.executeQuery(); //执行语句，接受结果
		
		//close(null, null, con);  
		//这里如果关闭了con，则ps会自动关闭,然后rs自动关闭,但是rs还需要使用，为了在使用后能够关闭资源，只能将rs、ps、con都返回
		//用集合接收查询结果，al.get(0)就是rs结果集，用  DBUtil.close(al.get(0), al.get(1), al.get(2)) 释放资源
		//这种方法没有实现在哪里使用就在哪里关闭的原则，SqlHelper将会解决这个问题
	
		ArrayList al = new ArrayList();
		al.add(rs);
		al.add(ps);
		al.add(con);
		
		return al;  //这个查询方法的资源关闭会有一定的麻烦
	}
	
	//更新方法
	public static boolean doUpdate(String sql, Object...params) throws ClassNotFoundException, SQLException{
		
		Connection con = DBUtil.getCon(); //加载驱动，连接数据库
		
		PreparedStatement ps = con.prepareStatement(sql); //编译
		
		if(params!=null){
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i,params[i-1]);
			}
		}
		ps.executeUpdate();  //无返回集
		
		close(null, ps, con);  // 更新操作无返回集rs，只需要关闭ps和con
		
		return true;  //能执行到这一句，说明更新操作成功，如果失败，则直接会在 ps.executeUpdate()报错，后面的语句不会执行
	}
}

