package com.sinc.beez.att.dao;

import java.util.HashMap;
import java.util.List;

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
		
		return session.selectOne(ATTPREFIX + "arrival", obj);
	}

	
	@Override
	public List<Object> attListRow(Object obj) {
		
		return session.selectList(ATTPREFIX + "list", obj);
	}

	
}
