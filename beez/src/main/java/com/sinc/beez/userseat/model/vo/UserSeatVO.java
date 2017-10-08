package com.sinc.beez.userseat.model.vo;

import java.util.Date;

public class UserSeatVO {
	
	private String user_id, seat_id;
	private int office_seq;
	private Date seated_Date;
	private String user_leave_yn;
	
	private String building_name;
	private int floor_num;
	private String seat_real_location;
	
	public UserSeatVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSeatVO(String user_id, String seat_id, int office_seq,
			Date seated_Date, String user_leave_yn, String building_name,
			int floor_num, String seat_real_location) {
		super();
		this.user_id = user_id;
		this.seat_id = seat_id;
		this.office_seq = office_seq;
		this.seated_Date = seated_Date;
		this.user_leave_yn = user_leave_yn;
		this.building_name = building_name;
		this.floor_num = floor_num;
		this.seat_real_location = seat_real_location;
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
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public int getFloor_num() {
		return floor_num;
	}
	public void setFloor_num(int floor_num) {
		this.floor_num = floor_num;
	}
	public String getSeat_real_location() {
		return seat_real_location;
	}
	public void setSeat_real_location(String seat_real_location) {
		this.seat_real_location = seat_real_location;
	}
	
	
	@Override
	public String toString() {
		return "UserSeatVO [user_id=" + user_id + ", seat_id=" + seat_id
				+ ", office_seq=" + office_seq + ", seated_Date=" + seated_Date
				+ ", user_leave_yn=" + user_leave_yn + ", building_name="
				+ building_name + ", floor_num=" + floor_num
				+ ", seat_real_location=" + seat_real_location + "]";
	}
	
	
	

}
