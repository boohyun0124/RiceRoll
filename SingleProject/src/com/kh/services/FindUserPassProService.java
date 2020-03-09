package com.kh.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_memberVo;
import com.kh.persistence.PPab_memberDao;

public class FindUserPassProService implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("비밀번호 찾기");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nickname = request.getParameter("user_nickname");
		
		PPab_memberVo memberVo = new PPab_memberVo();
		memberVo.setUser_id(user_id);
		memberVo.setUser_name(user_name);
		memberVo.setUser_nickname(user_nickname);
		
		List<PPab_memberVo> list = memberDao.find_user_pass(memberVo);
		request.setAttribute("list", list);
		return "PPabFindResultPass";
	}

}
