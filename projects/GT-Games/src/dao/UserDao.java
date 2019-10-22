package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.User;

public class UserDao extends BaseDao{
	
	public  User check(String username, String password)
	 {
		User user = null;
       try {
	    String sql = "select * from user where sname=? and password=?";
	    Object[] params = {username,password};
		ResultSet rs1 = executeSQL(sql,params);
	  while (rs1.next()) {
		  user = new User();
		  user.setId(rs1.getInt("id"));
		  user.setSname(rs.getString("sname"));
		  user.setRoleid(rs.getInt("roleid"));
		  user.setPassword(rs.getString("password"));
		//  user.setBirthday(rs.getTimestamp("birthday"));
		  user.setEmail(rs.getString("email"));
		  user.setPhoto(rs.getString("photo"));
	}
        } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
       finally{
			//关闭资源
			closeResource();
		}
   return user;
}
public List<User> findBySname(User userParam,String sname){
		
	List<User> list = new ArrayList<User>();
	List listParam = new ArrayList();
	StringBuffer sql = new StringBuffer("select sname  from tsend where 1=1 ");
	if(null!=userParam.getSname()&&!"".equals(userParam.getSname())){
		sql.append(" and sname like ? ");
		String t = "%" + userParam.getSname() + "%";
		listParam.add(t);
	}
	return list;
	}

	public User login(String username, String password) {
		User user = null;
		try {
			String sql = "select * from user where sname=? and password=?";
			Object[] params = {username,password};
			ResultSet rs = executeSQL(sql,params);
			//遍历结果集
			while(rs.next()){
				int id = rs.getInt("id");
				String sname = rs.getString("sname");
				String psd= rs.getString("password");
			/*	rs.getDate()//获取日期，年月日
				rs.getTimestamp()//获取时间戳, 年月日时分秒*/	
				//Date birthday = rs.getDate("birthday");
				int roleid = rs.getInt("roleid");
				user = new User();
				 user.setId(id);
				 user.setSname(sname);
				 user.setPassword(psd);
				 //user.setBirthday(birthday);
				 user.setRoleid(roleid);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			closeResource();
		}
		return user;
	}
	
	public List<User> list(User userParam, int pageIndex, int pageSize) {
		List<User> list = new ArrayList<User>();
		List listParam = new ArrayList();
		StringBuffer sql = new StringBuffer("select user.*, role.rolename from user,role where user.roleid = role.id ");
		
		if(null!=userParam.getSname()&&!"".equals(userParam.getSname())){
			sql.append(" and sname like ? ");
			String t = "%" + userParam.getSname() + "%";
			listParam.add(t);
		}
		sql.append(" limit ?,?");
		int param = (pageIndex-1)*pageSize;
		listParam.add(param);
		listParam.add(pageSize);
		Object[] params = listParam.toArray();
		ResultSet rs = executeSQL(sql.toString(),params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String sname = rs.getString("sname");
				String psd= rs.getString("password");
			/*	rs.getDate()//获取日期，年月日
				rs.getTimestamp()//获取时间戳, 年月日时分秒*/	
				//Date birthday = rs.getDate("birthday");
				int roleid = rs.getInt("roleid");
				String photo = rs.getString("photo");
				String rolename = rs.getString("rolename");
				User user = new User();
				 user.setId(id);
				 user.setSname(sname);
				 user.setPassword(psd);
				 //user.setBirthday(birthday);
				 user.setRoleid(roleid);
				 user.setPhoto(photo);
				 user.setRolename(rolename);
				 list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return list;
	}

	public boolean add(User user) {
		String sql = "insert into user(sname,password,roleid,photo) values(?,?,?,?,?)";
		Object[] params = {user.getSname(),user.getPassword(),user.getRoleid(),user.getPhoto()};
		int num = executeUpdate(sql, params);
		if(num>0){
			return true;
		}else{
			return false;
		}
	}
	public  boolean adduser(User user){
		String sql=" insert into user (sname,password,email,roleid)values(?,?,?,?)";
		Object[] params = {user.getSname(),user.getPassword(),user.getEmail(),user.getRoleid()};
		int num =executeUpdate(sql, params);
		if(num>0){
			return true;
		}else{
			return false;
		}
		
		 
		 }

	public void delete(int id) {
		String sql = "delete from user where id=?";
		Object[] params = {id};
		executeUpdate(sql, params);
		closeResource();
	}

	public User view(int idParam) {
		String sql = "select * from user where id=?";
		Object[] params = {idParam};
		ResultSet rs = executeSQL(sql, params);
		User user = new User();
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String sname = rs.getString("sname");
				String psd= rs.getString("password");
			/*	rs.getDate()//获取日期，年月日
				rs.getTimestamp()//获取时间戳, 年月日时分秒*/	
				//Date birthday = rs.getDate("birthday");
				int roleid = rs.getInt("roleid");
				String photo = rs.getString("photo");
				 user.setId(id);
				 user.setSname(sname);
				 user.setPassword(psd);
				// user.setBirthday(birthday);
				 user.setRoleid(roleid);
				 user.setPhoto(photo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return user;
	}

	public int getTotalCount(User user) {
		int totalCount=0;
		StringBuffer sql=new StringBuffer("select count(1) from user where 1=1 ");
		
		List listParam = new ArrayList();
		
		if(null!=user.getSname()&&!"".equals(user.getSname())){
			sql.append(" and sname like ? ");
			String t = "%" + user.getSname() + "%";
			listParam.add(t);
		}
		
		Object[] params=listParam.toArray();
		ResultSet rs=this.executeSQL(sql.toString(), params);
		try {
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return totalCount;
	}

}
