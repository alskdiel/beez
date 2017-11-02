package com.sinc.beez.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.att.dao.AttDao;
import com.sinc.beez.att.model.vo.AttVO;
import com.sinc.beez.dept.dao.DeptDao;
import com.sinc.beez.dept.model.vo.DeptVO;
import com.sinc.beez.seat.dao.SeatDao;
import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.user.dao.UserDao;
import com.sinc.beez.user.model.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="deptDao")
	private DeptDao deptDao;
	@Resource(name="attDao")
	private AttDao attDao;
	@Resource(name="seatDao")
	private SeatDao seatDao;
	
	
	@Override
	public Object loginService(Object obj) {
		return null;
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) {
		
	}

	@Override
	public Object checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSessionKey(String sessionId, Date next) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void join(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getState(Object obj) {
		
		((UserVO)obj).setUser_name(((UserVO)userDao.getUserByIDRow(obj)).getUser_name());
		
		((UserVO)obj).setDept((DeptVO)deptDao.deptRow(obj));
		((UserVO)obj).setAtt((AttVO)attDao.attArivalRow(obj));
		((UserVO)obj).setSeat((SeatVO)seatDao.seatRow(obj));
		
		return obj;
	}

	@Override
	public List<Object> getMyCalender(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserSeat(Object obj) {
		
		((UserVO)obj).setUser_name(((UserVO)userDao.getUserByIDRow(obj)).getUser_name());
		((UserVO)obj).setSeat((SeatVO)seatDao.seatRow(obj));
		
		Map<Object, Object> ret = new HashMap<Object, Object>();
		
		ret.put("floor", ((UserVO)obj).getSeat().getOffice_seq());
		ret.put("seat_id", ((UserVO)obj).getSeat().getSeat_id());
		
		return ret;
	}

	@Override
	public List<Object> getUserTeamList(Object obj) {
		List<Object> list = userDao.userTeamListRow(obj);
		List<Object> ret = new ArrayList<Object>();
		
		for(int i=0; i<list.size(); i++) {
			Map<Object, Object> tmp = new HashMap<Object, Object>();
			UserVO user = (UserVO)list.get(i);

			tmp.put("user_id", user.getUser_id());
			tmp.put("user_name", user.getUser_name());
			
			if((SeatVO) seatDao.seatRow(user) != null) {
				tmp.put("seat", true);
			}
			
			ret.add(tmp);
		}
		return ret;
	}

	
	public List<Object> getUserTeamSeatList(Object obj) {
		List<Object> list = userDao.userTeamListRow(obj);
		List<Object> ret = new ArrayList<Object>();
		
		for(int i=0; i<list.size(); i++) {
			Map<Object, Object> tmp = new HashMap<Object, Object>();
			UserVO user = (UserVO)list.get(i);

			//tmp.put("user_id", user.getUser_id());
			tmp.put("user_name", user.getUser_name());
			SeatVO user_seat = (SeatVO) seatDao.seatRow(user);
			if(user_seat != null) {

				tmp.put("floor", user_seat.getOffice_seq());
				tmp.put("seat_id", user_seat.getSeat_id());
			}
			
			ret.add(tmp);
		}
		return ret;
	}

	
	@Override
	public List<Object> seatHistory(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getUserByName(Object obj) {
		
		List<Object> list = userDao.getUserByNameRow(obj);
		
		for(int i=0; i<list.size(); i++) {
			((UserVO)list.get(i)).setDept((DeptVO)(deptDao.deptRow(list.get(i))));
		}
		
		return list;
	}

	public Object getUserSeatByName(Object obj) {
		
		List<Object> list = userDao.getUserByNameRow(obj);
		
		UserVO tmp = (UserVO)(list.get(0));
		SeatVO tmp2 = (SeatVO)(seatDao.seatRow(tmp));
		
		Map<Object, Object> ret = new HashMap<Object, Object>();
		
		ret.put("floor", tmp2.getOffice_seq());
		ret.put("seat_id", tmp2.getSeat_id());
		
		return ret;
	}
	
	
	public Object getUserVoById(Object obj) {
		// TODO Auto-generated method stub
		
		return userDao.getUserByIDRow(obj);
	}

	@Override
	public void setStatus(Object obj) {
		if(userDao.selectUserStatusRow(obj) == null) {
			userDao.setUserStatusRow(obj);
		} else {
			userDao.updateUserStatusRow(obj);
		}
		
	}

	@Override
	public Object getStatus(Object obj) {
		return userDao.selectUserStatusRow(obj);	
	}
	
	/*
	@Override
	public Object getUserById(Object obj) {
		System.out.println("UserService getUserById");
		
		return dao.getUserByIDRow(obj);
	}
	*/
}
