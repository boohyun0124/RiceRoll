package com.kh.services;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.domain.PPab_boardVo;
import com.kh.persistence.PPab_MainDao;
import com.kh.util.FileUploader;
import com.oreilly.servlet.MultipartRequest;

public class CustomerWriteProService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartRequest multi = FileUploader.upload(request);
		String subject = multi.getParameter("subjcet");
		String content = multi.getParameter("content");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		Enumeration<?> enumer = multi.getFileNames();
		String E_filename = (String)enumer.nextElement();
		String board_images = multi.getFilesystemName(E_filename);
		
		PPab_boardVo boardVo = new PPab_boardVo();
		boardVo.setUser_id(user_id);
		boardVo.setBoard_subject(subject);
		boardVo.setBoard_content(content);
		boardVo.setBoard_images(board_images);
		
		mainDao.write(boardVo);
		return IBoomServices.STR_REDIRECT+"customer_board_form.gimppab";
	}

}
