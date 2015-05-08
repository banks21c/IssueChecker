package com.goodbyenote.bapdosaptlweb.pos.special.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertBeforeMerge(Map mergeMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("posspecial.insertBeforeMerge", mergeMap);
	}

	public Map getBeforeMerge(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("posspecial.getBeforeMerge", parametaMap);
	}

	public void deleteBeforeMerge(Map delMergeMap) {
		// TODO Auto-generated method stub
		sqlSession.delete("posspecial.deleteBeforeMerge", delMergeMap);
	}
}
