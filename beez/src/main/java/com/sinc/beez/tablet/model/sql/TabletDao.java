package com.sinc.beez.tablet.model.sql;

import java.util.List;

import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

public interface TabletDao {

	public List<Object> seatInfo(SeatVO seat);
	public List<Object> userseatInfo(UserSeatVO userseat);	
}
