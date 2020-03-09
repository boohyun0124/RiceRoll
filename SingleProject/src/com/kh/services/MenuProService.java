package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.persistence.PPab_MainDao;

public class MenuProService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String menu_code = request.getParameter("menu_code");
		String count = request.getParameter("count");
		String price = request.getParameter("price");
		int menu_count = Integer.parseInt(count);
		int menu_price = Integer.parseInt(price);
		
		boolean result = mainDao.insertBasket(user_id, menu_code, menu_price, menu_count);
		System.out.println(result);
		
		return IBoomServices.STR_REDIRECT+"customer_basket_form.gimppab";
	}
}
