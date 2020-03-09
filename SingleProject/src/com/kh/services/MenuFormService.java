package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_menuVo;
import com.kh.persistence.PPab_MainDao;

public class MenuFormService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String menu = request.getParameter("menu");
		PPab_menuVo menuVo= mainDao.getInfoGimppab(menu);
		request.setAttribute("menuVo", menuVo);
		return "PPabMenu";
	}

}
