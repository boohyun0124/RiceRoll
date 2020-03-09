package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.persistence.PPab_MainDao;

public class CustomerContentDeleteFormService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_category_num = Integer.parseInt(request.getParameter("board_category_num"));
		String menu_code = "C2";
		mainDao.deleteCustomerBoardContent(board_category_num, menu_code);	
		return IBoomServices.STR_REDIRECT + "customer_board_form.gimppab";
	}

}
