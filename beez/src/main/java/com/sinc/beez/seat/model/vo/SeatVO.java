package com.sinc.beez.seat.model.vo;

import com.sinc.beez.office.model.vo.OfficeVO;

public class SeatVO {
    	
	private String seat_id, seat_real_location,
	        seat_useable_state,seat_nfc_tag_id;
     
	private OfficeVO office;
	
	
	@Override
	public String toString() {
		return "SeatVO [seat_id=" + seat_id + ", seat_real_location="
				+ seat_real_location + ", seat_useable_state="
				+ seat_useable_state + ", seat_nfc_tag_id="
				+ seat_nfc_tag_id + "]";
	}

	public SeatVO(String seat_id, String seat_real_location,
			String seat_useable_state, String seat_nfc_tag_id) {
		super();
		this.seat_id = seat_id;
		this.seat_real_location = seat_real_location;
		this.seat_useable_state = seat_useable_state;
		this.seat_nfc_tag_id = seat_nfc_tag_id;
	}

	public SeatVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public String getSeat_real_location() {
		return seat_real_location;
	}

	public void setSeat_real_location(String seat_real_location) {
		this.seat_real_location = seat_real_location;
	}

	public String getSeat_useable_state() {
		return seat_useable_state;
	}

	public void setSeat_useable_state(String seat_useable_state) {
		this.seat_useable_state = seat_useable_state;
	}

	public String getSeat_nfc_tag_id() {
		return seat_nfc_tag_id;
	}

	public void setSeat_nfc_tag_id(String seat_nfc_tag_id) {
		this.seat_nfc_tag_id = seat_nfc_tag_id;
	}



}
