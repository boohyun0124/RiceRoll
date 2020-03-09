package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.domain.PPab_loginDto;
import com.kh.domain.PPab_memberVo;
import com.kh.persistence.PPab_memberDao;

public class LoginProService implements IBoomServices {
	private PPab_memberDao memberDao = PPab_memberDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		
		PPab_loginDto loginDto = new PPab_loginDto(user_id, user_pass);
		boolean result = memberDao.checkMember(loginDto);
		
		PPab_memberVo memberVo = memberDao.infoMember(user_id);
		String user_nickname = memberVo.getUser_nickname();
		
		String redirectPath = IBoomServices.STR_REDIRECT;
		if (result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_nickname", user_nickname);
			redirectPath += "Main.gimppab?msg=login_success";
		}else {
			redirectPath += "login_form.gimppab?msg=login_fail";
		}
		
		return redirectPath;
	}

}
