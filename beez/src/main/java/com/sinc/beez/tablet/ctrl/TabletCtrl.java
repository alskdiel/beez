package com.sinc.beez.tablet.ctrl;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.beacon.model.vo.BeaconVO;
import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.tablet.service.TabletService;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

@Controller
@RequestMapping("/tablet")
public class TabletCtrl {

	@Resource(name="tabletService")
	private TabletService service;	
	
	@RequestMapping("/tablet.do")
	@ResponseBody
	public String TabletForm(BeaconVO beacon, SeatVO seat) {

		System.out.println("Tablet Ctrl");

		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;

		service.seatInfoService(seat);
		
		try {
			for (int i = 0; i < jsonArray.length(); i++) {

				json = new JSONObject();

				SeatVO vo1 = (SeatVO) jsonArray.get(i);
				UserSeatVO vo2 = (UserSeatVO) jsonArray.get(i);

				json.put("seat_useable_state", vo1.getSeat_useable_state());
				json.put("user_leave", vo2.getUser_leave());

				jsonArray.put(json);
			}
			
			if (beacon.getBeacon_id() != null) {
				return "tablet/tablet.do?beaconID=${beacon.getBeacon_id}";
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return "tablet/tablet";
	}
}
