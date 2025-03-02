package com.payroll.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ayush_leave", schema = "infosys_intern_java_payroll")
public class LeaveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented primary key
    @Column(name = "LeaveID")
    private int leaveId;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    @Column(name = "TotalDays")
    private int totalDays;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "EmployeeID")
    private int employeeId;

    @Column(name = "LeaveCode")
    private String leaveCode;

    @Column(name = "Status")
    private String status;

	public LeaveEntity(int leaveId, String type, String description, int totalDays, Date startDate, Date endDate,
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

	public LeaveEntity() {
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
