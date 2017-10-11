package com.sinc.beez.autoAttend.dao;

import com.sinc.beez.autoAttend.model.AutoAttDTO;

public interface AutoAttDAO {
	public int workIn(AutoAttDTO dto);
	public int workOut(AutoAttDTO dto);
	public int workUpdate(AutoAttDTO dto);
}
