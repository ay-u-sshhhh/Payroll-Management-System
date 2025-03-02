package com.payroll.api.model;

import java.util.Date;

public class ApplyLeave {
    private int leaveId;
    private String type;
    private int employeeId;
    private int totalDays;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status;
    private int managerId;
    private String managerComments;
	public ApplyLeave(int leaveId, String type, int employeeId, int totalDays, Date startDate, Date endDate,
			String reason, String status, int managerId, String managerComments) {
		super();
		this.leaveId = leaveId;
		this.type = type;
		this.employeeId = employeeId;
		this.totalDays = totalDays;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.managerId = managerId;
		this.managerComments = managerComments;
	}
	public ApplyLeave() {
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}

    
}
