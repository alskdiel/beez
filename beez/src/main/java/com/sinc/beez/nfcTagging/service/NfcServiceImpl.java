package com.sinc.beez.nfcTagging.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.beez.nfcTagging.dao.NfcDAO;
import com.sinc.beez.nfcTagging.model.NfcDTO;

@Service("NfcService")
public class NfcServiceImpl implements NfcService {

	Map<String, String> onMem;

	public NfcServiceImpl() {
		onMem = new HashMap<String, String>();
	}

	@Resource(name = "NfcDAO")
	NfcDAO dao;

	@Override
	public int touchTagBooking(NfcDTO dto) {
		// TODO Auto-generated method stub

		return dao.updateBooking(dto);

	}
	@Override
	public int deleteBook(NfcDTO dto) {
		// TODO Auto-generated method stub
		return dao.deleteTag(dto);
	}

	@Override
	public int bookSeat(NfcDTO dto) {
		// TODO Auto-generated method stub

		return dao.bookSeat(dto);
	}

	@Override
	public String SyncMap(String taginfo) {
		System.out.println(taginfo + " / " + onMem.get(taginfo));
		String temp = onMem.get(taginfo);
		if (temp == null || temp.equals(null)) {
			return "false";
		} else {
			if (temp.equals(getDate()) || temp == getDate()) {
				return "true";
			} else {
				return "false";
			}
		}
	}

	@Override
	public int touchTag(NfcDTO dto) {
		System.out.println("NEW TAG : " + dto.toString());
		try {
			String temp = onMem.get(dto.getTagginginfo());
			System.out.println("temp : " + temp + "getT : "
					+ dto.getTagginginfo());
			if (temp == getDate() || temp.equals(getDate())) {
				System.out.println("RETURN -4");
				return -4;
			}
		} catch (Exception e) {
		}
		onMem.put(dto.getTagginginfo(), getDate());
		return dao.touchTag(dto);
	}

	@Override
	public int touchTagUpdate(NfcDTO dto) {
		System.out.println("UPDATE TAG : " + dto.toString());
		try {
			String temp = onMem.get(dto.getTagginginfo());
			System.out.println("temp : " + temp + "getOT : "
					+ dto.getTagginginfo());
			if (temp == getDate() || temp.equals(getDate())) {
				System.out.println("RETURN -5");
				return -5;
			}
		} catch (Exception e) {
		}
		onMem.remove(dto.getOldtagginginfo());
		onMem.put(dto.getTagginginfo(), getDate());

		int r = dao.touchTagUpdate(dto);
		if (r > 0) {
			r = dao.touchNewTag(dto);
		}
		return r;
	}

	@Override
	public int leaveTag(NfcDTO dto) {
		
		
		return dao.leaveTag(dto);
	}

	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd", java.util.Locale.getDefault());
		Date date = new Date();
		String strDate = dateFormat.format(date);
		return strDate;
	}

}
