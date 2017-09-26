package com.sinc.beez.ssgkey.model;

public class SSGKeyVO {
	private	String		pcName;
	private	String		pcAddr;
	private	int		btRssi;
	private	String		appID;
	private	String		userID;
	@Override
	public String toString() {
		return "SSGKeyVO [pcName=" + pcName + ", pcAddr=" + pcAddr
				+ ", btRssi=" + btRssi + ", appID=" + appID
				+ ", userID=" + userID + "]";
	}
	public SSGKeyVO(String pcName, String pcAddr, int btRssi, String appID,
			String userID) {
		super();
		this.pcName = pcName;
		this.pcAddr = pcAddr;
		this.btRssi = btRssi;
		this.appID = appID;
		this.userID = userID;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public String getPcAddr() {
		return pcAddr;
	}
	public void setPcAddr(String pcAddr) {
		this.pcAddr = pcAddr;
	}
	public int getBtRssi() {
		return btRssi;
	}
	public void setBtRssi(int btRssi) {
		this.btRssi = btRssi;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
}
