package com.sinc.beez.beacon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.beacon.dao.BeaconDAO;
import com.sinc.beez.beacon.model.vo.BeaconOfficeDTO;
import com.sinc.beez.beacon.model.vo.BeaconVO;

@Service("BeaconService")
public class BeaconServiceImpl implements BeaconService {
	@Resource(name="BeaconDAO")
	BeaconDAO dao;
	
	@Override
	public List<BeaconOfficeDTO> getBeaconInfoAll() {
		
		return  dao.getBeaconInfoAll();
	}

	@Override
	public BeaconOfficeDTO getBeaconInfoByAddr(String address) {
		return dao.getBeaconInfoByAddr(address);
	}

	@Override
	public boolean isBeaconInfoByVO(BeaconVO vo) {
		return dao.isBeaconInfoByVO(vo);
	}
}
