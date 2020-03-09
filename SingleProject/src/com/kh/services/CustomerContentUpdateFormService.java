package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_boardVo;
import com.kh.persistence.PPab_MainDao;

public class CustomerContentUpdateFormService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_category_num = Integer.parseInt(request.getParameter("board_category_num"));
		String menu_code = "C2";
		PPab_boardVo boardVo = mainDao.getContent(board_category_num, menu_code);
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("board_category_num", board_category_num);
		return "PPabContentUpdate";
	}

}
