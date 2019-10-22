package com.etc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1/user";
	private static String username="your_username";
	private static String password="your_password";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	//获取连接
	public static Connection getCon() throws ClassNotFoundException, SQLException{
		//加载驱动
		Class.forName(driver);
		//连接数据库
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	} 
	
	//关闭连接
	public static void close() throws SQLException{
		if(rs!=null){rs.close();}
		if(ps!=null){ps.close();}
		if(con!=null){con.close();}
	}
	
	//查询方法
	public static ResultSet doQuery(String sql,Object...params) throws ClassNotFoundException, SQLException{
		
		con = DBUtil.getCon(); //加载驱动,连接数据库
		
		ps = con.prepareStatement(sql); //编译
		
		if(params!=null){   	//处理编译结果
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i,params[i-1]);
			}
		}
		ResultSet rs = ps.executeQuery(); //执行语句，接受结果
		
		return rs;	
	}
	
	//更新方法
	public static boolean doUpdate(String sql, Object...params) throws ClassNotFoundException, SQLException{
		
		con = DBUtil.getCon(); //加载驱动，连接数据库
		
		ps = con.prepareStatement(sql); //编译
		
		if(params!=null){
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i,params[i-1]);
			}
		}
		ps.executeUpdate();  //无返回集
		return true;
	}
}

