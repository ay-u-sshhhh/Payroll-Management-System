package com.payroll.api.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ayush_apply_leave", schema = "infosys_intern_java_payroll")
public class ApplyLeaveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LeaveID")
    private int leaveId;

    @Column(name = "Type")
    private String type;

    @Column(name = "EmployeeID")
    private int employeeId;

    @Column(name = "TotalDays")
    private int totalDays;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "Status", columnDefinition = "VARCHAR(20) DEFAULT 'pending'")
    private String status;

    @Column(name = "ManagerID")
    private int managerId;

    @Column(name = "ManagerComments")
    private String managerComments;

	public ApplyLeaveEntity(int leaveId, String type, int employeeId, int totalDays, Date startDate, Date endDate,
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

	public ApplyLeaveEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getLeaveId() {
		return leaveId;
	}

//	public void setLeaveId(int leaveId) {
//		this.leaveId = leaveId;
//	}

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
