package com.sinc.beez.tablet.service;

import java.util.List;

import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;

public interface TabletService {

	public List<Object> seatInfoService(SeatVO seat);
}
