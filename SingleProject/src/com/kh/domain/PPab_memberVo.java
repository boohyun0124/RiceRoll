package com.kh.domain;

public class PPab_memberVo {
	private String user_id;
	private String user_pass;
	private String user_name;
	private String user_nickname;
	private int user_money;
	public PPab_memberVo() {
		super();
	}
	public PPab_memberVo(String user_id, String user_pass, String user_name, String user_nickname, int user_money) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_money = user_money;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		char ch = user_id.charAt(0);
		if ('a' <= ch && ch <= 'z' && user_id.length() <= 20) {
			this.user_id = user_id;
		}	
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getUser_money() {
		return user_money;
	}
	public void setUser_money(int user_money) {
		this.user_money = user_money;
	}
	@Override
	public String toString() {
		return "PPab_memberVo [user_id=" + user_id + ", user_pass=" + user_pass + ", user_name=" + user_name
				+ ", user_nickname=" + user_nickname + ", user_money=" + user_money + "]";
	}
}
