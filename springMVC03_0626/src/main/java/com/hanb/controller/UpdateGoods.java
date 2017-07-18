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

import com.hanb.dao.GoodsDao;
import com.hanb.vo.GoodsVo;

@Controller
@RequestMapping("/updateGoods.do")
public class UpdateGoods {

	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(int no)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("g",dao.getGoods(no));
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVo g, HttpServletRequest request)
	{
		//수정하기 전에 원래 상품 파일명을 얻어 온다. 
		String oldFname = g.getFname();
		
		ModelAndView mav= new ModelAndView("redirect:/listGoods.do");
		
		String path= request.getRealPath("resources/img");
		System.out.println("path : " + path);
		
		MultipartFile mfile= g.getUploadFile();
		String fname="";
		if(mfile !=null)
		{
			fname= mfile.getOriginalFilename();
		}
		g.setFname(oldFname);
		if(!fname.equals(""))
		{
			g.setFname(fname); 
			try{
			byte[]data = mfile.getBytes();
			FileOutputStream fos= new FileOutputStream(path +"/" +fname);
					fos.write(data);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		int re = dao.update(g);	
		if(re==1 && !oldFname.equals("") && !fname.equals("")){
			File file = new File(path +"/"+oldFname);
			file.delete();
		}
		return mav;
		
	}
}
