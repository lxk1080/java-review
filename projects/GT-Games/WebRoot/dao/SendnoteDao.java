package dao;
import bean.SendNote;
public class SendnoteDao extends BaseDao {
	public boolean add(SendNote sendnote) {
		String sql = "insert into tsend(ttopic,tcontents,tuid,ttime) values(?,?,?,?)";
		Object[] params = {sendnote.getTtopic(),sendnote.getTcontents(),sendnote.getTuid(),sendnote.getTtime()};
		int num = executeUpdate(sql, params);
		if(num>0){
			return true;
		}else{
			return false;
		}
	}
}
