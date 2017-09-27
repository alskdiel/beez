package com.sinc.beez.seat.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeatCtrl {

	@RequestMapping("/seats.do")
	public String status() {
		
		return "seat/status";
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
