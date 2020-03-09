package com.kh.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoomServices {
	public static String STR_REDIRECT = "redirect:";
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
