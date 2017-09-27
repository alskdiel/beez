package com.sinc.beez.tablet.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TabletCtrl {

	@RequestMapping("/tablet.do")
	public String TabletForm() {

		System.out.println("Tablet Ctrl");
		return "tablet/tablet";
	}
}
