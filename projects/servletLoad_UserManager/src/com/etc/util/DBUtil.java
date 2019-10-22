package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1/servletLoad?characterEncoding=utf-8";
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
	public static ResultSet doQuery(String sql,Object...params) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.getCon(); //加载驱动,连接数据库
		
		PreparedStatement ps = con.prepareStatement(sql); //预编译
		
		if(params!=null){   	//传递参数
			for (int i = 1; i <= params.length; i++) {
				ps.setObject(i,params[i-1]);
			}
		}
		ResultSet rs=ps.executeQuery(); //执行语句，接受结果
		//DBUtil.close(null, ps, con);
		return rs;
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
		close(null, ps, con);
		return true;
	}
}

