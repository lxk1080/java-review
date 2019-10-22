package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.book.domain.OrderDetail;
import com.book.domain.OrderForm;
import com.book.domain.User;
import com.book.util.DBUtil;
import com.book.util.SqlHelper;

public class OrderDao {
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	// 提交订单，将订单信息插入到数据库
	public void submitOrder(OrderForm order, ArrayList<OrderDetail> al) throws SQLException{
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
			ps.setInt(1, order.getUser_id());  // 用户编号
			ps.setFloat(2, order.getOrd_allprice());  // 所有商品总价
			ps.setString(3, order.getOrd_time());  //订单日期
			ps.executeUpdate();  
			
			// 得到刚刚插入的订单号（auto_increment的值减1）
			String sql2 = "select auto_increment from information_schema.tables where table_name = ?";
			ps = ct.prepareStatement(sql2);
			ps.setString(1, "orderform"); //表名
			rs = ps.executeQuery();
			rs.next();
			int ord_id = rs.getInt(1) - 1; // auto_increment的值实际上是下一个值
			
			// 插入订单细节表
			for(OrderDetail detail : al){
				String sql3 = "insert into orderdetail value(0,?,?,?,?,?)";
				ps = ct.prepareStatement(sql3);
				ps.setInt(1, ord_id); // 订单编号
				ps.setInt(2, detail.getGoods_id()); // 商品编号
				ps.setString(3, detail.getGoods_name()); // 商品名称
				ps.setInt(4, detail.getGoods_num()); // 商品数量
				ps.setFloat(5, detail.getGoods_allprice());  // 商品总价
				
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
	
	// 获取历史订单
	public ArrayList getHistoryOrder(User user){
		ArrayList<ArrayList> allOrder = new ArrayList<>(); // 装载所有订单
		synchronized(this){
			String sql = "select * from orderform where user_id = ?";
			String[] params = {user.getId()+""};
			ArrayList<Object[]> al = new SqlHelper().executeQuery(sql, params);
			for(Object[] ob : al){
				ArrayList order = new ArrayList<>(); // 一个订单（由一个orderform和若干orderdetail组成）
				
				OrderForm of = new OrderForm();
				of.setOrd_id(Integer.parseInt(ob[0].toString()));
				of.setUser_id(Integer.parseInt(ob[1].toString()));
				of.setOrd_allprice(Float.parseFloat(ob[2].toString()));
				try {
					// 解决日期的.0问题
					// 将ob[3]toString()以指定格式解析为日期（这个时候已经解决了.0问题），再把日期格式化为字符串
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = sdf.parse(ob[3].toString()); 
					String dateStr = sdf.format(date);
					of.setOrd_time(dateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				order.add(of); // 加入订单信息orderform
				
				String sql2 = "select * from orderdetail where ord_id = ?";
				String[] params2 = {of.getOrd_id()+""};
				ArrayList<Object[]> al2 = new SqlHelper().executeQuery(sql2, params2);
				for(Object[] ob2 : al2){
					OrderDetail od = new OrderDetail();
					od.setId(Integer.parseInt(ob2[0].toString()));
					od.setOrd_id(Integer.parseInt(ob2[1].toString()));
					od.setGoods_id(Integer.parseInt(ob2[2].toString()));
					od.setGoods_name(ob2[3].toString());
					od.setGoods_num(Integer.parseInt(ob2[4].toString()));
					od.setGoods_allprice(Float.parseFloat(ob2[5].toString()));
					order.add(od); // 加入订单细节数据orderdetail
				}
				allOrder.add(order); // 加入一个订单
			}
		}
		return allOrder;  // 返回所有订单
	}
	
}
