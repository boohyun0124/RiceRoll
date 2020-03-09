package com.kh.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.persistence.PPab_MainDao;

public class CustomerBasketProService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		List<Map<String, Object>> list = mainDao.getBasket(user_id);
		mainDao.orderlist(list, user_id);
		return IBoomServices.STR_REDIRECT+"Main.gimppab";
	}

}
