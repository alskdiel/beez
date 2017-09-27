package com.sinc.beez.user.model.vo;

import java.util.Date;

import com.sinc.beez.att.model.vo.AttVO;
import com.sinc.beez.dept.model.vo.DeptVO;
import com.sinc.beez.office.model.vo.OfficeVO;
import com.sinc.beez.seat.model.vo.SeatVO;

public class UserVO {
	
	
	
	private String user_id,user_pwd,user_name,
	phone_num,duty_name;
	private String last_access;
	private String skey_use_yn;
	private int fail_cnt;
	private String user_leave_yn;
	private Date seated_date;
	
	
	private AttVO att;
    private DeptVO dept;
	private OfficeVO office;
	private SeatVO seat;
	
	
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getDuty_name() {
		return duty_name;
	}
	public void setDuty_name(String duty_name) {
		this.duty_name = duty_name;
	}
	public String getLast_access() {
		return last_access;
	}
	public void setLast_access(String last_access) {
		this.last_access = last_access;
	}
	public String getSkey_use_yn() {
		return skey_use_yn;
	}
	public void setSkey_use_yn(String skey_use_yn) {
		this.skey_use_yn = skey_use_yn;
	}
	public int getFail_cnt() {
		return fail_cnt;
	}
	public void setFail_cnt(int fail_cnt) {
		this.fail_cnt = fail_cnt;
	}
	public String getUser_leave_yn() {
		return user_leave_yn;
	}
	public void setUser_leave_yn(String user_leave_yn) {
		this.user_leave_yn = user_leave_yn;
	}
	public Date getSeated_date() {
		return seated_date;
	}
	public void setSeated_date(Date seated_date) {
		this.seated_date = seated_date;
	}
	public AttVO getAtt() {
		return att;
	}
	public void setAtt(AttVO att) {
		this.att = att;
	}
	public DeptVO getDept() {
		return dept;
	}
	public void setDept(DeptVO dept) {
		this.dept = dept;
	}
	public OfficeVO getOffice() {
		return office;
	}
	public void setOffice(OfficeVO office) {
		this.office = office;
	}
	public SeatVO getSeat() {
		return seat;
	}
	public void setSeat(SeatVO seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pwd=" + user_pwd
				+ ", user_name=" + user_name + ", phone_num=" + phone_num
				+ ", duty_name=" + duty_name + ", last_access=" + last_access
				+ ", skey_use_yn=" + skey_use_yn + ", fail_cnt=" + fail_cnt
				+ ", user_leave_yn=" + user_leave_yn + ", seated_date="
				+ seated_date + ", att=" + att + ", dept=" + dept + ", office="
				+ office + ", seat=" + seat + "]";
	}


	
	
	
}
