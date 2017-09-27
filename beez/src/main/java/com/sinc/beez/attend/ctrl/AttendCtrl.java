package com.sinc.beez.attend.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttendCtrl {

	@RequestMapping("/myattend.do")
	public String calendar() {
		System.out.println("AttendCtrl calendar");
		
		return "attend/calendar";
	}
	
	@RequestMapping("/myattstat.do")
	public String main() {
		System.out.println("AttendCtrl statistics");
		
		return "attend/statistics";
	}
}
