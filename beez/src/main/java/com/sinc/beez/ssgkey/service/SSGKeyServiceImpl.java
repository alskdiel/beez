package com.sinc.beez.ssgkey.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service("SSGKeyService")
class SSGKeyServiceImpl implements SSGKeyService {
	// key : pcName
	// value : RSSI
	Map<String, Integer> udMap;
	public SSGKeyServiceImpl() {
		udMap = new HashMap<String, Integer>();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getRssi(String pcName) {
		int rssi = 0;
		try {
			rssi = udMap.get(pcName);
		} catch (Exception e) {
			// TODO: handle exception
			return 99999;
		}
		return rssi;
	}
	@SuppressWarnings("finally")
	@Override
	public boolean setRssi(String pcName, int Rssi) {
		// TODO Auto-generated method stub
		try {
			int rssi = udMap.get(pcName);
			if(rssi > -1000){
				udMap.remove(pcName);
			}
				
		} catch (Exception e) {
			
		}finally{
			udMap.put(pcName, Rssi);
			return true;
		}
	}

}
