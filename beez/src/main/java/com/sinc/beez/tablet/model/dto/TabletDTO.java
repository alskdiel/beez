package com.sinc.beez.tablet.model.dto;

public class TabletDTO {

	private int office_seq;
	private String seat_id, seat_real_location, seat_useable_state,
			seat_nfc_tag_id;
	private String user_id, seated_date, user_leave_yn;

	public TabletDTO() {
		super();
	}

	public TabletDTO(int office_seq, String seat_id, String seat_real_location,
			String seat_useable_state, String seat_nfc_tag_id, String user_id,
			String seated_date, String user_leave_yn) {
		super();
		this.office_seq = office_seq;
		this.seat_id = seat_id;
		this.seat_real_location = seat_real_location;
		this.seat_useable_state = seat_useable_state;
		this.seat_nfc_tag_id = seat_nfc_tag_id;
		this.user_id = user_id;
		this.seated_date = seated_date;
		this.user_leave_yn = user_leave_yn;
	}

	@Override
	public String toString() {
		return "TabletDTO [office_seq=" + office_seq + ", seat_id=" + seat_id
				+ ", seat_real_location=" + seat_real_location
				+ ", seat_useable_state=" + seat_useable_state
				+ ", seat_nfc_tag_id=" + seat_nfc_tag_id + ", user_id="
				+ user_id + ", seated_date=" + seated_date + ", user_leave_yn="
				+ user_leave_yn + "]";
	}

	public int getOffice_seq() {
		return office_seq;
	}

	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSeated_date() {
		return seated_date;
	}

	public void setSeated_date(String seated_date) {
		this.seated_date = seated_date;
	}

	public String getUser_leave_yn() {
		return user_leave_yn;
	}

	public void setUser_leave_yn(String user_leave_yn) {
		this.user_leave_yn = user_leave_yn;
	}

}
