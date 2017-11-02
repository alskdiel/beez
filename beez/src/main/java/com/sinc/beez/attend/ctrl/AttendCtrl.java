package com.sinc.beez.attend.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.att.service.AttService;
import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.user.service.UserService;

@Controller
@RequestMapping("/att")
public class AttendCtrl {
	
	@Resource(name="attService")
	private AttService service;
	@Resource(name="userService")
	private UserService service2;
	
	@RequestMapping("/myattend.do")
	public String calendar(Model model, HttpSession session) {
		/**********************************/
		// current_user = session.getUserVO
		/*
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		*/
		UserVO current_user = (UserVO) session.getAttribute("currentUser");
		System.out.println(current_user);
		/**********************************/
		Map<String, Map> list = new HashMap<String, Map>();
		try{
		list = (HashMap)service.attList(current_user);
		
		}catch(Exception e ){
			
		}
		JSONObject jsObj = new JSONObject(list);
		model.addAttribute("data_cal", jsObj);
		
		Date tmp = new Date();
		
		model.addAttribute("data_cal_yr", (tmp.getYear()+1900));
		model.addAttribute("data_cal_mon", tmp.getMonth()+1);
		
		String userStatus = "출근 전";
		try {
			Map<Object, Object> stParam = new HashMap<Object, Object>();
			stParam.put("user_id", current_user.getUser_id());
			userStatus = (String)((Map) service2.getStatus(stParam)).get("USER_STATE");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean isAtted = true;
		if(((UserVO) service2.getState(current_user)).getAtt() == null) {
			isAtted = false;
		}
		model.addAttribute("isAtted", isAtted);		
		model.addAttribute("userState", userStatus);

		
		return "attend/calendar";
	}
	
	@RequestMapping("/myattendAjax.do")
	@ResponseBody
	public Map<Object, Object> calendarAjax(Model model, HttpServletRequest request, HttpSession session) {
		/**********************************/
		// current_user = session.getUserVO
		//UserVO current_user = new UserVO();
		//current_user.setUser_id("p908vd");
		UserVO current_user = (UserVO) session.getAttribute("currentUser");

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
	public String main(HttpSession session, Model model) {
		
		UserVO current_user = (UserVO) session.getAttribute("currentUser");
		
		String userStatus = "출근 전";
		try {
			Map<Object, Object> stParam = new HashMap<Object, Object>();
			stParam.put("user_id", current_user.getUser_id());
			userStatus = (String)((Map) service2.getStatus(stParam)).get("USER_STATE");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean isAtted = true;
		if(((UserVO) service2.getState(current_user)).getAtt() == null) {
			isAtted = false;
		}
		model.addAttribute("isAtted", isAtted);		
		model.addAttribute("userState", userStatus);
		
		
		return "attend/statistics";
	}
}
