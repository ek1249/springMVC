package com.hanb.controller;


import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanb.dao.BoardDao;
import com.hanb.vo.BoardVo;

@Controller
@RequestMapping("/updateBoard.do")
public class UpdateBoardController {

	@Autowired
	BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView updateForm(int no)
	{
		ModelAndView mav= new ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		
		return mav;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVo b, HttpServletRequest request)
	{
		ModelAndView mav= new ModelAndView("redirect:/listBoard.do");
		
		String ip= request.getRemoteAddr();
		b.setIp(ip);
		String path=request.getRealPath("resources/upload");
		System.out.println("path : "+ path);
		
		BoardVo p= dao.getBoard(b.getNo());
		String oldFname=p.getFname();
		
		
		 
		String fname="";
		MultipartFile mfile=b.getUploadFile();
		if(mfile!=null)
		{
			fname= mfile.getOriginalFilename();			
		}
			b.setFname(oldFname);			
		
		if(!fname.equals(""))
		{
			b.setFname(fname);
			try{
				
				byte[] data=mfile.getBytes();
				FileOutputStream fos= new FileOutputStream(path+"/"+fname);
				fos.write(data);
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		int re= dao.updateBoard(b);
		
		//if(re==1 && mfile!=null && !mfile.equals(""))
		if(re==1 && !oldFname.equals("") && !fname.equals(""))
		{
			File file= new File(path+"/"+oldFname);
			file.delete();
			System.out.println("기존사진 :"+oldFname);
			System.out.println("새사진 :"+fname);
		}
		
		return mav;
	}
}
