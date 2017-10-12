package com.sinc.beez.autoAttend.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.autoAttend.dao.AutoAttDAO;
import com.sinc.beez.autoAttend.model.AutoAttDTO;

@Service("AutoAttService")
public class AutoAttServiceImpl implements AutoAttService {
	@Resource(name="AutoAttDAO")
	AutoAttDAO dao;
	
	
	@Override
	public int workIn(AutoAttDTO dto) {
		// TODO Auto-generated method stub
		return dao.workIn(dto);
	}

	@Override
	public int workOut(AutoAttDTO dto) {
		// TODO Auto-generated method stub
		return dao.workOut(dto);
	}
	
	@Override
	public int workUpdate(AutoAttDTO dto) {
		// TODO Auto-generated method stub
		return dao.workUpdate(dto);
	}

}
