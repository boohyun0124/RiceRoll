package com.kh.services;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.domain.PPab_boardVo;
import com.kh.persistence.PPab_MainDao;
import com.kh.util.FileUploader;
import com.oreilly.servlet.MultipartRequest;

public class CustomerContentUpdateProService implements IBoomServices {
	PPab_MainDao mainDao = PPab_MainDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartRequest multi = FileUploader.upload(request);
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		int board_category_num = Integer.parseInt(multi.getParameter("board_category_num"));
		String menu_code = "C2";
		
		Enumeration<?> enumer = multi.getFileNames();
		String E_filename = (String)enumer.nextElement();
		String board_images = multi.getFilesystemName(E_filename);
		
		PPab_boardVo boardVo = new PPab_boardVo();
		boardVo.setBoard_category_num(board_category_num);
		boardVo.setBoard_subject(subject);
		boardVo.setBoard_content(content);
		boardVo.setMenu_code(menu_code);
		boardVo.setBoard_images(board_images);
		
		mainDao.updateCustomerBoardContent(boardVo);
		
		return IBoomServices.STR_REDIRECT+"customer_board_form.gimppab";
	}

}
