package com.sinc.beez.autoAttend.model;

public class AutoAttDTO {
	String userid;
	String beaconid;
	String deviceid;
	
	public AutoAttDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AutoAttDTO [userid=" + userid + ", beaconid="
				+ beaconid + ", deviceid=" + deviceid + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBeaconid() {
		return beaconid;
	}

	public void setBeaconid(String beaconid) {
		this.beaconid = beaconid;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public AutoAttDTO(String userid, String beaconid, String deviceid) {
		super();
		this.userid = userid;
		this.beaconid = beaconid;
		this.deviceid = deviceid;
	}
}
