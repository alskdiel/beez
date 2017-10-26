package com.sinc.beez.nfcTagging.model;

public class NfcDTO {
	String deviceid;
	String userid;
	String tagginginfo;
	String oldtagginginfo;
	String officefloor;
	String area;
	String seatid;
	String starttime;

	
	
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStarttime() {
		return starttime;
	}

	public NfcDTO(String deviceid, String userid, String tagginginfo,
			String oldtagginginfo, String officefloor, String area,
			String seatid, String starttime) {
		super();
		this.deviceid = deviceid;
		this.userid = userid;
		this.tagginginfo = tagginginfo;
		this.oldtagginginfo = oldtagginginfo;
		this.officefloor = officefloor;
		this.area = area;
		this.seatid = seatid;
		this.starttime = starttime;
	}

	@Override
	public String toString() {
		return "NfcDTO [deviceid=" + deviceid + ", userid=" + userid
				+ ", tagginginfo=" + tagginginfo
				+ ", oldtagginginfo=" + oldtagginginfo
				+ ", officefloor=" + officefloor + ", area="
				+ area + ", seatid=" + seatid + ", starttime="
				+ starttime + "]";
	}

	public NfcDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTagginginfo() {
		return tagginginfo;
	}
	public void setTagginginfo(String taggingInfo) {
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

	public String getOldtagginginfo() {
		return oldtagginginfo;
	}

	public void setOldtagginginfo(String oldtagginginfo) {
		this.oldtagginginfo = oldtagginginfo;
	}

	public String getOfficefloor() {
		return officefloor;
	}

	public void setOfficefloor(String officefloor) {
		this.officefloor = officefloor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSeatid() {
		return seatid;
	}

	public void setSeatid(String seatid) {
		this.seatid = seatid;
	}
	
	
}
