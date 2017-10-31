package com.sinc.beez.kakao.ctrl;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kakao")
public class kakaoCtrl {
	@RequestMapping("/seat.do")
	
	public String seat(HttpRequest request){
		return "";
	}
}
