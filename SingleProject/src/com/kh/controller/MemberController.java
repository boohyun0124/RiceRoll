package com.kh.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.services.IBoomServices;

@WebServlet("*.PPabMember")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Map<String, Object> commandMap = new HashMap<>();
    public MemberController() {
        super();
    }
    
    public void init() throws ServletException {
    	super.init();
    	loadProperties();
    }
	private void loadProperties() {
		ResourceBundle bundle = ResourceBundle.getBundle("com.kh.properties.Membercommand");
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements()) {
			String commandName = keys.nextElement();
			String className = bundle.getString(commandName);
			try {
				Class<?> commandClass = Class.forName(className);
				Object obj = commandClass.newInstance();
				commandMap.put(commandName, (IBoomServices)obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("commandMap:" + commandMap);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		System.out.println("command : "+command);
		IBoomServices services = (IBoomServices)commandMap.get(command);
		try {
			String page = services.execute(request, response);
			if (page.startsWith(IBoomServices.STR_REDIRECT)) {
				String redirectPage = page.substring(IBoomServices.STR_REDIRECT.length());
				response.sendRedirect(redirectPage);
			} else {
				String forwardPage = "/WEB-INF/views/jsp/"+page+".jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);
				dispatcher.forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int beginIndex = contextPath.length() + 1;
		int endIndex = uri.lastIndexOf(".");
		String command = uri.substring(beginIndex, endIndex);
		return command;
	}
}
