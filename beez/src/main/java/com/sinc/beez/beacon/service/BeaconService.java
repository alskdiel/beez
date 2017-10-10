package com.sinc.beez.beacon.service;

import java.util.List;
import java.util.Map;

import com.sinc.beez.beacon.model.vo.BeaconOfficeDTO;
import com.sinc.beez.beacon.model.vo.BeaconVO;

public interface BeaconService {
	public BeaconOfficeDTO getBeaconInfoByAddr(String address);
	public List<BeaconOfficeDTO> getBeaconInfoAll();
	public boolean isBeaconInfoByVO(BeaconVO vo);

}
