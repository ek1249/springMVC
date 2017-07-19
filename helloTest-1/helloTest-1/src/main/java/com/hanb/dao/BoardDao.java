package com.hanb.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanb.data.BoardManager;
import com.hanb.vo.BoardVo;

@Repository
public class BoardDao {

	
	public List<BoardVo> list()
	{
		return BoardManager.list();
	}

	public int insert(BoardVo b) {
		return BoardManager.insert(b);
	}
	
	public BoardVo getBoard(int no)
	{
		return BoardManager.getBoard(no);
	}

	public int updateBoard(BoardVo b) {
		return BoardManager.updateBoard(b);
		
	}
	
	

}
