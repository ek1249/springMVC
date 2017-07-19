package com.hanb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.BoardDao;
import com.hanb.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView list()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",dao.list());
		
		return mav;
	}
	
	@RequestMapping("/detailBoard.do")
	public ModelAndView detail(int no)
	{
		ModelAndView mav= new ModelAndView();
		
		mav.addObject("b", dao.getBoard(no));
		
		return mav;
	}
}
