package com.sinc.beez.dept.model.vo;

public class DeptVO {
	
	private String dept_id, dept_name, higher_dept,
	        office_addr;

	
	
	public DeptVO(String dept_id, String dept_name, String higher_dept,
			String office_addr) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.higher_dept = higher_dept;
		this.office_addr = office_addr;
	}

	@Override
	public String toString() {
		return "DeptVO [dept_id=" + dept_id + ", dept_name="
				+ dept_name + ", higher_dept=" + higher_dept
				+ ", office_addr=" + office_addr + "]";
	}

	public DeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getHigher_dept() {
		return higher_dept;
	}

	public void setHigher_dept(String higher_dept) {
		this.higher_dept = higher_dept;
	}

	public String getOffice_addr() {
		return office_addr;
	}

	public void setOffice_addr(String office_addr) {
		this.office_addr = office_addr;
	}

}
