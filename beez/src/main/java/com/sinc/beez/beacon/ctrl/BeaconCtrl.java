package com.sinc.beez.beacon.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.beacon.model.vo.BeaconOfficeDTO;
import com.sinc.beez.beacon.model.vo.BeaconVO;
import com.sinc.beez.beacon.service.BeaconService;

@Controller
@RequestMapping("/beacon/")
public class BeaconCtrl {
	@Resource(name = "BeaconService")
	BeaconService service;

	@RequestMapping("/getBeaconInfoByAddr.do")
	@ResponseBody
	public BeaconOfficeDTO getBeaconInfoByAddr(String address) {
		System.out.println(">>>>>>>>>>>>>>getBeaconInfoByAddr>>controller");
		BeaconOfficeDTO dto = service.getBeaconInfoByAddr(address);
		System.out.println(dto.toString());
		return dto;
	}

	@RequestMapping("/getBeaconInfoAll.do")
	@ResponseBody
	public String getBeaconInfoAll() {
		System.out.println(">>>>>>>>>>>>>>getBeaconInfoByAddr>>controller");
		JSONArray json = new JSONArray();
		
		List<BeaconOfficeDTO> list = service.getBeaconInfoAll();
		for (BeaconOfficeDTO dto : list) {
			json.put(dto);
		}
		return json.toString();
	}
	
	@RequestMapping("/isBeaconInfoByVO.do")
	@ResponseBody
	public boolean isBeaconInfoByVO(BeaconVO vo){
		boolean a = service.isBeaconInfoByVO(vo);
		
		return a;
	}
}
