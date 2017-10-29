package com.sinc.beez.nfcTagging.dao;

import com.sinc.beez.nfcTagging.model.NfcDTO;

public interface NfcDAO {
	public int touchTag(NfcDTO dto);
	public int touchTagUpdate(NfcDTO dto);
	public int touchNewTag(NfcDTO dto);
	public int bookSeat(NfcDTO dto);
	public int updateBooking(NfcDTO dto);
}
