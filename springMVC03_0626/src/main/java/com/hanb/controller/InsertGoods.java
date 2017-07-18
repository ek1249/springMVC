package com.hanb.controller;

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
@RequestMapping("/insertGoods.do")
public class InsertGoods {

	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public void form()
	{}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVo g, HttpServletRequest request)
	{
		ModelAndView mav= new ModelAndView("redirect:/listGoods.do");
		
		String path= request.getRealPath("resources/img");
		System.out.println("path : " + path);
		
		MultipartFile mfile= g.getUploadFile();
		String fname="";
		if(mfile !=null)
		{
			fname= mfile.getOriginalFilename();
		}
		g.setFname(fname);
		if(!fname.equals(""))
		{
			try{
			byte[]data = mfile.getBytes();
			FileOutputStream fos= new FileOutputStream(path +"/" +fname);
					fos.write(data);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		dao.insert(g);		
		return mav;
		
	}
}
