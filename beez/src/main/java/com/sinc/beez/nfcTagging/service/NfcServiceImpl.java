package com.sinc.beez.nfcTagging.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.nfcTagging.dao.NfcDAO;
import com.sinc.beez.nfcTagging.model.NfcDTO;

@Service("NfcService")
public class NfcServiceImpl implements NfcService {

	@Resource(name = "NfcDAO")
	NfcDAO dao;

	@Override
	public int touchTag(NfcDTO dto) {
		return dao.touchTag(dto);
	}

	@Override
	public int touchTagUpdate(NfcDTO dto) {
		// TODO Auto-generated method stub
		int r =dao.touchTagUpdate(dto);
		if (r > 0){
			r = dao.touchNewTag(dto);
		}
		return r;
	}
}
