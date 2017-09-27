package com.sinc.beez.att.model.vo;

import java.util.Date;

public class AttVO {

	private Date all_date;
	private int att_idx;
	private String att_arrive_time,att_leave_time,
	att_newest_chk_time;

	public AttVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getAll_date() {
		return all_date;
	}

	public void setAll_date(Date all_date) {
		this.all_date = all_date;
	}

	public int getAtt_idx() {
		return att_idx;
	}

	public void setAtt_idx(int att_idx) {
		this.att_idx = att_idx;
	}

	public String getAtt_arrive_time() {
		return att_arrive_time;
	}

	public void setAtt_arrive_time(String att_arrive_time) {
		this.att_arrive_time = att_arrive_time;
	}

	public String getAtt_leave_time() {
		return att_leave_time;
	}

	public void setAtt_leave_time(String att_leave_time) {
		this.att_leave_time = att_leave_time;
	}

	public String getAtt_newest_chk_time() {
		return att_newest_chk_time;
	}

	public void setAtt_newest_chk_time(String att_newest_chk_time) {
		this.att_newest_chk_time = att_newest_chk_time;
	}

	@Override
	public String toString() {
		return "AttVO [all_date=" + all_date + ", att_idx=" + att_idx
				+ ", att_arrive_time=" + att_arrive_time + ", att_leave_time="
				+ att_leave_time + ", att_newest_chk_time="
				+ att_newest_chk_time + "]";
	}

	
}
