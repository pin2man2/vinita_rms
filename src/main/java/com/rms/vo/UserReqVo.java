package com.rms.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserReqVo implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("empId")
	String empid;
	@JsonProperty("rolledOff")
	boolean isRolledOff;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public boolean isRolledOff() {
		return isRolledOff;
	}
	public void setRolledOff(boolean isRolledOff) {
		this.isRolledOff = isRolledOff;
	}
	


}
