package com.kh.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_boardVo;
import com.kh.persistence.PPab_MainDao;

public class CustomerBoardFormService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PPab_boardVo> list = mainDao.getList();
		request.setAttribute("list", list);
		return "PPabCustomerBoard";
	}

}
