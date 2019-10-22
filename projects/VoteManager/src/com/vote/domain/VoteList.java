package com.vote.domain;

public class VoteList {
	private int id;
	private String type;
	private String title;
	private String desc;
	private String img;
	private String choose;
	private String pattern;
	private String peopleNum;
	private String pubDate;
	private String expireDate;
	private String votedNum;
	
	public VoteList() {
		super();
	}
	public VoteList(int id, String type, String title, String desc, String img,
			String choose, String pattern, String peopleNum, String pubDate,
			String expireDate, String votedNum) {
		super();
		this.id = id;
		this.type = type;
		this.title = title;
		this.desc = desc;
		this.img = img;
		this.choose = choose;
		this.pattern = pattern;
		this.peopleNum = peopleNum;
		this.pubDate = pubDate;
		this.expireDate = expireDate;
		this.votedNum = votedNum;
	}
	
	@Override // 把choose pattern 和 peopleNum 的转义双引号删除
	public String toString() {
		return "{\"id\":\"" + id + "\",\"type\":\"" + type + "\",\"title\":\""
				+ title + "\",\"desc\":\"" + desc + "\",\"img\":\"" + img
				+ "\",\"choose\":" + choose + ",\"pattern\":" + pattern
				+ ",\"peopleNum\":" + peopleNum + ",\"pubDate\":\""
				+ pubDate + "\",\"expireDate\":\"" + expireDate + "\",\"votedNum\":\"" + votedNum + "\"}  ";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getVotedNum() {
		return votedNum;
	}
	public void setVotedNum(String votedNum) {
		this.votedNum = votedNum;
	}
	
}
