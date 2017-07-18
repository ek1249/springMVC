package com.hanb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanb.data.GoodsManager;
import com.hanb.vo.GoodsVo;

@Repository
public class GoodsDao {
	
	public List<GoodsVo> list()
	{
		return GoodsManager.list();
	}

	public GoodsVo getGoods(int no) {

		return GoodsManager.getGoods(no);
	}

	public int insert(GoodsVo g) {
		 return GoodsManager.insert(g);
	}
	
	public int update(GoodsVo g) {
		 return GoodsManager.update(g);
	}
}
