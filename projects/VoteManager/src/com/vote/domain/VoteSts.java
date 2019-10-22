package com.vote.domain;

public class VoteSts {
	private int id;
	private String vote_id;
	private String vote_title;
	private String vote_man;
	private String vote_choose;
	private String vote_date;
	
	public VoteSts() {
		super();
	}
	public VoteSts(int id, String vote_id, String vote_title, String vote_man, String vote_choose, String vote_date) {
		super();
		this.id = id;
		this.vote_id = vote_id;
		this.vote_title = vote_title;
		this.vote_man = vote_man;
		this.vote_choose = vote_choose;
		this.vote_date = vote_date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVote_id() {
		return vote_id;
	}
	public void setVote_id(String vote_id) {
		this.vote_id = vote_id;
	}
	public String getVote_title() {
		return vote_title;
	}
	public void setVote_title(String vote_title) {
		this.vote_title = vote_title;
	}
	public String getVote_man() {
		return vote_man;
	}
	public void setVote_man(String vote_man) {
		this.vote_man = vote_man;
	}
	public String getVote_choose() {
		return vote_choose;
	}
	public void setVote_choose(String vote_choose) {
		this.vote_choose = vote_choose;
	}
	public String getVote_date() {
		return vote_date;
	}
	public void setVote_date(String vote_date) {
		this.vote_date = vote_date;
	}
	
}
