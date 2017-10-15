package com.sinc.beez.attend.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.att.service.AttService;
import com.sinc.beez.user.model.vo.UserVO;

@Controller
@RequestMapping("/att")
public class AttendCtrl {
	
	@Resource(name="attService")
	private AttService service;
	
	@RequestMapping("/myattend.do")
	public String calendar(Model model) {
		System.out.println("AttendCtrl calendar");
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		Map<String, Map> list = (HashMap)service.attList(current_user);
		System.out.println(list);
		
		JSONObject jsObj = new JSONObject(list);
		model.addAttribute("data_cal", jsObj);
		
		Date tmp = new Date();
		
		model.addAttribute("data_cal_yr", (tmp.getYear()+1900));
		model.addAttribute("data_cal_mon", tmp.getMonth());
		
		return "attend/calendar";
	}
	
	@RequestMapping("/myattendAjax.do")
	@ResponseBody
	public Map<Object, Object> calendarAjax(Model model, HttpServletRequest request) {
		System.out.println("AttendCtrl calendar");
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		//String date = request.getParameter("date");
		Map<Object, Object> date = new HashMap<Object, Object>();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		date.put("from", from);
		date.put("to", to);
		
		
		Map<Object, Object> map = (HashMap)service.attAjaxList(current_user, date);
		Map<Object, Object> ret = new HashMap<Object, Object>();
		ret.put("data_cal", map);
		
		ret.put("data_cal_yr", from.split("/")[2]);
		ret.put("data_cal_mon", from.split("/")[0]);
		
		return ret;
	}
	
	
	@RequestMapping("/myattstat.do")
	public String main() {
		System.out.println("AttendCtrl statistics");
		
		return "attend/statistics";
	}
}
