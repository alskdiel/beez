package com.sinc.beez.main.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinc.beez.main.model.MainVO;
import com.sinc.beez.main.service.MainService;

@Controller
public class MainCtrl {
	@Resource(name="MainService")
	MainService service;
	
	@RequestMapping("/main.do")
	public String main(MainVO vo ,Model model) {
		System.out.println("MainCtrl main");
		/*
		System.out.println("BEFORE : "+vo.toString());
		vo = service.getMainInto(vo);
		System.out.println("AFTER : "+vo.toString());
		*/
		return "home";
	}
}
