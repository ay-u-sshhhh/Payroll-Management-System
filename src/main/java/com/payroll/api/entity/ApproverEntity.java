package com.payroll.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "ayush_approver", schema = "infosys_intern_java_payroll")
public class ApproverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented primary key
    @Column(name = "ApproverID")
    private int approverId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "EmployeeID")
    private int employeeId;

    @Column(name = "Email")
    private String email;

    @Column(name = "Department")
    private String department;

    @Column(name = "ManagerName")
    private String managerName;

    @Column(name = "Role")
    private String role;

    @Column(name = "ContactNumber")
    private String contactNumber;

	public ApproverEntity(int approverId, String firstName, String lastName, int employeeId, String email,
			String department, String managerName, String role, String contactNumber) {
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
	
	public ApproverEntity() {
        // Default constructor
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
