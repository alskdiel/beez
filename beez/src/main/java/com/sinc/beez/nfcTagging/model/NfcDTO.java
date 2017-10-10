package com.sinc.beez.nfcTagging.model;

public class NfcDTO {
	String deviceid;
	String userid;
	String tagginginfo;
	String officefloor;
	String area;
	String seatid;


	@Override
	public String toString() {
		return "NfcDTO [deviceid=" + deviceid + ", userid=" + userid
				+ ", tagginginfo=" + tagginginfo
				+ ", officefloor=" + officefloor + ", area="
				+ area + ", seatid=" + seatid + "]";
	}

	public NfcDTO(String deviceID, String userID, String taggingInfo) {
		super();
		deviceid = deviceID;
		userid = userID;
		tagginginfo = taggingInfo;
		divideTagInfo();
	}

	public NfcDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getDeviceID() {
		return deviceid;
	}

	public void setDeviceID(String deviceID) {
		deviceid = deviceID;
	}

	public String getUserID() {
		return userid;
	}

	public void setUserID(String userID) {
		userid = userID;
	}

	public String getTaggingInfo() {
		return tagginginfo;
	}

	public void setTaggingInfo(String taggingInfo) {
		tagginginfo = taggingInfo;
		divideTagInfo();
	}

	private void divideTagInfo() {
		if (tagginginfo != null) {
			String[] t = tagginginfo.split("-");
			officefloor = t[0].replaceAll("F", "");
			area = t[1];
			seatid = t[2];
		}
	}
	public String getArea() {
		return area;
	}
	public String getOfficeFloor() {
		return officefloor;
	}
	public String getSeatID() {
		return seatid;
	}
}
