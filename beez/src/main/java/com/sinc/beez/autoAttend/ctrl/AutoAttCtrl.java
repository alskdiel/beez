package com.sinc.beez.autoAttend.ctrl;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.autoAttend.model.AutoAttDTO;
import com.sinc.beez.autoAttend.service.AutoAttService;

@Controller
@RequestMapping("/AutoAtt")
public class AutoAttCtrl {
	@Resource(name="AutoAttService")
	AutoAttService service;
	
	@RequestMapping("/workIn.do")
	@ResponseBody
	public String workIn(AutoAttDTO dto){
		System.out.println(dto.toString());
		int result = 0;
		result = service.workIn(dto);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	@RequestMapping("/workOut.do")
	/*
	 * 사용되지 않는 메소드
	 * workOut 즉, 출근 프로세스는 DB에서 JOB으로 처리하였음.
	 * 2017/10/11
	 */
	public String workOut(AutoAttDTO dto){
		int result = 0;
		result = service.workOut(dto);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@RequestMapping("/workUpdate.do")
	@ResponseBody
	public String workUpdate(AutoAttDTO dto){
	//	System.out.println(dto.toString());
		int result = 0;
		result = service.workUpdate(dto);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
}
