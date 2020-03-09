package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsFormService implements IBoomServices {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "PPabNews";
	}

}
