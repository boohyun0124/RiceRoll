package com.kh.domain;

import java.sql.Timestamp;

public class PPab_boardVo {
	private int board_num;
	private int board_category_num;
	private String user_id;
	private String board_content;
	private String board_images;
	private int board_read_count;
	private String menu_code;
	private int board_reply_count;
	private Timestamp board_reg_date;
	private String board_subject;
	public PPab_boardVo() {
		super();
	}
	public PPab_boardVo(int board_num, int board_category_num, String user_id, String board_content,
			String board_images, int board_read_count, String menu_code, int board_reply_count,
			Timestamp board_reg_date, String board_subject) {
		super();
		this.board_num = board_num;
		this.board_category_num = board_category_num;
		this.user_id = user_id;
		this.board_content = board_content;
		this.board_images = board_images;
		this.board_read_count = board_read_count;
		this.menu_code = menu_code;
		this.board_reply_count = board_reply_count;
		this.board_reg_date = board_reg_date;
		this.board_subject = board_subject;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_images() {
		return board_images;
	}
	public void setBoard_images(String board_images) {
		this.board_images = board_images;
	}
	public int getBoard_read_count() {
		return board_read_count;
	}
	public void setBoard_read_count(int board_read_count) {
		this.board_read_count = board_read_count;
	}
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public int getBoard_reply_count() {
		return board_reply_count;
	}
	public void setBoard_reply_count(int board_reply_count) {
		this.board_reply_count = board_reply_count;
	}
	public Timestamp getBoard_reg_date() {
		return board_reg_date;
	}
	public void setBoard_reg_date(Timestamp board_reg_date) {
		this.board_reg_date = board_reg_date;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	@Override
	public String toString() {
		return "PPab_boardVo [board_num=" + board_num + ", board_category_num=" + board_category_num + ", user_id="
				+ user_id + ", board_content=" + board_content + ", board_images=" + board_images
				+ ", board_read_count=" + board_read_count + ", menu_code=" + menu_code + ", board_reply_count="
				+ board_reply_count + ", board_reg_date=" + board_reg_date + ", board_subject=" + board_subject + "]";
	}
	
}
