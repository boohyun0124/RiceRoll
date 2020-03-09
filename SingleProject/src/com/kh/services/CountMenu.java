package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CountMenu implements IBoomServices {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String count = request.getParameter("count");
		String price = request.getParameter("price");
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		jsonObject.put("price", price);
		jsonArray.add(jsonObject);
		
		String data = jsonArray.toJSONString();
		request.setAttribute("data", data);
		return "data";
	}

}
