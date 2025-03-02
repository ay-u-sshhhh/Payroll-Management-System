package com.payroll.api.service;

import java.util.List;

import com.payroll.api.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee employee);

    void deleteEmployee(int employeeId);
}

