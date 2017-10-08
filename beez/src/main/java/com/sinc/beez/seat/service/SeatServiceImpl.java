package com.sinc.beez.seat.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.seat.dao.SeatDao;
import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.userseat.model.vo.UserSeatVO;
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
		
		List<Object> list = dao.seatHistoryListRow(map);
		for(int i=0; i<list.size(); i++) {
			UserSeatVO userSeatVO = (UserSeatVO)list.get(i);
			int office_seq = userSeatVO.getOffice_seq();
			String seat_id = userSeatVO.getSeat_id();
			
			Map<Object, Object> officeInfo = dao.officeInfo(userSeatVO);
			
			userSeatVO.setBuilding_name((String)(officeInfo.get("BUILDING_NAME")));
			userSeatVO.setFloor_num(((BigDecimal)(officeInfo.get("FLOOR_NUM"))).intValue());
			userSeatVO.setSeat_real_location((String)(officeInfo.get("SEAT_REAL_LOCATION")));
			
		}
		
		return list;
	}
	
	@Override
	public int getCount(Object obj) {
		System.out.println("Service getCount");
		
		return dao.getCountRow(obj);
	}
}
