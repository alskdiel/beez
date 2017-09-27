package com.sinc.beez.user.model.vo;

public class UserVO {
	
	private String dept_id, user_pwd, user_name, skey_use, phone_num,
	duty_name, last_access;
	private int fail_cnt;
	
	public UserVO() {
		super();
	}
	
	public UserVO(String dept_id, String user_pwd, String user_name,
			String skey_use, String phone_num, String duty_name,
			String last_access, int fail_cnt) {
		super();
		this.dept_id = dept_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.skey_use = skey_use;
		this.phone_num = phone_num;
		this.duty_name = duty_name;
		this.last_access = last_access;
		this.fail_cnt = fail_cnt;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
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
	public String getSkey_use() {
		return skey_use;
	}
	public void setSkey_use(String skey_use) {
		this.skey_use = skey_use;
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
	public int getFail_cnt() {
		return fail_cnt;
	}
	public void setFail_cnt(int fail_cnt) {
		this.fail_cnt = fail_cnt;
	}
	@Override
	public String toString() {
		return "UserVO [dept_id=" + dept_id + ", user_pwd=" + user_pwd
				+ ", user_name=" + user_name + ", skey_use=" + skey_use
				+ ", phone_num=" + phone_num + ", duty_name=" + duty_name
				+ ", last_access=" + last_access + ", fail_cnt=" + fail_cnt
				+ "]";
	}
	
	
	
}
