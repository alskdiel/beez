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
		System.out.println("touchTag : " + dto);
		return session.insert(PREFIX + "seatTouch", dto);
	}

	@Override
	public int updateBooking(NfcDTO dto) {
		// TODO Auto-generated method stub
		return session.delete(PREFIX+"updateBooking",dto);
	}

	@Override
	public int touchTagUpdate(NfcDTO dto) {
		System.out.println("touchUpdate : " + dto);
		return session.update(PREFIX + "seatTouchUpdate", dto);
	}

	@Override
	public int touchNewTag(NfcDTO dto) {
		System.out.println("touchNewTag : " + dto);
		return session.insert(PREFIX + "seatNewTouch", dto);
	}

	@Override
	public int bookSeat(NfcDTO dto) {
		// TODO Auto-generated method stub
		return session.insert(PREFIX + "seatNewBook", dto);
	}
}
