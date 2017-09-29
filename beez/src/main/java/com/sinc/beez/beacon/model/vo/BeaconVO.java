package com.sinc.beez.beacon.model.vo;

public class BeaconVO {

	private String 	beacon_id, 
					beacon_addr, 
					beacon_alias, 
					beacon_position;
	
	public BeaconVO() {
		super();
	}

	public BeaconVO(String beacon_id, String beacon_addr, String beacon_alias,
			String beacon_position) {
		super();
		this.beacon_id = beacon_id;
		this.beacon_addr = beacon_addr;
		this.beacon_alias = beacon_alias;
		this.beacon_position = beacon_position;
	}

	public String getBeacon_id() {
		return beacon_id;
	}

	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}

	public String getBeacon_addr() {
		return beacon_addr;
	}

	public void setBeacon_addr(String beacon_addr) {
		this.beacon_addr = beacon_addr;
	}

	public String getBeacon_alias() {
		return beacon_alias;
	}

	public void setBeacon_alias(String beacon_alias) {
		this.beacon_alias = beacon_alias;
	}

	public String getBeacon_position() {
		return beacon_position;
	}

	public void setBeacon_position(String beacon_position) {
		this.beacon_position = beacon_position;
	}

}
