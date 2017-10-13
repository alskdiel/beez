package com.sinc.beez.ssgkey.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service("SSGKeyService")
class SSGKeyServiceImpl implements SSGKeyService {
	// key : pcName
	// value : RSSI
	Map<String, Integer> udMap;
	int lock_cnt;
	public SSGKeyServiceImpl() {
		udMap = new HashMap<String, Integer>();
		lock_cnt = 0;
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
	//	System.out.println("LOCKCNT"+lock_cnt);
		int rssi = 0;
		try {
			rssi = udMap.get(pcName);
			if(Rssi == 72731992){
				lock_cnt = 1;
			}
			if(lock_cnt >0){
				lock_cnt--;
				Rssi = 72731992;
			}
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
