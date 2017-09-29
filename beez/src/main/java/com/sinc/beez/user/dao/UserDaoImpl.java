package com.sinc.beez.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	
	private final static String USERPREFIX="com.sinc.beez.mapper.user.";

	@Resource(name="sqlSession")
	private SqlSession session;


	@Override
	public List<Object> userTeamListRow(Object obj) {
		System.out.println("UserDao userTeamListRow");
		
		return session.selectList(USERPREFIX + "teamlist", obj);
	}

	@Override
	public List<Object> getUserByNameRow(Object obj) {
		System.out.println("UserDao getUserByName");
		
		return session.selectList(USERPREFIX + "userbyname", obj);
	}

	
	@Override
	public Object getUserByIDRow(Object obj) {
		System.out.println("UserDao getUserById");
		
		return session.selectOne(USERPREFIX + "userbyid", obj);
	}
	
	
}
