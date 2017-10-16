package com.sinc.beez.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.main.dao.MainDAO;
import com.sinc.beez.main.model.MainVO;

@Service("MainService")
public class MainService {
	
	@Resource(name="MainDAO")
	MainDAO dao;
	
	public MainVO getMainInto(MainVO vo){
		
		return dao.getMainInfo(vo); 
	}

}
