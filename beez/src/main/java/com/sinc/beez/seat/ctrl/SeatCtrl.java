package com.sinc.beez.seat.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinc.beez.seat.service.SeatService;

@Controller
@RequestMapping("/seat")
public class SeatCtrl {

	@Resource(name="seatService")
	private SeatService service;
	
	
	//전체 좌석 현황
	@RequestMapping("/list.do")
	public String status() {
		
	    List<Object> list = service.seatList();
		System.out.println(list);
		return null;
	}
	
	@RequestMapping("/seatstat.do")
	public String statistics() {
		
		return "seat/statistics";
	}
	
	@RequestMapping("/myseat.do")
	public String myHistory() {
		
		return "seat/myseat";
	}
}
