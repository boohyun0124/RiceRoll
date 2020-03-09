package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutProService implements IBoomServices {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return IBoomServices.STR_REDIRECT + "Main.gimppab?msg=logout_success";
	}

}
