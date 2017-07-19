package com.hanb.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.BoardDao;
import com.hanb.vo.BoardVo;

@Controller
@RequestMapping("/insertBoard.do")
public class InsertBoardController {

	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView insertForm()
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("head", "새글작성");
		
		
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVo b,HttpServletRequest request)
	{
		ModelAndView mav= new ModelAndView("redirect:/listBoard.do");
		
		String ip= request.getRemoteAddr();
		b.setIp(ip);
		
		String path=request.getRealPath("resources/upload");
		System.out.println("path : "+ path);
		MultipartFile mfile=b.getUploadFile();
		
		String fname="";
		if(mfile!=null)
		{
			fname=mfile.getOriginalFilename();
		}
		b.setFname(fname);
		if(fname!=null && !fname.equals(""))
		{
			try{
				byte[] data=mfile.getBytes();
				FileOutputStream fos= new FileOutputStream(path+"/"+fname);
				fos.write(data);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		dao.insert(b);
		
		
		return mav;
	}
}
