package com.sinc.beez.device.model.vo;

public class DeviceVO {

	
	private int device_seq;
	private String device_type, device_mac_addr,
	device_alias,device_unique_id,device_fcm_token,
	device_enable_yn;
		
	public DeviceVO(int device_seq, String device_type,
			String device_mac_addr, String device_alias,
			String device_unique_id, String device_fcm_token,
			String device_enable_yn) {
		super();
		this.device_seq = device_seq;
		this.device_type = device_type;
		this.device_mac_addr = device_mac_addr;
		this.device_alias = device_alias;
		this.device_unique_id = device_unique_id;
		this.device_fcm_token = device_fcm_token;
		this.device_enable_yn = device_enable_yn;
	}

	public DeviceVO() {
		super();
	}

	public int getDevice_seq() {
		return device_seq;
	}

	public void setDevice_seq(int device_seq) {
		this.device_seq = device_seq;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	public String getDevice_mac_addr() {
		return device_mac_addr;
	}

	public void setDevice_mac_addr(String device_mac_addr) {
		this.device_mac_addr = device_mac_addr;
	}

	public String getDevice_alias() {
		return device_alias;
	}

	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}

	public String getDevice_unique_id() {
		return device_unique_id;
	}

	public void setDevice_unique_id(String device_unique_id) {
		this.device_unique_id = device_unique_id;
	}

	public String getDevice_fcm_token() {
		return device_fcm_token;
	}

	public void setDevice_fcm_token(String device_fcm_token) {
		this.device_fcm_token = device_fcm_token;
	}

	public String getDevice_enable_yn() {
		return device_enable_yn;
	}

	public void setDevice_enable_yn(String device_enable_yn) {
		this.device_enable_yn = device_enable_yn;
	}

	@Override
	public String toString() {
		return "DeviceVO [device_seq=" + device_seq + ", device_type="
				+ device_type + ", device_mac_addr=" + device_mac_addr
				+ ", device_alias=" + device_alias + ", device_unique_id="
				+ device_unique_id + ", device_fcm_token=" + device_fcm_token
				+ ", device_enable_yn=" + device_enable_yn + "]";
	}
	
	
}
