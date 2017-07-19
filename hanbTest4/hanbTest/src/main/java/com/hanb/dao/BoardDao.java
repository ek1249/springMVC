package com.hanb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanb.data.BoardManager;
import com.hanb.vo.BoardVo;

@Repository
public class BoardDao {
	
	//�� ȭ�鿡 ������ �Խù��� ��
	public static int pageSIZE= 10;
	
	//��ü ���ڵ�� 
	public static int totalRecord;
	
	//��ü ��������
	public static int totalPage;
	
	//�� ȭ�鿡 ������ ��������
	public static int pageGRUOP=3;
	
	

	public int getNextNo()
	{
		return BoardManager.getNextNo();
	}
	
	public int getTotal(String searchFeild, String keyword)
	{
		return BoardManager.getTotal(searchFeild, keyword);
	}
	
	public BoardVo getBoard(int no)
	{
		return BoardManager.getBoard(no);
	}
	
	
	public String getPageStr(int pageNUM, String searchFeild, String keyword)
	{
		// ���� �������� ���� ������������ �������������� ����Ѵ�.
		// ��ȭ�鿡 ������ ���������� 5
		// ������������ 1,2,3,4,5 ��� start = 1, end 5
		// ������������ 6,7,8,9,10 ��� start = 6, end 10
		                             
		//int start = (int) Math.ceil((pageNUM-1) /(double)pageGRUOP)*pageGRUOP+1;		
		//int start = (pageNUM + pageGRUOP-1) / pageGRUOP * pageGRUOP - (pageGRUOP-1);		
		int start = 
		(pageNUM + pageGRUOP-1) / pageGRUOP * pageGRUOP - (pageGRUOP-1);				
		
		int end = start+pageGRUOP-1;
		
		if(end > totalPage)
			end = totalPage;
		
		System.out.println("pageNUM:"+pageNUM);
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		
		String str = "";
		
		if( start > pageGRUOP  )
		{
			str = str + "<a href='listBoard.do?pageNUM="+(start-1)+"'>[����]</a>&nbsp;";
		}
		
		
		for(int i=start; i<= end; i++)
		{
			str = str + "<a href='listBoard.do?pageNUM="+i+"'>"+ i + "</a>&nbsp;";
		}
		
		if( end < totalPage  )
		{
			str = str + "<a href='listBoard.do?pageNUM="+(end+1)+"'>[����]</a>&nbsp;";
		}
		
		return str;
	}
	
	
	
	public List<BoardVo> list(int start, int end, String searchFeild, String keyword)
	{
		totalRecord= getTotal(searchFeild, keyword);
		totalPage = (int)Math.ceil((double)totalRecord/pageSIZE);
		System.out.println("totalRecord:"+ totalRecord);
		System.out.println("totalPage:"+ totalPage);
		return BoardManager.list(start,end,searchFeild,keyword);
	}
	
	public int insertBoard(BoardVo b)
	{
		return BoardManager.insertBoard(b);
	}
	
	public int updateHit(int no)
	{
		return BoardManager.updateHit(no);
	}

	public int updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub
		return BoardManager.updateStep(b_ref, b_step);
	}
}
