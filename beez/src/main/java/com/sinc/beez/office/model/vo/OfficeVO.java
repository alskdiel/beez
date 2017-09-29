package com.sinc.beez.office.model.vo;

public class OfficeVO {

	private String 	beacon_id;
	private int 	floor_num;
	private String 	building_name;

	public OfficeVO() {
		super();
	}

	public OfficeVO(String beacon_id, int floor_num, String building_name) {
		super();
		this.beacon_id = beacon_id;
		this.floor_num = floor_num;
		this.building_name = building_name;
	}

	public String getBeacon_id() {
		return beacon_id;
	}

	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}

	public int getFloor_num() {
		return floor_num;
	}

	public void setFloor_num(int floor_num) {
		this.floor_num = floor_num;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	@Override
	public String toString() {
		return "OfficeVO [beacon_id=" + beacon_id + ", floor_num=" + floor_num
				+ ", building_name=" + building_name + "]";
	}

}
