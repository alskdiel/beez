package com.sinc.beez.tablet.model.vo;

public class TabletVO {
	
	private String col, row;
	private int data;
	
	public TabletVO() {
		super();
	}

	public TabletVO(String col, String row, int data) {
		super();
		this.col = col;
		this.row = row;
		this.data = data;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TabletVO [col=" + col + ", row=" + row + ", data=" + data + "]";
	}
}
