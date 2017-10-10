package com.sinc.beez.util.crypto.ctrl;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/crypto")
public class CryptoCtrl {
	
	@RequestMapping("/getServcePublicKey")
	@ResponseBody
	public String getServcePublicKey(String deviceId){
		
		
		
		
		JSONObject json = new JSONObject();
		return json.toString();
	}

}
