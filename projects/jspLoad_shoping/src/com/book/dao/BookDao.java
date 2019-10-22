package com.book.dao;

import java.util.ArrayList;

import com.book.domain.Book;
import com.book.util.SqlHelper;

public class BookDao {
	
	// 获得所有的书
	public ArrayList<Book> getAllBook(){
		ArrayList<Book> data = new ArrayList<Book>();
		String sql = "select * from book";
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, null);
		for(Object[] ob : al){
			Book book = new Book();
			book.setId(Integer.parseInt(ob[0].toString()));
			book.setName(ob[1].toString());
			book.setAuthor(ob[2].toString());
			book.setPublish(ob[3].toString());
			book.setPrice(Float.parseFloat(ob[4].toString()));
			book.setNums(Integer.parseInt(ob[5].toString()));
			data.add(book);
		}
		return data;
	}
	
	// 通过书的id获取书对象
	public Book getBookById(String id){
		String sql = "select * from book where id = ? ";
		String[] params = {id};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		Object[] ob = al.get(0);
		Book book = new Book();
		book.setId(Integer.parseInt(ob[0].toString()));
		book.setName(ob[1].toString());
		book.setAuthor(ob[2].toString());
		book.setPublish(ob[3].toString());
		book.setPrice(Float.parseFloat(ob[4].toString()));
		book.setNums(Integer.parseInt(ob[5].toString()));
		return book;
	}
	
	// 从库存中拿走一本书
	public int removeBook(Book book){
		String sql = "select nums from book where id = ?";
		String[] params = {book.getId()+""};
		ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
		Object[] ob = al.get(0);
		int nums = Integer.parseInt(ob[0].toString()); // 获取此时书的数量
		if(nums == 0){ // 如果库存中没有书了
			return 2; // 库存为0
		} else {
			String sql2 = "update book set nums = ? where id = ?"; // 改变书的数量
			String[] params2 = {String.valueOf((--nums)),book.getId()+""};
			try {
				new SqlHelper().executeUpdate(sql2, params2);
			} catch (Exception e) {
				return 3; // 购买失败
			}
			return 1; //购买成功
		}
	}
	
	// 获得总数据数
	public int getRowCount(int pageSize){
		String countSql = "select count(*) from book";
		ArrayList<Object[]> al = new SqlHelper().executeQuery(countSql, null);
		int rowCount = 0;
		try {
			Object[] ob = al.get(0); //相当于获取结果集的第一行数据
			rowCount = Integer.parseInt(ob[0].toString());  //获取总共多少条数据 （第一行的第一列）
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	// 获得某一页显示的数据
	public ArrayList<Book> getUsersByPage(int pageNow, int pageSize){
		ArrayList<Book> data = new ArrayList<Book>();
		String sql = "select * from book limit "+(pageNow-1)*pageSize+","+pageSize; //从某个索引开始，取几条数据（索引从0开始）
		ArrayList<Object[]> al =  new SqlHelper().executeQuery(sql, null);
		try {
			for(Object[] ob : al){
				Book book = new Book();
				book.setId(Integer.parseInt(ob[0].toString()));
				book.setName(ob[1].toString());
				book.setAuthor(ob[2].toString());
				book.setPublish(ob[3].toString());
				book.setPrice(Float.parseFloat(ob[4].toString()));
				book.setNums(Integer.parseInt(ob[5].toString()));
				data.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return data;
	}
	
}
