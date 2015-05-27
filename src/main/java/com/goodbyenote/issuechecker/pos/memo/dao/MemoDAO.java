package com.goodbyenote.issuechecker.pos.memo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.pos.model.MemoVO;

@Repository
public class MemoDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertMemo(Map customerRequestMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("posmemo.insertMemo", customerRequestMap);
	}

	public void deleteMemo(Map delMap) {
		// TODO Auto-generated method stub
		sqlSession.update("posmemo.deleteMemo", delMap);
	}

	public List<Map> getMemoList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("posmemo.getMemoList", parametaMap);
	}




}
