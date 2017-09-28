package com.sinc.beez.tablet.model.vo;

public class TabletVO {

	private String user_id, seat_id;
	private int office_seq;
	private String user_leave;

	public TabletVO() {
		super();
	}

	public TabletVO(String user_id, String seat_id, int office_seq,
			String user_leave) {
		super();
		this.user_id = user_id;
		this.seat_id = seat_id;
		this.office_seq = office_seq;
		this.user_leave = user_leave;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public int getOffice_seq() {
		return office_seq;
	}

	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
	}

	public String getUser_leave() {
		return user_leave;
	}

	public void setUser_leave(String user_leave) {
		this.user_leave = user_leave;
	}
}
