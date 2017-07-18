package com.hanb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao dao;

	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listMember.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "ȸ�����");
		mav.addObject("list", dao.list());
		
		return mav;
	}
}
