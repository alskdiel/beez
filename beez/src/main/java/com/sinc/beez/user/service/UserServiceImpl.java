package com.sinc.beez.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.att.model.vo.AttVO;
import com.sinc.beez.dept.model.vo.DeptVO;
import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.user.dao.UserDao;
import com.sinc.beez.user.model.vo.UserVO;

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
		System.out.println("UserService getState");
		
		((UserVO)obj).setUser_name(((UserVO)dao.getUserByIDRow(obj)).getUser_name());		
		((UserVO)obj).setDept((DeptVO)dao.userDeptRow(obj));
		((UserVO)obj).setAtt((AttVO)dao.userAttArivalRow(obj));
		((UserVO)obj).setSeat((SeatVO)dao.userSeatRow(obj));
		
		return obj;
	}

	@Override
	public List<Object> getMyCalender(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserSeat(Object obj) {
		System.out.println("UserService getUserSeat");
		
		((UserVO)obj).setUser_name(((UserVO)dao.getUserByIDRow(obj)).getUser_name());
		((UserVO)obj).setSeat((SeatVO)dao.userSeatRow(obj));
		
		return obj;
	}

	@Override
	public List<Object> getUserTeamList(Object obj) {
		System.out.println("UserService getUserTeamList");
		
		return dao.userTeamListRow(obj);
	}

	@Override
	public List<Object> seatHistory(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getUserByName(Object obj) {
		System.out.println("UserService getUserByName");
		
		List<Object> list = dao.getUserByNameRow(obj);
		
		for(int i=0; i<list.size(); i++) {
			((UserVO)list.get(i)).setDept((DeptVO)(dao.userDeptRow(list.get(i))));
		}
		
		return list;
	}

	/*
	@Override
	public Object getUserById(Object obj) {
		System.out.println("UserService getUserById");
		
		return dao.getUserByIDRow(obj);
	}
	*/
}
