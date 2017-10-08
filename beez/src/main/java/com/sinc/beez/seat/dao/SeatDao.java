package com.sinc.beez.seat.dao;

import java.util.List;
import java.util.Map;

public interface SeatDao {

	public List<Object> seatListRow();
	public Object userFavoriteRow(Object obj);

	public Object seatRow(Object obj);
	
	public List<Object> seatHistoryListRow(Object obj);	// obj: UserVO
	public Map<Object, Object> officeInfo(Object obj);			// obj: UserSeatVO
	public int getCountRow(Object obj);					// obj: UserVO

}
