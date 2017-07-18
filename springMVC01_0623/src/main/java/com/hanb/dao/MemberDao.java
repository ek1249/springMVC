package com.hanb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanb.data.MemberManager;
import com.hanb.vo.MemberVo;

@Repository
public class MemberDao {
	
	
	public List<MemberVo> list(){
		return MemberManager.list();
	}
}
