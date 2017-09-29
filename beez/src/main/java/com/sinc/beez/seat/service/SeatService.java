package com.sinc.beez.seat.service;

import java.util.List;

public interface SeatService {
	
	public List<Object> seatList();
	public Object getUserFavorite(Object obj);
	public List<Object> seatHistoryList(Object currentUser, Object pagingDTO);	// obj: UserVO
	public int getCount(Object obj);
}
