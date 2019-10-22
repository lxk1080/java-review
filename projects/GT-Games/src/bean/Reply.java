package bean;

import java.util.Date;

public class Reply {
	private int rid;
	private User user;
	private int rtid;
	private String rcontents;
	private Date rtime;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getRtid() {
		return rtid;
	}
	public void setRtid(int rtid) {
		this.rtid = rtid;
	}
	public String getRcontents() {
		return rcontents;
	}
	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}
	public Date getRtime() {
		return rtime;
	}
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	
}
