package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_memberVo;
import com.kh.persistence.PPab_memberDao;

public class JoinProService implements IBoomServices {
	PPab_memberDao memberDao = PPab_memberDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = (String)request.getParameter("user_id");
		String user_pass = (String)request.getParameter("user_pass");
		String user_pass_check = (String)request.getParameter("user_pass_check");
		String user_name = (String)request.getParameter("user_name");
		String user_nickname = (String)request.getParameter("user_nickname");
		
		PPab_memberVo memberVo = new PPab_memberVo();
		memberVo.setUser_id(user_id);
		memberVo.setUser_pass(user_pass);
		memberVo.setUser_name(user_name);
		memberVo.setUser_nickname(user_nickname);
		
		boolean checkDupIdresult = memberDao.checkDupId(user_id);//아이디 중복 체크		
		String redirectPath = IBoomServices.STR_REDIRECT;
		
		if (checkDupIdresult == false) {
			if(user_pass.equals(user_pass_check)) {
				System.out.println("비밀번호 일치함");
				boolean result = memberDao.insertMember(memberVo);//회원가입
				if (result == true) {
					redirectPath += "Main.gimppab?msg=mem_join_success";
				}else {
					redirectPath += "join_form.gimppab?msg=mem_join_fail";
				}
			} else {
				System.out.println("비밀번호 일치 하지 않음");
				redirectPath += "join_form.gimppab?msg=mem_join_checkPass_fail";
			}
		}else {
			System.out.println("아이디 중복");
			redirectPath += "join_form.gimppab?msg=mem_join_checkDupId_fail";
		}
		
		return redirectPath;
	}

}
