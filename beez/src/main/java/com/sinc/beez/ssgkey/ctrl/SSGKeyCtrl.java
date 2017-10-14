package com.sinc.beez.ssgkey.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.ssgkey.model.SSGKeyVO;
import com.sinc.beez.ssgkey.service.SSGKeyService;
@Controller
@RequestMapping("/ssgkey/")
public class SSGKeyCtrl {
	@Resource(name="SSGKeyService")
	SSGKeyService service;
	
// For Mobile Area
	@RequestMapping("/setRSSIByMobile.do")
	@ResponseBody
	public String setRSSIByMobile(SSGKeyVO vo) {
	//	System.out.println(">>>>CTRL >>>> setRSSIByMobile");
	//	System.out.println(vo.toString());
		service.setRssi(vo.getPcName(), vo.getBtRssi());
		JSONObject rst = new JSONObject();
		rst.put("result", true);
		return rst.toString();
	}
	@RequestMapping("/registerDeviceforMobile.do")
	@ResponseBody
	public String registerDeviceforMobile(SSGKeyVO vo) {
	//	System.out.println(">>>>CTRL >>>> registerDeviceforMobile");
	//	System.out.println(vo.toString());
		
		JSONObject rst = new JSONObject();
		rst.put("result", true);
		return rst.toString();
	}
// For Mobile Area End
	
// For PC Area Start
	@RequestMapping("/pollingRSSIService.do")
	@ResponseBody
	public int pollingRSSIService(SSGKeyVO vo) {
//		System.out.println(">>>>CTRL >>>> pollingRSSIService");
//		System.out.println(vo.toString());
		int rssi = service.getRssi(vo.getPcName());
		
	//	JSONObject rst = new JSONObject();
	//	rst.put("rssi", rssi);
	//	return rst.toString();
		return rssi;
	}
// For PC Area End
}
