package com.sinc.beez.beacon.model.vo;

public class BeaconVO {

	
	private String beacon_id;
	private int office_seq;
	private String beacon_addr;
	private String beacon_position;
	private String beacon_alias;
	@Override
	public String toString() {
		return "BeaconVO [beacon_id=" + beacon_id + ", office_seq="
				+ office_seq + ", beacon_addr=" + beacon_addr
				+ ", beacon_position=" + beacon_position
				+ ", beacon_alias=" + beacon_alias + "]";
	}


	public BeaconVO() {
		// TODO Auto-generated constructor stub
	}


	public String getBeacon_id() {
		return beacon_id;
	}


	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}


	public int getOffice_seq() {
		return office_seq;
	}


	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
	}


	public String getBeacon_addr() {
		return beacon_addr;
	}


	public void setBeacon_addr(String beacon_addr) {
		this.beacon_addr = beacon_addr;
	}


	public String getBeacon_position() {
		return beacon_position;
	}


	public void setBeacon_position(String beacon_position) {
		this.beacon_position = beacon_position;
	}


	public String getBeacon_alias() {
		return beacon_alias;
	}


	public void setBeacon_alias(String beacon_alias) {
		this.beacon_alias = beacon_alias;
	}


	public BeaconVO(String beacon_id, int office_seq, String beacon_addr,
			String beacon_position, String beacon_alias) {
		super();
		this.beacon_id = beacon_id;
		this.office_seq = office_seq;
		this.beacon_addr = beacon_addr;
		this.beacon_position = beacon_position;
		this.beacon_alias = beacon_alias;
	}
	
	
}
