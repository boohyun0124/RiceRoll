package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.domain.PPab_loginDto;
import com.kh.domain.PPab_memberVo;
import com.kh.persistence.PPab_memberDao;

public class PassUpdateFormService implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String user_pass = request.getParameter("user_pass");
		
		PPab_memberVo memberVo = memberDao.infoMember(user_id);
		
		PPab_loginDto dto = new PPab_loginDto(user_id, user_pass);
		boolean result = memberDao.checkMember(dto);
		String Path = "";
		if (result == true) {
			request.setAttribute("memberVo", memberVo);
			Path = "PPabPass";
		}else {
			Path = IBoomServices.STR_REDIRECT + "Main.gimppab?msg=pass_fail";
		}
		return Path;
	}

}
