package com.sinc.beez.seat.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.office.model.vo.OfficeVO;


@Repository("seatDao")
public class SeatDaoImpl implements SeatDao {
	
	private final static String SEATPREFIX="com.sinc.beez.mapper.seat.";

	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	@Override
	public List<Object> seatListRow() {
	    System.out.println("Dao seatListRow");
	    
	    List<OfficeVO> offices= session.selectList(SEATPREFIX+"office");
	    System.out.println(offices);
	    System.out.println(offices.size());
	    
	    for(int i=0; i<offices.size(); i++) {
	    	
	    	//int seq =offices.get(i).getOffice_seq(); // 1번째에 seq 얻어서 seq에 넣음 그걸 넘김.
	    	//System.out.println("//"+seq+"//");
	   
			
	    	
	    }
	    return null;

	}

	@Override
	public Object userFavoriteRow(Object obj) {
		return null;
	}

}
