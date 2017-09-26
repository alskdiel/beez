package com.sinc.beez.ssgkey.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ssgkey/")
public class SSGKeyCtrl {

	@RequestMapping("/getRSSIByMobile.do")
	@ResponseBody
	public String getRSSIByMobile() {
		
		
		return "";
	}
}
