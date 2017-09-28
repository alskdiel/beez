package com.sinc.beez.ssgkey.service;

import java.util.Map;

public interface SSGKeyService {
	public	boolean	setRssi(String pcName, int Rssi);
	public	int		getRssi(String pcName);
	
}
