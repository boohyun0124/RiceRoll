package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPassFormService implements IBoomServices {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getParameter("path");
		request.setAttribute("path", path);
		return "PPabCheckPass";
	}

}
