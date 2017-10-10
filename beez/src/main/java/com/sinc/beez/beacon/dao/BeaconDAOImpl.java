package com.sinc.beez.beacon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.beacon.model.vo.BeaconOfficeDTO;
import com.sinc.beez.beacon.model.vo.BeaconVO;

@Repository("BeaconDAO")
public class BeaconDAOImpl implements BeaconDAO {
	private static final String PREFIX = "com.sinc.beez.mapper.beacon.";
	@Inject
	SqlSession session;

	@Override
	public List<BeaconOfficeDTO> getBeaconInfoAll() {
		return session.selectList(PREFIX + "getBeaconInfoAll");
	}

	@Override
	public BeaconOfficeDTO getBeaconInfoByAddr(String address) {
		System.out.println(address);
		BeaconOfficeDTO dto = new BeaconOfficeDTO();
		dto = session.selectOne(PREFIX + "getBeaconInfoByAddr", address);
		
		if (dto == null) return new BeaconOfficeDTO();
		return dto;
	}

	@Override
	public boolean isBeaconInfoByVO(BeaconVO vo) {

		BeaconVO temp = session.selectOne(PREFIX + "isBeaconInfoByVO",
				vo);

		if (temp == null || temp.getBeacon_id().equals(null)
				|| temp.getBeacon_id() == null)
			return false;
		else
			return true;
	}
}
