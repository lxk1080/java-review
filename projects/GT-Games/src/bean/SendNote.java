package bean;

import java.util.Date;

public class SendNote {
private String tid;
private String ttopic;
private int tuid;
private int tsid;
public int getTsid() {
	return tsid;
}
public void setTsid(int tsid) {
	this.tsid = tsid;
}
public int getTuid() {
	return tuid;
}
public void setTuid(int tuid) {
	this.tuid = tuid;
}
public Date getTtime() {
	return ttime;
}
public void setTtime(Date ttime) {
	this.ttime = ttime;
}
private Date ttime;
public String getTid() {
	return tid;
}
public void setTid(String tid) {
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
private String tcontents;
}
