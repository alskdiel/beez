package com.sinc.beez.autoAttend.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.autoAttend.model.AutoAttDTO;

@Repository("AutoAttDAO")
public class AutoAttDAOImpl implements AutoAttDAO {
	private static final String PREFIX = "com.sinc.beez.mapper.autoatt.";
	@Inject
	SqlSession session;
	
	
	@Override
	public int workIn(AutoAttDTO dto) {
		return session.update(PREFIX+"workin", dto);
	}

	@Override
	public int workOut(AutoAttDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int workUpdate(AutoAttDTO dto) {
		// TODO Auto-generated method stub
		return session.update(PREFIX+"workupdate", dto);
	}
}
