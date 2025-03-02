package com.payroll.api.model;

import java.util.Date;
import java.util.List;

public class Leave {
    private int leaveId;
    private String type;
    private String description;
    private int totalDays;
    private Date startDate;
    private Date endDate;
    private int employeeId;
    private String leaveCode;
    private String status;
	public Leave(int leaveId, String type, String description, int totalDays, Date startDate, Date endDate,
			int employeeId, String leaveCode, String status) {
		super();
		this.leaveId = leaveId;
		this.type = type;
		this.description = description;
		this.totalDays = totalDays;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.leaveCode = leaveCode;
		this.status = status;
	}
	public Leave() {
		// TODO Auto-generated constructor stub
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLeaveCode() {
		return leaveCode;
	}
	public void setLeaveCode(String leaveCode) {
		this.leaveCode = leaveCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


    
}
