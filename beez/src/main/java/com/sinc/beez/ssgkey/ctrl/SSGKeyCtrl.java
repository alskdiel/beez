package com.sinc.beez.ssgkey.ctrl;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.ssgkey.model.SSGKeyVO;

@Controller
@RequestMapping("/ssgkey/")
public class SSGKeyCtrl {

	@RequestMapping("/setRSSIByMobile.do")
	@ResponseBody
	public String setRSSIByMobile(SSGKeyVO vo) {
		System.out.println(">>>>CTRL >>>> SETRSSIBYMOBILE");
		System.out.println(vo.toString());
		
		JSONObject rst = new JSONObject();
		rst.put("result", true);
		return rst.toString();
	}
}
