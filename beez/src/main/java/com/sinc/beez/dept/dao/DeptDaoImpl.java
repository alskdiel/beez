package com.sinc.beez.dept.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
	
	private final static String DEPTPREFIX="com.sinc.beez.mapper.dept.";

	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public Object deptRow(Object obj) {
		System.out.println("DeptDao deptRow");
		
		return session.selectOne(DEPTPREFIX + "dept", obj);
	}

}
