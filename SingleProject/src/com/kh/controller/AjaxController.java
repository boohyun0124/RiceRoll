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

@WebServlet("*.Ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<>();
    
    public AjaxController() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
		loadProperties();
	}
	private void loadProperties() {
		ResourceBundle bundle =  ResourceBundle.getBundle(
				"com.kh.properties.AjaxCommand");
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements() == true) {
			String command = keys.nextElement(); // list
			String className = bundle.getString(command); // com.kh.service.BoardList
			try {
				Class<?> commandClass = Class.forName(className);
				Object obj = commandClass.newInstance();
				commandMap.put(command, obj);
				// -> new BoardList()
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("commandMap: " + commandMap);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request);
		System.out.println("command:" + command);
		IBoomServices service = (IBoomServices)commandMap.get(command);
		
		try {
			String page = service.execute(request, response);
			if (page.startsWith(IBoomServices.STR_REDIRECT)) {
				String redirectPage = page.substring(
						IBoomServices.STR_REDIRECT.length());
				response.sendRedirect(redirectPage);
				// -> response.sendRedirect("list.board")
			} else {
				String forwardPage = "/WEB-INF/views/jsp/" + page + ".jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getCommand(HttpServletRequest request) {
		String uri = request.getRequestURI(); // /MVC/list.board
		String contextPath = request.getContextPath(); // /MVC
		int beginIndex = contextPath.length() + 1;
		int endIndex = uri.lastIndexOf(".");
		String command = uri.substring(beginIndex, endIndex);
//		System.out.println("uri: " + uri);
//		System.out.println("contextPath: " + contextPath);
//		System.out.println("command: " + command);
		return command;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
