package com.sinc.beez.nfcTagging.ctrl;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.nfcTagging.model.NfcDTO;
import com.sinc.beez.nfcTagging.service.NfcService;

@Controller
@RequestMapping("/NFCTAGGING")
public class NfcCtrl {
	@Resource(name="NfcService")
	NfcService service;
	
	@RequestMapping("/touchTag.do")
	@ResponseBody
	public String touchTag(NfcDTO dto){
	//	System.out.println("NFC CTRL");
	//	System.out.println(dto);
		int result;
		result = service.touchTag(dto);

		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
}
