package com.sinc.beez.main.model;

public class MainVO {
	String state;
	String position;
	String userid;
	String attDate;
	
	public MainVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MainVO(String state, String position, String userid,
			String attDate) {
		super();
		this.state = state;
		this.position = position;
		this.userid = userid;
		this.attDate = attDate;
	}


	@Override
	public String toString() {
		return "MainVO [state=" + state + ", position=" + position
				+ ", userid=" + userid + ", attDate=" + attDate
				+ "]";
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAttDate() {
		return attDate;
	}
	public String getPosition() {
		return position;
	}
	public String getState() {
		return state;
	}
	public String getUserid() {
		return userid;
	}
}
