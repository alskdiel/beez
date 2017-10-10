package com.sinc.beez.nfcTagging.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.nfcTagging.model.NfcDTO;

@Repository("NfcDAO")
public class NfcDAOImpl implements NfcDAO {
	private static final String PREFIX = "com.sinc.beez.mapper.nfcmapper.";
	@Inject
	SqlSession session;

	@Override
	public int touchTag(NfcDTO dto) {
		System.out.println(dto);
		return session.insert(PREFIX+"seatTouch", dto);
	}

}
