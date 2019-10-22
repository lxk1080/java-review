package com.etc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.util.DBUtil;
import com.etc.entity.UserList;
import com.etc.entity.UserList;
import com.etc.entity.UserList;

public class Dao {
	
	/**
	 * 登录时验证
	 * @param s
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
			//ͨ查询是否存在用户名
			public boolean findById(String s) throws ClassNotFoundException, SQLException{
				String sql = "select * from userlist where username=?";
				ResultSet rs = DBUtil.doQuery(sql,s);
				if(rs.next()){
					return true;
				}
				return false;
			}
			//查询密码是否与用户名匹配
			public int findByUsername(String s) throws ClassNotFoundException, SQLException{
				String sql = "select password from userlist where username=?";
				ResultSet rs = DBUtil.doQuery(sql,s);
				while(rs.next()){
				int i=rs.getInt("password");
				return i;
				}
				return 0;
			}
	
	
/**
 * 增删改查数据
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	
	
	//添加
	public boolean add(UserList ul) throws ClassNotFoundException, SQLException {
		String sql = "insert into userlist (username,password) values (?,?)";
		boolean flag = DBUtil.doUpdate(sql, ul.getUsername(),ul.getPassword());
		if (flag) {
			return true;
		} else {
			return false;
		}
	}
	
	//删除(通过id直接删除)
	public boolean delete(int i) throws ClassNotFoundException, SQLException{
		String sql = "delete from userlist where id= ?";
		boolean flag = DBUtil.doUpdate(sql, i);
		if(flag){
			return true;
		}
		return false;
	}
	//删除(通过用户名删除的单独页面)
		public boolean deletePage(String s) throws ClassNotFoundException, SQLException{
			String sql = "delete from userlist where username= ?";
			boolean flag = DBUtil.doUpdate(sql, s);
			if(flag){
				return true;
			}
			return false;
		}
	
	//返回更新时的原数据
	public UserList findOldData(int i) throws ClassNotFoundException, SQLException {
		String sql = "select * from userlist where id= ?";
		ResultSet rs = DBUtil.doQuery(sql, i);
		UserList ul = null;
		try {
			while (rs.next()) {
				 ul = new UserList(rs.getInt("id"),rs.getString("username"),rs.getInt("password"));//把查询的结果放到学生中	
				 return ul;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ul;
	}
	//更新
	public boolean update(UserList u) throws ClassNotFoundException, SQLException{
		String sql = "update userlist set username=?,password=? where id = ?";
		boolean flag =DBUtil.doUpdate(sql,u.getUsername(), u.getPassword(),  u.getId());
		if(flag){
			return true;
		}
		return false;
	}
	
	//查询全部数据
	public List<UserList> findAll() throws ClassNotFoundException, SQLException {
		String sql = "select * from userlist ";
		ResultSet rs = DBUtil.doQuery(sql, null);
		List<UserList> list = new ArrayList<UserList>();// 这个集合是拿来存放查询出来的数据
			while (rs.next()) {
				UserList ul = new UserList(rs.getInt("id"),rs.getString("username"),rs.getInt("password"));//把查询的结果放到ul对象中
				list.add(ul);
			}
		return list;
	}
		
		
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
				/*
				//1.������
				Class.forName("com.mysql.jdbc.Driver");
				
				//2.��������
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/user", "root", "root");
				
				//3.ִ����ݿ����
				String sql = "select * from student";
				PreparedStatement pstmt= con.prepareStatement(sql);
				
				//4.������
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()){
					Student stu = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getInt("age"));
					System.out.println(stu);
				}
				
				//5.�ر�(�ȿ��ĺ�ر�)
				rs.close();
				pstmt.close();
				con.close();
				
			} 
		*/
			
		//Dao bd = new Dao();
        
		//bd.findAll();
		
		//bd.findById();
		
		//Book stu = new Book(5,"vb",15.8);
		//bd.add(stu);
		
		//Book stu = new Book(1,"˹�ٷ�ɭ",19);
		//bd.update(stu);
		
		//bd.delete(4);  
	  }
}
