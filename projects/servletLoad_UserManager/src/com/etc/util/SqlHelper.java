package com.etc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SqlHelper {
	// 定义变量 （下面这些变量在每次访问数据库时都会使用，使用静态的可能会导致用户等待超时，故是非静态）
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	// 连接数据库的参数 （下面的静态变量只会在第一次访问此类时使用一次，故设为静态的，也不会产生用户等待超时）
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	
	// 存储过程变量 （会多次使用）
	private CallableStatement cs = null;
	
	public CallableStatement getCs() {
		return cs;
	}
	
	// 操作属性文件变量 （只使用一次）
	private static Properties pp = null;
	private static InputStream fis = null;

	
	// 加载驱动，只需要一次，用静态代码块
	static {
		try {
			// 从dbinfo.properties
			pp = new Properties();
			// 类加载器读取资源时，默认主目录是src，如果文件放在包下，/com/etc/util/dbinfo.properties
			fis = SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties"); //类加载器
			pp.load(fis);
			
			driver = pp.getProperty("driver");
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			password = pp.getProperty("password");

			Class.forName(driver); //加载驱动
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fis = null;// 垃圾回收站上收拾
		}
	}

	// 得到连接
	public Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	
	public Connection getCt() {
		return ct;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public ResultSet getRs() {
		return rs;
	}
	

	// 执行查询语句
	// 保证了哪里使用资源，哪里关闭资源的原则
	public ArrayList<Object[]> executeQuery(String sql, String[] parameters) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
			
			ArrayList<Object[]> al = new ArrayList<Object[]>();
			ResultSetMetaData rsmd = rs.getMetaData(); //得到结果集(rs)的结构信息
			int column = rsmd.getColumnCount(); // 获取总列数
			
			while(rs.next()){
				Object[] ob = new Object[column];
				for(int i = 1; i <= column; i++){
					ob[i-1] = rs.getObject(i);
				}
				al.add(ob);
			}
			
			return al; //返回这个集合,集合中的一个元素（Object数组）就是一行数据
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, ps, ct); //关闭
		}
	}

	// 一条sql更新语句
	public void executeUpdate(String sql, String[] parameters) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}

			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();// 开发阶段
			// 抛出异常
			// 可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, ps, ct);
		}
	}
	
	// 多条sql更新语句
	public void executeUpdate2(String[] sql, String[][] parameters) {
		try {
			ct = getConnection();
			ct.setAutoCommit(false);

			for (int i = 0; i < sql.length; i++) {
				if (null != parameters[i]) {
					ps = ct.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++) {
						ps.setString(j + 1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, ps, ct);
		}
	}
	
	
	// *************callPro1存储过程函数1*************
	public CallableStatement callPro1(String sql, String[] parameters) {
		try {
			ct = getConnection();
			cs = ct.prepareCall(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					cs.setObject(i + 1, parameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, cs, ct);
		}
		return cs;
	}
	
	// *******************callpro2存储过程2************************
	public CallableStatement callPro2(String sql, String[] inparameters,
			Integer[] outparameters) {
		try {
			ct = getConnection();
			cs = ct.prepareCall(sql);
			if (inparameters != null) {
				for (int i = 0; i < inparameters.length; i++) {
					cs.setObject(i + 1, inparameters[i]);
				}
			}
			// cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
			if (outparameters != null) {
				for (int i = 0; i < outparameters.length; i++) {
					cs.registerOutParameter(inparameters.length + 1 + i,
							outparameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {

		}
		return cs;
	}
	
	public void close(ResultSet rs, Statement ps, Connection ct) {
		// 关闭资源(先开后关)
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
}
