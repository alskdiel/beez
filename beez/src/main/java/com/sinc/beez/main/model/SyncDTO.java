package com.sinc.beez.main.model;

/**
 * @author p908v0
 *
 */
public class SyncDTO {

	private String userid;
	private String atttime;
	private boolean att;
	private boolean seat;
	private String seatid;
	private String booking;
	private String today;
	private String leave;
	
	public SyncDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SyncDTO(String userid, String atttime, boolean att,
			boolean seat, String seatid, String booking,
			String today, String leave) {
		super();
		this.userid = userid;
		this.atttime = atttime;
		this.att = att;
		this.seat = seat;
		this.seatid = seatid;
		this.booking = booking;
		this.today = today;
		this.leave = leave;
	}
	@Override
	public String toString() {
		return "SyncDTO [userid=" + userid + ", atttime=" + atttime
				+ ", att=" + att + ", seat=" + seat
				+ ", seatid=" + seatid + ", booking=" + booking
				+ ", today=" + today + ", leave=" + leave + "]";
	}
	public void setLeave(String leave) {
		this.leave = leave;
	}
	public String getLeave() {
		return leave;
	}
	public void setBooking(String booking) {
		this.booking = booking;
	}
	public String getBooking() {
		return booking;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAtttime() {
		return atttime;
	}

	public void setAtttime(String atttime) {
		this.atttime = atttime;
	}

	public boolean isAtt() {
		return att;
	}

	public void setAtt(boolean att) {
		this.att = att;
	}

	public boolean isSeat() {
		return seat;
	}

	public void setSeat(boolean seat) {
		this.seat = seat;
	}

	public String getSeatid() {
		return seatid;
	}

	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	
}
