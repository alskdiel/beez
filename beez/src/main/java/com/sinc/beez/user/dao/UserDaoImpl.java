package com.sinc.beez.user.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	
	private final static String USERPREFIX="com.sinc.beez.mapper.user.";

	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	@Override
	public Object loginRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keepLoginRow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object checkUserWithSessionKeyRow(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSessionRow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinRow(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object stateRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> myCalenderRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object userSeatRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> teamListRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> seatHistoryRow(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
