package com.hanb.controller;

import java.io.File;
import java.io.FileOutputStream;

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
	public ModelAndView form(@RequestParam(value="no",defaultValue="0") int pno)
	{	
		ModelAndView mav = new ModelAndView();
		mav.addObject("head", "���۵��");
		
		int no = dao.getNextNo();
		
		int b_ref=no;
		// ���࿡ �����̸� �۹�ȣ�� �����ϰ� �Ѵ�.
		// ���࿡ ����̶�� �θ���� b_ref�� �����ϰ� �Ѵ�. 
		
		int b_level=0;
		int b_step=0;
		if(pno != 0)
		{
			BoardVo p= dao.getBoard(pno);
			mav.addObject("head", "����ۼ�");
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
		}
		
		mav.addObject("no", no);
		mav.addObject("b_ref", b_ref);
		mav.addObject("b_level", b_level);
		mav.addObject("b_step", b_step);
		
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(BoardVo b, HttpServletRequest request)
	{
		b.setIp(request.getRemoteAddr());
		String path = request.getRealPath("resources/upload");
		String fname = "";
		byte data[] = new byte[100];;
		try{
			MultipartFile multi  = b.getUploadFile();
			fname = multi.getOriginalFilename();
			
			if(fname != null && !fname.equals(""))
			{
				data = multi.getBytes();				
				FileOutputStream fos = new FileOutputStream(path + "/"+ fname);
				fos.write(data);				
			}
			b.setFname(fname);
			b.setFsize(data.length);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		//�̹� �޷��ִ� ��۵��� b_step�� ������Ų��.
		
		/*����,
			  no = b_ref
		 ��� 
		 	no != b_ref
		 */
		
		if( b.getNo() != b.getB_ref())
		{
			dao.updateStep(b.getB_ref(), b.getB_step() );		
			b.setB_step(b.getB_step()+1);
			b.setB_level(b.getB_level()+1);
		}
		
		dao.insertBoard(b);
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		return mav;
	}	
}







