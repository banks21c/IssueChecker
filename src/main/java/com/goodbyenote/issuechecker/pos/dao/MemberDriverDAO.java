package com.goodbyenote.issuechecker.pos.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.pos.model.MemberDriverVO;

@Repository
public class MemberDriverDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTestData() {
		Date date = new Date();
		
		MemberDriverVO member1 = new MemberDriverVO();
		member1.MemberDriverId = 1;
        member1.Name = "이배달";
        member1.PhoneNumber = "010456789AB";
        member1.CreationDate = date;
        member1.ModificationDate = date;
        sqlSession.insert("pos.insertMember", member1);

        member1.MemberDriverId = 2;
        member1.Name = "김배달";
        member1.PhoneNumber = "010456789AB";
        member1.CreationDate = date;
        member1.ModificationDate = date;
        sqlSession.insert("pos.insertMember", member1);
	}
}
