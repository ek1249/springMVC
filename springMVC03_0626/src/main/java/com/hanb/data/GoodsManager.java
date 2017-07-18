package com.hanb.data;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanb.vo.GoodsVo;

public class GoodsManager {
	
	
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
	
	public static List<GoodsVo> list()
	{
		SqlSession session= factory.openSession();
		List<GoodsVo> list= session.selectList("goods.selectAll");
		session.close();
		return list;
	}

	public static GoodsVo getGoods(int no) {
		SqlSession session= factory.openSession();
		
		GoodsVo g= session.selectOne("goods.selectOne", no);
		return g;
	}

	public static int insert(GoodsVo g) {
		SqlSession session= factory.openSession(true);
		
		int re=session.insert("goods.insert",g);
		session.close();
		return re;
		
	}
	
	public static int update(GoodsVo g) {
		SqlSession session= factory.openSession(true);
		
		int re=session.update("goods.updateGoods",g);
		session.close();
		return re;
		
	}
}
