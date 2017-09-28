package com.sinc.beez.tablet.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinc.beez.beacon.model.vo.BeaconVO;

@Controller
@RequestMapping("/tablet")
public class TabletCtrl {
	
	@RequestMapping("/tablet.do")
	public String TabletForm(BeaconVO beacon) {

		System.out.println("Tablet Ctrl");

		if (beacon.getBeacon_id() != null) {
			return "tablet/tablet.do?beaconID=beacon.getBeacon_id";
		}
		return "tablet/tablet";
	}
}
