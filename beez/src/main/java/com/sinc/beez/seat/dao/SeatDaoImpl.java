package com.sinc.beez.seat.dao;

import java.util.ArrayList;
import java.util.List;

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
	    
	    List<Object> offices= session.selectList(SEATPREFIX+"office");
	   
	     for(int i=0;i<offices.size();i++){
	    	
		    List<SeatVO> seatlist = session.selectList(SEATPREFIX+"seatlist",offices.get(i));
		    ((OfficeVO)offices.get(i)).setSeat(seatlist);
	     }
	    return offices;
	     }
	


	
	@Override
	public Object userFavoriteRow(Object obj) {
		return null;
	}



}
