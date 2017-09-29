package com.sinc.beez.seat.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;


@Repository("seatDao")
public class SeatDaoImpl implements SeatDao {
	
	private final static String SEATPREFIX="com.sinc.beez.mapper.seat.";

	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	@Override
	public List<Object> seatListRow() {
	    System.out.println("Dao seatListRow");
	    
	    return session.selectList(SEATPREFIX+"seatlist");
	}

	
	@Override
	public Object userFavoriteRow(Object obj) {
		return null;
	}


	@Override
	public Object seatRow(Object obj) {
		System.out.println("SeatDao userSeatRow");
		
		return session.selectOne(SEATPREFIX + "seat", obj);
	}




	
	@Override
	public List<Object> seatHistoryListRow(Object obj) {
		System.out.println("SeatDao seatHistoryListRow");
		
		return session.selectList(SEATPREFIX + "history", obj);
	}
	
	@Override
	public int getCountRow(Object obj) {
		System.out.println("SeatDao getCountRow");
		
		return session.selectOne(SEATPREFIX + "cnt", obj);
	}

}
