package com.goodbyenote.bapdosaptlweb.pos.memo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

@Repository
public class MemoDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTestData() {
		List<MemoVO> menus = new ArrayList<MemoVO>(13);
		
        for(MemoVO m : menus){
        	sqlSession.insert("pos.insertMemo", m);	
        }
	}

	public List<MemoVO> getList(MemoVO memo) {
		return sqlSession.selectList("MemoMapper.getList",memo);
	}

	public int count(MemoVO memo) {
		return (Integer)sqlSession.selectOne("MemoMapper.count",memo);
	}

	public List<Map<String, ?>> listExcel(MemoVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(MemoVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MemoVO> detailList(MemoVO memo) {
		return null;
	}

	public MemoVO getDetailSum(MemoVO memo) {
		return (MemoVO)sqlSession.selectOne("MemoMapper.getViewData",memo);
	}

	public MemoVO view(MemoVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MemoVO> viewDtl(MemoVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	public int deleteAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemoVO viewDtlSum(MemoVO adjust) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemoVO getDetail(MemoVO menu) {
		return (MemoVO)sqlSession.selectOne("MemoMapper.getDetail",menu);

	}
}
