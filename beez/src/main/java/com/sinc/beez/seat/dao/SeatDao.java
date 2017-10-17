package com.sinc.beez.seat.dao;

import java.util.List;
import java.util.Map;

public interface SeatDao {

	public List<Object> seatListRow(Object obj);
	public List<Object> officeListRow();
	public Object userFavoriteRow(Object obj);
	
	public List<Object> seatDisabledListRow(Object obj);
	public List<Object> seatInuseListRow(Object obj);

	public Object seatRow(Object obj);
	
	public List<Object> seatHistoryListRow(Object obj);	// obj: UserVO
	public List<Object> seatHistoryListDateRow(Object obj);	// obj: UserVO
	public List<Object> seatHistoryListLocRow(Object obj);	// obj: UserVO

	
	
	public Map<Object, Object> officeInfo(Object obj);			// obj: UserSeatVO
	public int getCountRow(Object obj);					// obj: UserVO
	public int getCountRowDate(Object obj);	// obj: UserVO, from/to: Date
	public int getCountRowLoc(Object obj);	// obj: UserVO, toFind: String

}
