package com.kh.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;

import com.kh.persistence.PPab_MainDao;

public class OrderDelete implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String order_nums = request.getParameter("order_nums");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		Map<String, Object> paramMap = new HashedMap<>();
		paramMap.put("order_nums", order_nums);
		paramMap.put("user_id", user_id);
		
		boolean result = mainDao.basket_partial_delete(paramMap);
		String data = "fail";
		if (result == true) {
			data = "success";
		}
		request.setAttribute("data", data);
		return "data";
	}

}
