package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.persistence.PPab_memberDao;

public class UserCheckId implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		boolean result = memberDao.checkDupId(user_id);
		String data = "";
		if (result == true) {
			data = "used_id";
		}else {
			data = "available_id";
		}
		request.setAttribute("data", data);
		return "data";
	}

}
