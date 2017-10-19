package com.sinc.beez.att.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.att.dao.AttDao;
import com.sinc.beez.att.model.vo.AttVO;
import com.sinc.beez.user.model.vo.UserVO;

@Service("attService")
public class AttServiceImpl implements AttService {
	@Resource(name="attDao")
	private AttDao dao;
	
	
	@Override
	public Map<Object, Object> attList(Object currentUser) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", ((UserVO)currentUser).getUser_id());
		Date tmp = new Date();
		//System.out.println(tmp.getYear());
		//System.out.println(tmp.getMonth());
		map.put("from", (String.format("%02d", tmp.getMonth()+1) + "/01/" + (tmp.getYear()+1900)).toString());
		map.put("to", (String.format("%02d", (tmp.getMonth()+2)) + "/01/" + (tmp.getYear()+1900)).toString());
		
		List<Object> list = dao.attListRow(map);
		//List<Object> ret = new ArrayList<Object>();
		Map<Object, Object> ret = new HashMap<Object, Object>();

		for(int i=0; i<list.size(); i++) {
			Map<String, String> att_info = new HashMap<String, String>();
			
			String day = (((AttVO)(list.get(i))).getAtt_arrive_time().split(" ")[0]).split("-")[2];
			String[] arrive = ((((AttVO)(list.get(i))).getAtt_arrive_time()).split(" ")[1]).split(":");
			String[] leave = ((((AttVO)(list.get(i))).getAtt_leave_time()).split(" ")[1]).split(":");
			
			att_info.put("arrive", arrive[0]+":"+arrive[1]);
			att_info.put("leave", leave[0]+":"+leave[1]);

			ret.put(day, att_info);
			
		}
		
		return ret;
	}


	@Override
	public Map<Object, Object> attAjaxList(Object currentUser, Object date) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("user_id", ((UserVO)currentUser).getUser_id());
		
		System.out.println(date);
		
		map.put("from", ((HashMap)date).get("from"));
		map.put("to", ((HashMap)date).get("to"));
		
		List<Object> list = dao.attListRow(map);
		System.out.println(list);
		//List<Object> ret = new ArrayList<Object>();
		Map<Object, Object> ret = new HashMap<Object, Object>();

		for(int i=0; i<list.size(); i++) {
			Map<String, String> att_info = new HashMap<String, String>();

			String day = (((AttVO)(list.get(i))).getAtt_arrive_time().split(" ")[0]).split("-")[2];
			try {
				String[] arrive = ((((AttVO)(list.get(i))).getAtt_arrive_time()).split(" ")[1]).split(":");
				att_info.put("arrive", arrive[0]+":"+arrive[1]);

			} catch(Exception e) {}
			
			try {
			String[] leave = ((((AttVO)(list.get(i))).getAtt_leave_time()).split(" ")[1]).split(":");
			att_info.put("leave", leave[0]+":"+leave[1]);

			} catch(Exception e) {}
			
			ret.put(day, att_info);
		}
		
		return ret;
		
	}
}
