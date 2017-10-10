package com.sinc.beez.nfcTagging.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.nfcTagging.dao.NfcDAO;
import com.sinc.beez.nfcTagging.model.NfcDTO;

@Service("NfcService")
public class NfcServiceImpl implements NfcService {
	
	@Resource(name="NfcDAO")
	NfcDAO dao;

	@Override
	public int touchTag(NfcDTO dto) {
		return dao.touchTag(dto);
	}

}
