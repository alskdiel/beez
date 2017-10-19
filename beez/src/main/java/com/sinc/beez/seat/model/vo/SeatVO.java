package com.sinc.beez.seat.model.vo;

import com.sinc.beez.office.model.vo.OfficeVO;

public class SeatVO {
    	
	private String office_seq, seat_id, seat_real_location,
	        seat_useable_state,seat_nfc_tag_id;
     
	private OfficeVO office;
	
	
	public SeatVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SeatVO [office_seq=" + office_seq + ", seat_id=" + seat_id
				+ ", seat_real_location=" + seat_real_location
				+ ", seat_useable_state=" + seat_useable_state
				+ ", seat_nfc_tag_id=" + seat_nfc_tag_id + ", office=" + office
				+ "]";
	}

	public String getOffice_seq() {
		return office_seq;
	}

	public void setOffice_seq(String office_seq) {
		this.office_seq = office_seq;
	}

	public OfficeVO getOffice() {
		return office;
	}

	public void setOffice(OfficeVO office) {
		this.office = office;
	}

	public SeatVO(String office_seq, String seat_id, String seat_real_location,
			String seat_useable_state, String seat_nfc_tag_id, OfficeVO office) {
		super();
		this.office_seq = office_seq;
		this.seat_id = seat_id;
		this.seat_real_location = seat_real_location;
		this.seat_useable_state = seat_useable_state;
		this.seat_nfc_tag_id = seat_nfc_tag_id;
		this.office = office;
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
