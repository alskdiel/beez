package com.sinc.beez.beacon.dao;

import java.util.List;

import com.sinc.beez.beacon.model.vo.BeaconOfficeDTO;
import com.sinc.beez.beacon.model.vo.BeaconVO;


public interface BeaconDAO {

	public BeaconOfficeDTO getBeaconInfoByAddr(String address);
	public List<BeaconOfficeDTO> getBeaconInfoAll();
	public boolean isBeaconInfoByVO(BeaconVO vo);
}
