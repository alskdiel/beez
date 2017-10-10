package com.sinc.beez.seat.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


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


	@Override
	public Map<Object, Object> officeInfo(Object obj) {		// obj: UserSeatVO

		return session.selectOne(SEATPREFIX + "office", obj);
	}


	@Override
	public int getCountRowDate(Object obj) {
		System.out.println("getCountRowDate");
		
		return session.selectOne(SEATPREFIX + "cntDate", obj);
	}


	@Override
	public int getCountRowLoc(Object obj) {
		
		return session.selectOne(SEATPREFIX + "cntLoc", obj);
	}


	@Override
	public List<Object> seatHistoryListDateRow(Object obj) {
		// TODO Auto-generated method stub
		
		return session.selectList(SEATPREFIX + "historyDate", obj);
	}


	@Override
	public List<Object> seatHistoryListLocRow(Object obj) {
		// TODO Auto-generated method stub
		
		return session.selectList(SEATPREFIX + "historyLoc", obj);
	}

}
