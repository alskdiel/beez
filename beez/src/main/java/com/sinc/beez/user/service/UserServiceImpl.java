package com.sinc.beez.user.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.user.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao dao;
	
	
	
	
	@Override
	public Object loginService(Object obj) {
		return null;
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) {
		
	}

	@Override
	public Object checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSessionKey(String sessionId, Date next) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getState(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getMyCalender(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserSeat(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> teamList(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> seatHistory(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
