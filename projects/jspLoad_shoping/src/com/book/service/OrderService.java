package com.book.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.book.domain.Book;
import com.book.domain.User;
import com.book.util.DBUtil;

public class OrderService {
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void submitOrder(CartService cs, User user) throws SQLException{
		try {
			// 获取连接
			ct = DBUtil.getCon(); 
			
			// 为了保证订单号是稳定的，将事务隔离级别升级（可串行化）
			ct.setAutoCommit(false); // 不自动提交事务
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); //这是最高级别
			
			// 插入订单表
			String sql = "insert into orderform values(0,?,?,?)"; // 第一个参数是订单编号，也是主键，并且自动递增
			// 预编译,传递参数,执行语句
			ps = ct.prepareStatement(sql); 
			ps.setInt(1, user.getId());  // 用户编号
			ps.setFloat(2, cs.getAllPrice());  // 所有商品总价
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));  //订单日期
			ps.executeUpdate();  
			
			// 得到刚刚插入的订单号（auto_increment的值减1）
			String sql2 = "select auto_increment from information_schema.tables where table_name = ?";
			ps = ct.prepareStatement(sql2);
			ps.setString(1, "orderform"); //表名
			rs = ps.executeQuery();
			rs.next();
			int ord_id = rs.getInt(1) - 1; // auto_increment的值实际上是下一个值
			
			// 插入订单细节表
			HashMap<Integer,Book> cart = cs.getCart();  //获取购物车
			HashMap<Integer,Integer> buyNum = cs.getBuyNum();  //获取装载购物数量的容器
			Set<Integer> set = cart.keySet();
			for(Integer bookid : set){
				String sql3 = "insert into orderdetail value(0,?,?,?,?)";
				ps = ct.prepareStatement(sql3);
				ps.setInt(1, ord_id); // 订单编号
				ps.setInt(2, bookid); // 商品编号
				ps.setString(3, cart.get(bookid).getName()); // 商品名称
				ps.setInt(3, buyNum.get(bookid)); // 商品数量
				ps.setFloat(4, buyNum.get(bookid) * (cart.get(bookid)).getPrice());  // 商品总价
				
				ps.executeUpdate();
			}
			
			// 提交事务
			ct.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, ct);
		}
	}
}
