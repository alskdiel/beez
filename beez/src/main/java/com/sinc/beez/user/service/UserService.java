package com.sinc.beez.user.service;

import java.util.Date;
import java.util.List;


public interface UserService{

	////////////////////////로그인////////////////////////////	
	public Object loginService(Object obj);
	public void keepLogin(String id, String sessionId, Date next);
	public Object checkUserWithSessionKey(String value);
	public void deleteSessionKey(String sessionId, Date next);
	public void join(Object obj);
	////////////////////////////////////////////////////////
	public Object getState(Object obj);
	public List<Object> getMyCalender(Object obj);
	public Object getUserSeat(Object obj);
	public List<Object> getUserTeamList(Object obj);
	
	public List<Object> seatHistory(Object obj);

	public List<Object> getUserByName(Object obj);
	//public Object getUserById(Object obj);
	
}