package com.sinc.beez.tablet.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.tablet.model.sql.TabletDao;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

@Service("tabletService")
public class TabletServiceImpl implements TabletService {

	@Resource(name="tabletDao")
	private TabletDao dao;

	@Override
	public List<Object> seatInfoService(int floor) {
	
		System.out.println("TabletServiceImpl seatInfoService");
		return dao.seatInfo(floor);
	}
}
