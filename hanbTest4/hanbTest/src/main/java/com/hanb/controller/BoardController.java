package com.hanb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.BoardDao;

@Controller
public class BoardController {

	@Autowired
	private BoardDao dao;
		
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView list(String searchFeild, String keyword,  HttpServletRequest request, 
				@RequestParam(value="pageNUM",defaultValue="1") int pageNUM)
	
	{
		//������������ ���� ���۷��ڵ��� ��ġ�� ������ ���ڵ��� ��ġ�� ���
		int start, end;
		
		//��ü���ڵ��� ���� 24
		//��ȭ�鿡 ������ ���ڵ��� �� 10
		//���� �������� 1
		//start = 1			end 10
		
		//���� �������� 2
		//start = 11		end 20
		
		start = (pageNUM-1) * BoardDao.pageSIZE + 1;
		end = start+ BoardDao.pageSIZE-1;		 
				
		
		
		
		String path = request.getRealPath("resources/upload");
		System.out.println("path:"+path);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.list(start, end,searchFeild,keyword));
		mav.addObject("pageStr", dao.getPageStr(pageNUM, searchFeild, keyword));
			
		
		return mav;
	}
	
	@RequestMapping("/detailBoard.do")
	public ModelAndView getBoard(int no)
	{			
		ModelAndView mav = new ModelAndView();
		dao.updateHit(no);
		mav.addObject("b", dao.getBoard(no));
		return mav;
	}
}








