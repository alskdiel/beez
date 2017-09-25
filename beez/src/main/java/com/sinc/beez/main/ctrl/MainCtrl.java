package com.sinc.beez.main.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCtrl {

	@RequestMapping("/main.do")
	public String main() {
		System.out.println("MainCtrl main");
		
		return "home";
	}
}
