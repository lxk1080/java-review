package com.etc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	
	//查询全部
	public void findAll() throws ClassNotFoundException, SQLException{
		String sql = "select * from student";
		ResultSet rs = DBUtil.doQuery(sql,null);
		while(rs.next()){
				Student stu = new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
				System.out.println(stu);	
			}
		}
	
	//通过id查询
	public void findById(int id) throws ClassNotFoundException, SQLException{
		String sql = "select * from student where id= ?";
		ResultSet rs = DBUtil.doQuery(sql,id);
		while(rs.next()){
			Student stu = new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
			System.out.println(stu);	
		}
	}
	
	//添加元素
	public void add(Student stu) throws ClassNotFoundException, SQLException{
		String sql = "insert into student(id,name,age) values(?,?,?)";
		boolean flag = DBUtil.doUpdate(sql, stu.getId(),stu.getName(),stu.getAge());
		System.out.println(flag);
	}
	
	//更新元素
	public void update(Student stu) throws ClassNotFoundException, SQLException{
		String sql = "update student set name=?,age=? where id = ?";
		boolean flag =DBUtil.doUpdate(sql, stu.getName(),stu.getAge(),stu.getId());
		System.out.println(flag);
	}
	
	//删除元素
	public void delete(int id) throws ClassNotFoundException, SQLException{
		String sql = "delete from student where id = ?";
		boolean flag = DBUtil.doUpdate(sql, id);
		System.out.println(flag);
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/*
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/user", "root", "root");
			
			//3.执行数据库语句
			String sql = "select * from student";
			PreparedStatement pstmt= con.prepareStatement(sql);
			
			//4.遍历结果
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				Student stu = new Student(rs.getInt("sid"), rs.getString("sname"), rs.getInt("age"));
				System.out.println(stu);
			}
			
			//5.关闭(先开的后关闭)
			rs.close();
			pstmt.close();
			con.close();
			
		} 
	*/
		
	Jdbc jdbc = new Jdbc();
	
	//查询全部
	jdbc.findAll();
	
	//通过id查询
	//jdbc.findById(1);
	
	//添加元素
	//Student stu = new Student(4,"vb",15);
	//jdbc.add(stu);
	
	//修改元素
	//Student stu = new Student(1,"斯蒂芬森",19);
	//jdbc.update(stu);
	
	//删除元素
	//jdbc.delete(4);
		
  }
}
