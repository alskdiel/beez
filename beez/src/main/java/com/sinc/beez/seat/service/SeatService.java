package com.sinc.beez.seat.service;

import java.util.List;

public interface SeatService {
	
	public List<Object> seatList();
	public List<Object> getUserFavorite(Object obj);
	public List<Object> seatHistoryList(Object currentUser, Object pagingDTO, Object type, Object params);	// obj: UserVO
	
	public int getCount(Object obj, Object type, Object params);

}
