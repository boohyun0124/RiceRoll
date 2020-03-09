package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.domain.PPab_memberVo;
import com.kh.persistence.PPab_memberDao;

public class PrivacyUpdateProService implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String user_pass = request.getParameter("user_pass");
		String user_name = request.getParameter("user_name");
		String user_nickname = request.getParameter("user_nickname");
		
		PPab_memberVo memberVo = new PPab_memberVo();
		memberVo.setUser_id(user_id);
		memberVo.setUser_pass(user_pass);
		memberVo.setUser_name(user_name);
		memberVo.setUser_nickname(user_nickname);
		System.out.println(memberVo);
		String Path="";
		boolean result = memberDao.update_member_info(memberVo);
		if (result == true) {
			Path = IBoomServices.STR_REDIRECT+"Main.gimppab?msg=member_update_success";
		}else {
			Path = IBoomServices.STR_REDIRECT+"Main.gimppab?msg=member_update_fail";
		}
		return Path;
	}

}
