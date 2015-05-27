package com.goodbyenote.issuechecker.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.common.model.CommonCodeVO;
import com.goodbyenote.issuechecker.common.model.ExceptionVO;
import com.goodbyenote.issuechecker.common.model.MenuVO;

@Repository
public class CommonDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<CommonCodeVO> getCommonCodeList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("common.getCommonCodeList");
	}


	public List<CommonCodeVO> getCommonCodeParents() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("common.getCommonCodeParents");
	}


	public void insertExceptionLog(ExceptionVO exceptionVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("common.insertExceptionLog", exceptionVO);
	}

}
