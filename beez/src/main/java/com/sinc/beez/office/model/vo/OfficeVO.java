package com.sinc.beez.office.model.vo;

public class OfficeVO {

	private int office_seq;
	private String beacon_id;
	private int floor_num;
	private String building_name;
	public OfficeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOffice_seq() {
		return office_seq;
	}
	public void setOffice_seq(int office_seq) {
		this.office_seq = office_seq;
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
		return "OfficeVO [office_seq=" + office_seq + ", beacon_id="
				+ beacon_id + ", floor_num=" + floor_num + ", building_name="
				+ building_name + "]";
	}
	
	
}
