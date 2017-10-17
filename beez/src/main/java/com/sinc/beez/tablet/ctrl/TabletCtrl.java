package com.sinc.beez.tablet.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.tablet.service.TabletService;

@Controller
@RequestMapping("/tablet")
public class TabletCtrl {

	@Resource(name = "tabletService")
	private TabletService service;

	@RequestMapping("/getListForSeat.do")
	@ResponseBody
	public List<Object> getListForSeatForm(int floor) {

		List<Object> list = service.seatInfoService(floor);

		// System.out.println("LIST : " + list.toString());

		return list;
	}

	@RequestMapping("/tablet.do")
	public String tablet_view(String floor, Model model) {
	//	System.out.println("TABLET CTRL : "+floor);
		if(floor == null || floor.equals(null)){
			floor = "14f";
		}
		model.addAttribute("floor",floor.toUpperCase());
		return "tablet/tablet_view";
	}
/*
	@RequestMapping("/9f.do")
	public String a() {
		return "designtest/9f";
	}

	@RequestMapping("/10f.do")
	public String b() {
		return "designtest/10f";
	}

	@RequestMapping("/13f.do")
	public String c() {
		return "designtest/13f";
	}

	@RequestMapping("/14f.do")
	public String d() {
		return "designtest/14f";
	}*/
}
