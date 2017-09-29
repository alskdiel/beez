package com.sinc.beez.tablet.model.sql;

import java.util.List;

import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;

public interface TabletDao {

	public List<Object> seatInfo(SeatVO seat);
}
