package bean;

public class AllNote {

	private int tid;
	private String  ttopic;
	private String tcontents;
	private String sname;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private int uid;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTtopic() {
		return ttopic;
	}
	public void setTtopic(String ttopic) {
		this.ttopic = ttopic;
	}
	public String getTcontents() {
		return tcontents;
	}
	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}
}
