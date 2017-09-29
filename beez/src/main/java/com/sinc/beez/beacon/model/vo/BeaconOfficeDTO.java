package com.sinc.beez.beacon.model.vo;

public class BeaconOfficeDTO {
	private	String		beacon_id;
	private	String		beacon_addr;
	private	String		beacon_position;
	private	String		beacon_alias;
	private	int		floor_num;
	private	String		building_name;
	
	public BeaconOfficeDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BeaconOfficeDTO [beacon_id=" + beacon_id
				+ ", beacon_addr=" + beacon_addr
				+ ", beacon_position=" + beacon_position
				+ ", beacon_alias=" + beacon_alias
				+ ", floor_num=" + floor_num
				+ ", building_name=" + building_name + "]";
	}

	public BeaconOfficeDTO(String beacon_id, String beacon_addr,
			String beacon_position, String beacon_alias,
			int floor_num, String building_name) {
		super();
		this.beacon_id = beacon_id;
		this.beacon_addr = beacon_addr;
		this.beacon_position = beacon_position;
		this.beacon_alias = beacon_alias;
		this.floor_num = floor_num;
		this.building_name = building_name;
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

	public int getfloor_num() {
		return floor_num;
	}

	public void setfloor_num(int floor_num) {
		this.floor_num = floor_num;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	
	
}
