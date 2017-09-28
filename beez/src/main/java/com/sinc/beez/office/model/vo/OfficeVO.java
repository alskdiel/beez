package com.sinc.beez.office.model.vo;

import java.util.List;

import com.sinc.beez.seat.model.vo.SeatVO;

public class OfficeVO {

	private int office_seq;
	private int floor_num;
	private String building_name;
	
	private List<SeatVO> seat;
	
	public OfficeVO(int office_seq, int floor_num, String building_name) {
		super();
		this.office_seq = office_seq;
		this.floor_num = floor_num;
		this.building_name = building_name;
	}
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
		return "OfficeVO [office_seq=" + office_seq + ", floor_num="
				+ floor_num + ", building_name="
				+ building_name + "]";
	}
	
	
	
}
