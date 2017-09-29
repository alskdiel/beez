package com.sinc.beez.seat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.seat.dao.SeatDao;
import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.util.PagingDTO;


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

	@Override
	public List<Object> seatHistoryList(Object currentUser, Object pagingDTO) {
		System.out.println("Service seatHistoryList");
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", ((UserVO)currentUser).getUser_id());
		map.put("endRowNum", ((PagingDTO)pagingDTO).getEndRowNum());
		map.put("startRowNum", ((PagingDTO)pagingDTO).getStartRowNum());
		
		return dao.seatHistoryListRow(map);
	}
	
	@Override
	public int getCount(Object obj) {
		System.out.println("Service getCount");
		
		return dao.getCountRow(obj);
	}
}
