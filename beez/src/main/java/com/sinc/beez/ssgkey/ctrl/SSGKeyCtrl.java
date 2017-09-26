package com.sinc.beez.ssgkey.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.ssgkey.model.SSGKeyVO;

@Controller
@RequestMapping("/ssgkey/")
public class SSGKeyCtrl {

	@RequestMapping("/setRSSIByMobile.do")
	@ResponseBody
	public boolean setRSSIByMobile(SSGKeyVO vo) {
		vo.toString();
		
		
		
		return true;
	}
}
