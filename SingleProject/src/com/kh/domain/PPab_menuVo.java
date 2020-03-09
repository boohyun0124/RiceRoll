package com.kh.domain;

public class PPab_menuVo {
	private String menu_code;
	private String menu_desc;
	private int menu_price;
	public PPab_menuVo() {
		super();
	}
	public PPab_menuVo(String menu_code, String menu_desc, int menu_price) {
		super();
		this.menu_code = menu_code;
		this.menu_desc = menu_desc;
		this.menu_price = menu_price;
	}
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public String getMenu_desc() {
		return menu_desc;
	}
	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	@Override
	public String toString() {
		return "PPab_menuVo [menu_code=" + menu_code + ", menu_desc=" + menu_desc + ", menu_price=" + menu_price + "]";
	}
	
}
