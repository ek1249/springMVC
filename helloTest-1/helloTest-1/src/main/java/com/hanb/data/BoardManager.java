package com.hanb.data;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanb.vo.BoardVo;

public class BoardManager {

	private static SqlSessionFactory factory;
	
	static{
		try{
			Reader reader= Resources.getResourceAsReader("com/hanb/data/sqlMapConfig.xml");
			factory= new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static List<BoardVo> list()
	{
		SqlSession session= factory.openSession();

		
		List<BoardVo> list = session.selectList("board.selectAll");
		
		session.close();
		return list;
	}
	public static BoardVo getBoard(int no)
	{
		SqlSession session= factory.openSession();
		BoardVo b= session.selectOne("board.getBoard",no);
		session.close();
		return b;
	}
	
	
	public static int insert(BoardVo b) {
		SqlSession session= factory.openSession(true);
		int re= session.insert("board.insert", b);
		session.close();
		return re;
	}
	public static int updateBoard(BoardVo b) {
		SqlSession session= factory.openSession(true);
		
		
		int re= session.update("board.update", b);
		session.close();
		return re;
	}
	
	
	
}
