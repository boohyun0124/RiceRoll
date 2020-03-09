package com.kh.domain;

import java.sql.Timestamp;

public class PPab_commentVo {
	private int board_reply_num;
	private int board_category_num;
	private String user_id;
	private Timestamp reply_reg_date;
	private String reply_content;
	public PPab_commentVo() {
		super();
	}
	public PPab_commentVo(int board_reply_num, int board_category_num, String user_id, Timestamp reply_reg_date,
			String reply_content) {
		super();
		this.board_reply_num = board_reply_num;
		this.board_category_num = board_category_num;
		this.user_id = user_id;
		this.reply_reg_date = reply_reg_date;
		this.reply_content = reply_content;
	}
	public int getBoard_reply_num() {
		return board_reply_num;
	}
	public void setBoard_reply_num(int board_reply_num) {
		this.board_reply_num = board_reply_num;
	}
	public int getBoard_category_num() {
		return board_category_num;
	}
	public void setBoard_category_num(int board_category_num) {
		this.board_category_num = board_category_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getReply_reg_date() {
		return reply_reg_date;
	}
	public void setReply_reg_date(Timestamp reply_reg_date) {
		this.reply_reg_date = reply_reg_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	@Override
	public String toString() {
		return "PPab_commentVo [board_reply_num=" + board_reply_num + ", board_category_num=" + board_category_num
				+ ", user_id=" + user_id + ", reply_reg_date=" + reply_reg_date + ", reply_content=" + reply_content
				+ "]";
	}
}
