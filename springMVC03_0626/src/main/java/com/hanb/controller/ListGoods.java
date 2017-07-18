package com.hanb.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.GoodsDao;
import com.hanb.vo.GoodsVo;

@Controller
public class ListGoods {

	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView list()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("title","상품목록");
		mav.addObject("list",dao.list());
		return mav;
	}
	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(int no)
	{
		ModelAndView mav= new ModelAndView();
			mav.addObject("g",dao.getGoods(no));
		return mav;
	}
	
	/*@RequestMapping("/deleteGoods.do")
	public ModelAndView delete(HttpServletRequest request,int no){
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		String oldFname = dao.getGoods(no).getFname();
		
		int re = dao.delete(no);
		if(re!=1 && oldFname.equals("")){
			File file = new File(path+"/"+oldFname);
			file.delete();
		}
		return mav;
	}*/
}
