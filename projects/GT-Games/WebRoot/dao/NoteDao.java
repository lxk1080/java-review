package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Note;
import bean.User;

public class NoteDao extends BaseDao {
	
	public List<Note> list(Note userParam, int pageIndex, int pageSize) {
		List<Note> list = new ArrayList<Note>();
		List listParam = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from snote where 1=1");
		
		if(null!=userParam.getSname()&&!"".equals(userParam.getSname())){
			sql.append(" and sname like ? ");
			String t = 
					"%" + userParam.getSname() + "%";
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
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int smid=rs.getInt("smid");
			/*	rs.getDate()//获取日期，年月日
				rs.getTimestamp()//获取时间戳, 年月日时分秒*/	
				String sprofile=rs.getString("sprofile");
				String sstatement=rs.getString("sstatement");
				Note note = new Note();
				 note.setSid(sid);
				 note.setSname(sname);
				 note.setSmid(smid);
				 note.setSprofile(sprofile);
				 note.setSstatement(sstatement);
				
				 list.add(note);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return list;
	}
	public Note view(int idParam) {
		String sql = "select * from snote where sid=?";
		Object[] params = {idParam};
		ResultSet rs = executeSQL(sql, params);
		Note note = new Note();
		try {
			while(rs.next()){
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int smid=rs.getInt("smid");
				 String sprofile=rs.getString("sprofile");
				 String sstatement=rs.getString("sstatement");
				 note.setSid(sid);
				 note.setSname(sname);
				 note.setSmid(smid);
				 note.setSprofile(sprofile);
				 note.setSstatement(sstatement);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return note;
	}
	public void delete(int sid) {
		String sql = "delete from snote where sid=?";
		Object[] params = {sid};
		executeUpdate(sql, params);
		closeResource();
	}

	public int getTotalCount(Note note) {
		int totalCount=0;
		StringBuffer sql=new StringBuffer("select count(1) from snote where 1=1 ");
		
		List listParam = new ArrayList();
		
		if(null!=note.getSname()&&!"".equals(note.getSname())){
			sql.append(" and sname like ? ");
			String t = "%" + note.getSname() + "%";
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
