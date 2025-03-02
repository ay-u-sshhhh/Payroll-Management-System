package com.payroll.api.model;

public class Approver {
    private int approverId;
    private String firstName;
    private String lastName;
    private int employeeId;
    private String email;
    private String department;
    private String managerName;
    private String role;
    private String contactNumber;
	public Approver(int approverId, String firstName, String lastName, int employeeId, String email, String department,
			String managerName, String role, String contactNumber) {
		super();
		this.approverId = approverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.email = email;
		this.department = department;
		this.managerName = managerName;
		this.role = role;
		this.contactNumber = contactNumber;
	}
	public Approver() {
		// TODO Auto-generated constructor stub
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

   
}
