package com.sinc.beez.seat.dao;

import java.util.List;

public interface SeatDao {

	public List<Object> seatListRow();
	public Object userFavoriteRow(Object obj);

	public Object seatRow(Object obj);
	
	public List<Object> seatHistoryListRow(Object obj);	// obj: UserVO
	public int getCountRow(Object obj);					// obj: UserVO

}
