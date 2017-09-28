package com.sinc.beez.user.dao;

import java.util.List;
import java.util.Map;



public interface UserDao {
	
	////////////////////////로그인////////////////////////////
	public Object loginRow(Object obj);
	public void keepLoginRow(Map <String,Object> map); 
	public Object checkUserWithSessionKeyRow(String value); 
	public void deleteSessionRow(Map <String,Object> map); 
	public void joinRow(Object obj);
	////////////////////////////////////////////////////////
	public Object stateRow(Object obj);
	public List<Object> myCalenderRow(Object obj);
	public Object userSeatRow(Object obj);
	public List<Object> teamListRow(Object obj);
	public List<Object> seatHistoryRow(Object obj);
		
}
