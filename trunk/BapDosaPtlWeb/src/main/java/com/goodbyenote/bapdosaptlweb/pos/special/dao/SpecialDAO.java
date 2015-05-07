package com.goodbyenote.bapdosaptlweb.pos.special.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialDAO {
	@Autowired
	private SqlSession sqlSession;
}
