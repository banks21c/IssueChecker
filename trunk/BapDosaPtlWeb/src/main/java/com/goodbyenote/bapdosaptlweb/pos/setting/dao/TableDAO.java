package com.goodbyenote.bapdosaptlweb.pos.setting.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TableDAO {
	@Autowired
	private SqlSession sqlSession;
}
