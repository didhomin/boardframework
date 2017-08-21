package com.kitri.admin.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.admin.board.model.BoardListDto;
import com.kitri.admin.board.service.BoardAdminService;

@Controller
@RequestMapping("/boardadmin")
public class BoardAdminController {
	
	@Autowired
	private BoardAdminService boardAdminService;
	
	@RequestMapping("boardmenu.html")
	public ModelAndView boardmenu() {
		
		ModelAndView mav = new ModelAndView();
		List<BoardListDto> list =boardAdminService.boardList();
		mav.addObject("boardmenu",list);
		mav.setViewName("/admin/boardmenu");
		return mav;
	}
}
