package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Reply;
import bean.User;

public class ReplyDao extends BaseDao{
	public List<Reply> getReplysByTid(int tid){
		List<Reply> list= new ArrayList<Reply>();
		String sql = "select * from reply ,`user` where reply.ruid=`user`.id and reply.rtid = ? order by rtime desc";
		Object[] params={tid};
		ResultSet rs = executeSQL(sql, params);
		try {
			while(rs.next()){
				int rid = rs.getInt("rid");
				int rtid = rs.getInt("rtid");
				String rcontents = rs.getString("rcontents");
				Date rtime = rs.getTimestamp("rtime");
				Reply reply = new Reply();
				reply.setRid(rid);
				reply.setRtid(rtid);
				reply.setRcontents(rcontents);
				reply.setRtime(rtime);
				
				int id = rs.getInt("id");
				String sname= rs.getString("sname");
				String photo = rs.getString("photo");
				User user = new User();
				user.setId(id);
				user.setSname(sname);
				user.setPhoto(photo);
				
				reply.setUser(user);
				list.add(reply);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return list;
	}

	public boolean add(Reply reply) {
		boolean flag = false;
		String sql = "insert into reply (ruid,rtid,rcontents,rtime) values(?,?,?,?)";
		Object[] params = {reply.getUser().getId(),reply.getRtid(),reply.getRcontents(),reply.getRtime()};
		int num = executeUpdate(sql, params);
		if(num>0){
			flag = true;
		}		
		closeResource();
		return flag;
	}
}
