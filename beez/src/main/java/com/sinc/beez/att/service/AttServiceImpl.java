package com.sinc.beez.att.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.att.dao.AttDao;
import com.sinc.beez.user.model.vo.UserVO;

@Service("attService")
public class AttServiceImpl implements AttService {
	@Resource(name="attDao")
	private AttDao dao;
	
	
	@Override
	public List<Object> attList(Object currentUser) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", ((UserVO)currentUser).getUser_id());
		Date tmp = new Date();
		//System.out.println(tmp.getYear());
		//System.out.println(tmp.getMonth());
		map.put("from", (String.format("%02d", tmp.getMonth()) + "/01/" + (tmp.getYear()+1900)).toString());
		map.put("to", (String.format("%02d", (tmp.getMonth()+1)) + "/01/" + (tmp.getYear()+1900)).toString());
		
		return dao.attListRow(map);
	}
}
