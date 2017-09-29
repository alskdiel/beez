package com.sinc.beez.userseat.model.vo;

import java.util.Date;

public class UserSeatVO {
	
	private String user_id, seat_id;
	private int office_seq;
	private Date seated_Date;
	private String user_leave_yn;
	
	
	public UserSeatVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSeatVO(String user_id, String seat_id, int office_seq,
			Date seated_Date, String user_leave_yn) {
		super();
		this.user_id = user_id;
		this.seat_id = seat_id;
		this.office_seq = office_seq;
		this.seated_Date = seated_Date;
		this.user_leave_yn = user_leave_yn;
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
	public Date getSeated_Date() {
		return seated_Date;
	}
	public void setSeated_Date(Date seated_Date) {
		this.seated_Date = seated_Date;
	}
	public String getUser_leave_yn() {
		return user_leave_yn;
	}
	public void setUser_leave_yn(String user_leave_yn) {
		this.user_leave_yn = user_leave_yn;
	}
	
	
	@Override
	public String toString() {
		return "UserSeatVO [user_id=" + user_id + ", seat_id=" + seat_id
				+ ", office_seq=" + office_seq + ", seated_Date=" + seated_Date
				+ ", user_leave_yn=" + user_leave_yn + "]";
	}
	
	

}
