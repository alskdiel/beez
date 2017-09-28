package com.sinc.beez.seat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.dao.SeatDao;


@Service("seatService")
public class SeatServiceImpl implements SeatService{

	@Resource(name="seatDao")
	private SeatDao dao;
	
	@Override
	public List<Object> seatList() {
		System.out.println("Service seatListService");
		List<Object> list = dao.seatListRow();
		return dao.seatListRow();

	}

	@Override
	public Object getUserFavorite(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
