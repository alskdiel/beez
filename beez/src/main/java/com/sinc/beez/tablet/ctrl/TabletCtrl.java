package com.sinc.beez.tablet.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.x.json.JsonArray;
import com.sinc.beez.beacon.model.vo.BeaconVO;
import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.tablet.service.TabletService;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

@Controller
@RequestMapping("/tablet")
public class TabletCtrl {

	@Resource(name = "tabletService")
	private TabletService service;
	
	@RequestMapping("/getListForSeat.do")
	@ResponseBody
	public List<Object> getListForSeatForm(int floor) {
		
		List<Object> list = service.seatInfoService(floor);
		
		System.out.println("LIST : " + list.toString());

		return list;
	}

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
	}
}
