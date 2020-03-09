package com.kh.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.domain.PPab_commentVo;
import com.kh.persistence.PPab_MainDao;

public class BoardCommentList implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기옴");
		int board_category_num = Integer.parseInt(request.getParameter("board_category_num"));
		System.out.println("board_category_num : " +board_category_num);
		List<PPab_commentVo> list = mainDao.getCommentList(board_category_num);
		
		JSONArray jsonArray = new JSONArray();
		for (PPab_commentVo commentVo : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("board_reply_num", commentVo.getBoard_reply_num());
			jsonObject.put("board_category_num", board_category_num);
			jsonObject.put("user_id", commentVo.getUser_id());
			jsonObject.put("reply_reg_date", commentVo.getReply_reg_date().toString());
			jsonObject.put("reply_content", commentVo.getReply_content());
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray.toJSONString());
		request.setAttribute("data", jsonArray.toJSONString());
		return "data";
	}

}
