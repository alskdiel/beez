package com.sinc.beez.nfcTagging.ctrl;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.nfcTagging.model.NfcDTO;
import com.sinc.beez.nfcTagging.service.NfcService;

@Controller
@RequestMapping("/NFCTAGGING")
public class NfcCtrl {
	@Resource(name="NfcService")
	NfcService service;
	@RequestMapping("/bookSeat.do")
	@ResponseBody
	public String bookSeat(NfcDTO dto){
	//	System.out.println("NFC CTRL");
		System.out.println(dto);
		int result;
		result = service.bookSeat(dto);

		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
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
	@RequestMapping("/touchTagUpdate.do")
	@ResponseBody
	public String touchTagUpdate(NfcDTO dto){
	//	System.out.println("NFC CTRL");
	//	System.out.println(dto);
		int result;
		result = service.touchTagUpdate(dto);

		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	@RequestMapping("/syncMap.do")
	@ResponseBody
	public String syncMap(String tagginginfo){
		String result = "";
		
		result = service.SyncMap(tagginginfo);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
}
