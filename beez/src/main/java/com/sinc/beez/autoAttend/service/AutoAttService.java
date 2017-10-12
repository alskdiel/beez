package com.sinc.beez.autoAttend.service;

import com.sinc.beez.autoAttend.model.AutoAttDTO;

public interface AutoAttService {
	public int workIn(AutoAttDTO dto);
	public int workOut(AutoAttDTO dto);
	public int workUpdate(AutoAttDTO dto);
	

}
