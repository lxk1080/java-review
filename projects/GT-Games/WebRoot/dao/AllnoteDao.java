package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.AllNote;
import bean.User;



public class AllnoteDao extends BaseDao {
	public List<AllNote> list(AllNote userParam, int pageIndex, int pageSize) {
		List<AllNote> list = new ArrayList<AllNote>();
		List listParam = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from tsend where 1=1");
		
		if(null!=userParam.getTtopic()&&!"".equals(userParam.getTtopic())){
			sql.append(" and ttopic like ? ");
			String t = "%" + userParam.getTtopic() + "%";
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
				int tid = rs.getInt("tid");
				String ttopic = rs.getString("ttopic");	
				String tcontents=rs.getString("tcontents");
				AllNote allnote = new AllNote();
				 allnote.setTid(tid);
				 allnote.setTtopic(ttopic);
				 allnote.setTcontents(tcontents);
				
				
				 list.add(allnote);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return list;
	}
	public AllNote view(int idParam) {
		String sql = "select * from tsend left join `user` on tsend.tuid=`user`.id where tid=?";
		Object[] params = {idParam};
		ResultSet rs = executeSQL(sql, params);
		AllNote allnote=new AllNote();
		try {
			while(rs.next()){
				int tid = rs.getInt("tid");
				String ttopic = rs.getString("ttopic");
				String tcontents= rs.getString("tcontents");
				String sname = rs.getString("sname");
				 allnote.setTid(tid);
				 allnote.setTtopic(ttopic);
				 allnote.setTcontents(tcontents);
				 allnote.setSname(sname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return allnote;
	}
	public void delete(int tid) {
		String sql = "delete from  tsend where tid=?";
		Object[] params = {tid};
		executeUpdate(sql, params);
		closeResource();
	}
	public int getTotalCount(AllNote allnote) {
		int totalCount=0;
		StringBuffer sql=new StringBuffer("select count(1) from tsend where 1=1 ");
		
		List listParam = new ArrayList();
		
		if(null!=allnote.getTtopic()&&!"".equals(allnote.getTtopic())){
			sql.append(" and ttopic like ? ");
			String t = "%" + allnote.getTtopic() + "%";
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
