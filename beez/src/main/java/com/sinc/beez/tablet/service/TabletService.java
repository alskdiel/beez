package com.sinc.beez.tablet.service;

import java.util.List;

import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

public interface TabletService {

	public List<Object> seatInfoService(int floor);
}
