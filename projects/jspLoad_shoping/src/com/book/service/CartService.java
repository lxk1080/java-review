package com.book.service;

import java.util.HashMap;
import java.util.Set;

import com.book.dao.BookDao;
import com.book.domain.Book;

public class CartService {
	// 购物车（参数：书id，书对象）
	private HashMap<Integer,Book> cart = new HashMap<>();
	
	// 买各种书的数量（参数：书id，购买数量）
	private HashMap<Integer,Integer> buyNum = new HashMap<>();
	
	// 添加书（购买书）
	public String addBook(Book book){
		BookDao bd = new BookDao();
		int mes = bd.removeBook(book); // 从库存中拿一本书，通过返回的标记判断结果
		if(mes == 1){
			if(cart.containsKey(book.getId())){
				int bookNum = buyNum.get(book.getId());
				buyNum.put(book.getId(), ++bookNum);
			} else {
				cart.put(book.getId(), book);
				buyNum.put(book.getId(), 1);
			}
			return "购买成功！";
		} else if (mes == 2) {
			return "已经没有库存了!";
		} else {
			return "购买失败！";
		} 
	}
	
	// 删除书
	public void delBook(Book book){
		cart.remove(book.getId());
		buyNum.remove(book.getId());
	}
	
	// 更新书（参数：Map(要更新的书号，数量)）
	public void updateBook(HashMap<Integer,Integer> hm){
		Set<Integer> set = hm.keySet();
		Set<Integer> set2 = buyNum.keySet();
		for(Integer updateId : set){ // 找到所有要更新的书的id
			for(Integer bookid : set2){ // 找到数量容器中对应的id
				if(updateId == bookid){
					buyNum.put(bookid, hm.get(updateId)); // 把数量容器中对应id的书的数量修改
					break;
				}
			}
		}
	}
	
	// 清空书
	public void clearBook(){
		cart.clear();
		buyNum.clear();
	}
	
	// 获取购物车
	public HashMap<Integer, Book> getCart() {
		return cart;
	}
	// 存储各种书的购买数量的容器
	public HashMap<Integer, Integer> getBuyNum() {
		return buyNum;
	}
	
	// 获得购物车中书的总价
	public float getAllPrice(){
		float allPrice = 0;
		Set<Integer> set = buyNum.keySet(); // 购物车中所有书的id
		BookDao bd = new BookDao();
		for(Integer bookid : set){
			Book book = bd.getBookById(bookid.toString()); // 通过id获取书对象
			float price = book.getPrice(); // 获取价格 
			int nums = buyNum.get(bookid); // 购物车中此种书的数量
			allPrice += price*nums;
		}
		
		// 保留一位小数(浮点型的数据进行运算时会进行科学运算，会有大约17位小数，这里注释保留小数的操作，直接在显示页面用JSTL控制)
		
		// 假设 Math.round(allPrice*10) = 396，则 (float)(Math.round(allPrice*10))=396.0
		//allPrice = (float)(Math.round(allPrice*10))/10;
		
		// 整数+浮点数=浮点数
		//allPrice = (Math.round(allPrice*10)+1.0F-1.0F)/10;
		
		// 上面的两种方式都能获得浮点型的数据，下面这种不行，因为Math.round()会四舍五入为整数，而 整数/整数=整数
		// 例如allPrice的值是39.56，则allPrice*10=395.6，Math.round(395.6)=396，396/10=39
		// 由于allPrice是浮点型，最终结果为39.0，而正确结果应该是39.6
		//allPrice = (Math.round(allPrice*10))/10;
		
		return allPrice;
	}
	
}
