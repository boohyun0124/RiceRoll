package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.domain.PPab_commentVo;
import com.kh.persistence.PPab_MainDao;

public class CommentWrite implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reply_text = request.getParameter("reply_text");
		int board_category_num = Integer.parseInt(request.getParameter("board_category_num"));	
		System.out.println(reply_text);
		System.out.println(board_category_num);
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		PPab_commentVo commentVo = new PPab_commentVo();
		commentVo.setBoard_category_num(board_category_num);
		commentVo.setUser_id(user_id);
		commentVo.setReply_content(reply_text);
		
		boolean result = mainDao.insertComment(commentVo);
		String data="fail";
		if (result == true) {
			data = "success";
		}
		request.setAttribute("data", data);
		return "data";
	}

}
