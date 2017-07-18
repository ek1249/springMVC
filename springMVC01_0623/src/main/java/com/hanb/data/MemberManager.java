package com.hanb.data;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanb.vo.MemberVo;

public class MemberManager {
	private static SqlSessionFactory factory;
	
	static{
		try{
			Reader reader = Resources.getResourceAsReader("com/hanb/data/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e){System.out.println(e.getMessage());}
		
	}
	
	public static List<MemberVo> list(){
		List<MemberVo> list = null;
		SqlSession session = factory.openSession(); //sql의 statement와 같은 역할
		list = session.selectList("member.selectAll");
		session.close();
		return list;
	}
	
}
