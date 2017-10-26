package com.sinc.beez.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.main.dao.MainDAO;
import com.sinc.beez.main.model.MainVO;
import com.sinc.beez.main.model.SyncDTO;

@Service("MainService")
public class MainService {
	
	@Resource(name="MainDAO")
	MainDAO dao;
	
	public MainVO getMainInto(MainVO vo){
		
		return dao.getMainInfo(vo); 
	}
	public SyncDTO init(SyncDTO dto){
		SyncDTO res = new SyncDTO();
		try{
			res = dao.init(dto);
		}catch(Exception e){
			res = new SyncDTO();
		}
		System.out.println("SERVICE : "+res);
		return res;
	}

}
