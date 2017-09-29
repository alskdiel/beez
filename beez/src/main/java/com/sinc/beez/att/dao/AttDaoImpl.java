package com.sinc.beez.att.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("attDao")
public class AttDaoImpl implements AttDao {
	private final static String ATTPREFIX="com.sinc.beez.mapper.att.";

	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public Object attArivalRow(Object obj) {
		System.out.println("AttrDao userAttArivalRow");
		
		return session.selectOne(ATTPREFIX + "arrival", obj);
	}

}
