package com.payroll.api.controller;

import com.payroll.api.model.Employee;
import com.payroll.api.service.EmployeeService;

import common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Response<Employee>> getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            Response<Employee> response = new Response<>("Employee found", employee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Response<Employee>> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        Response<Employee> response = new Response<>("Employee added successfully", createdEmployee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Response<Employee>> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        if (updatedEmployee != null) {
            Response<Employee> response = new Response<>("Employee updated successfully", updatedEmployee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Response<String>> deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        Response<String> response = new Response<>("Employee deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
