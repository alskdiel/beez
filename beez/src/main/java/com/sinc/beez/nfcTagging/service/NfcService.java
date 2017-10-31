package com.sinc.beez.nfcTagging.service;

import com.sinc.beez.nfcTagging.model.NfcDTO;

public interface NfcService {
	public int touchTag(NfcDTO dto);
	public int touchTagUpdate(NfcDTO dto);
	public String SyncMap(String taginfo);
	public int bookSeat(NfcDTO dto);
	public int touchTagBooking(NfcDTO dto);
	public int leaveTag(NfcDTO dto);
	public int deleteBook (NfcDTO dto);
	public int deleteSeat(NfcDTO dto);
}
