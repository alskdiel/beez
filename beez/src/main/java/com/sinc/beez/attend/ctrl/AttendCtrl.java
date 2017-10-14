package com.sinc.beez.attend.ctrl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinc.beez.att.model.vo.AttVO;
import com.sinc.beez.att.service.AttService;
import com.sinc.beez.user.model.vo.UserVO;

@Controller
@RequestMapping("/att")
public class AttendCtrl {
	
	@Resource(name="attService")
	private AttService service;
	
	@RequestMapping("/myattend.do")
	public String calendar() {
		System.out.println("AttendCtrl calendar");
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		ArrayList<AttVO> list = (ArrayList)service.attList(current_user);
		
		return "attend/calendar";
	}
	
	@RequestMapping("/myattstat.do")
	public String main() {
		System.out.println("AttendCtrl statistics");
		
		return "attend/statistics";
	}
}
