package com.sinc.beez.seat.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.office.model.vo.OfficeVO;
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
		
		List<Object> officeList = dao.officeListRow();
		
		List<Object> ret = new ArrayList<Object>();
		
		//Map ret = new HashMap<Object, Object>();
		
		for(int i=0; i<officeList.size(); i++) {
			Map<Object, Object> rData = new HashMap<Object, Object>();

			//dao.seatListRow(((OfficeVO)officeList.get(i)));
			int floor_num = ((OfficeVO)officeList.get(i)).getFloor_num();
			int office_seq = ((OfficeVO)officeList.get(i)).getOffice_seq();

			rData.put("floor", floor_num);
			
			Map<Object, Object> dto = new HashMap<Object, Object>();
			dto.put("office_seq", office_seq);
			dto.put("section", "A");
			
			List<Object> fList = new ArrayList<Object>();
			
			Map<Object, Object> fData = new HashMap<Object, Object>();
			fData.put("section", "A");
			
			
			Map<Object, Object> sData = new HashMap<Object, Object>();
			sData.put("disabled", dao.seatDisabledListRow(dto));
			sData.put("inuse", dao.seatInuseListRow(dto));
			
			fData.put("data", sData);
			
			fList.add(fData);
			dto = new HashMap<Object, Object>();
			dto.put("office_seq", office_seq);
			dto.put("section", "B");
			
			fData = new HashMap<Object, Object>();
			fData.put("section", "B");
			
			
			sData = new HashMap<Object, Object>();
			sData.put("disabled", dao.seatDisabledListRow(dto));
			sData.put("inuse", dao.seatInuseListRow(dto));
			
			fData.put("data", sData);
			
			fList.add(fData);
			//ret.put("data", new ArrayList());
			rData.put("data", fList);
			
			ret.add(rData);
		}
		
		//List<Object> list = dao.seatListRow();
		
		
		//return dao.seatListRow();
		return ret;
	}

	@Override
	public List<Object> getUserFavorite(Object obj) {
		UserVO current_user = (UserVO)(((Map)obj).get("currentUser"));
		String type = (String)(((Map)obj).get("sub_type"));
		if(type.equals("month")) {
			return dao.userFavoriteRowByMonth(current_user);
		} else {
			return dao.userFavoriteRowByYear(current_user);
		}
	}

	@Override
	public List<Object> seatHistoryList(Object currentUser, Object pagingDTO, Object type, Object params) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", ((UserVO)currentUser).getUser_id());
		map.put("endRowNum", ((PagingDTO)pagingDTO).getEndRowNum());
		map.put("startRowNum", ((PagingDTO)pagingDTO).getStartRowNum());
		
		List<Object> list;
		if(type.equals("date")) {
			String[] dates = ((String)params).split("-");
			Date from = new Date(dates[0]);
			Date to = new Date(dates[1]);
			map.put("from", from);
			map.put("to", to);
			
			list = dao.seatHistoryListDateRow(map);
		} else if(type.equals("loc")) {
			String loc = (String)params;
			map.put("where", loc);
			
			list = dao.seatHistoryListLocRow(map);
		} else {
			list = dao.seatHistoryListRow(map);
		}
		
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
	public int getCount(Object obj, Object type, Object params) {
		
		if(type.equals("date")) {
			String[] dates = ((String)params).split("-");
			Date from = new Date(dates[0]);
			Date to = new Date(dates[1]);
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("user_id", ((UserVO)obj).getUser_id());
			map.put("from", from);
			map.put("to", to);
			
			
			return dao.getCountRowDate(map);
		} else if(type.equals("loc"))  {
			String loc = (String)params;
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("user_id", ((UserVO)obj).getUser_id());
			map.put("where", loc);
			
			return dao.getCountRowLoc(map);
		} else {
			return dao.getCountRow(obj);
		}
		
	}
}
