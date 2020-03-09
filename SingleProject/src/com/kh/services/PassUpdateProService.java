package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.persistence.PPab_memberDao;

public class PassUpdateProService implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("비밀번호 수정 프로 옴");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String user_pass = request.getParameter("user_pass");
		boolean result = memberDao.update_member_pass(user_pass, user_id);
		String Path = "";
		if (result == true) {
			Path = IBoomServices.STR_REDIRECT+"Main.gimppab?msg=member_update_success";
		}else {
			Path = IBoomServices.STR_REDIRECT+"Main.gimppab?msg=member_update_fail";
		}
		return Path;
	}

}
