package com.payroll.api.controller;


import com.payroll.api.model.Leave;
import com.payroll.api.service.LeaveService;

import common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public ResponseEntity<Response<Leave>> createLeave(@RequestBody Leave leave) {
        Leave createdLeave = leaveService.createLeave(leave);
        Response<Leave> response = new Response<>("Leave Added successfully", createdLeave);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{leaveId}")
    public ResponseEntity<Response<Leave>> updateLeave(@PathVariable int leaveId, @RequestBody Leave leave) {
    	Leave updatedLeave = leaveService.updateLeave(leaveId, leave);
    	Response<Leave> response = new Response<>("Leave updated successfully", updatedLeave);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{leaveId}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable int leaveId) {
        Leave leave = leaveService.getLeaveById(leaveId);
        return new ResponseEntity<>(leave, HttpStatus.OK);
    }

    @DeleteMapping("/{leaveId}")
    public ResponseEntity<Response<String>> deleteLeaveById(@PathVariable int leaveId) {
        leaveService.deleteLeaveById(leaveId);
        Response<String> response = new Response<>("Leave deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Leave>> getAllLeaves() {
        List<Leave> leaves = leaveService.getAllLeaves();
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }
    
 // Fetch Applied Leave for Given Employee
    @GetMapping("/balance/{employeeId}")
    public ResponseEntity<String> getBalanceLeave(@PathVariable int employeeId) {
        int balanceLeave = leaveService.getBalanceLeave(employeeId);
        String responseMessage = "The remaining leave (Balance Leave) is " + balanceLeave;
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
    
    @GetMapping("/approved/{employeeId}")
    public ResponseEntity<List<Leave>> getApprovedLeave(@PathVariable int employeeId) {
        List<Leave> approvedLeave = leaveService.getApprovedLeave(employeeId);
        return new ResponseEntity<>(approvedLeave, HttpStatus.OK);
    }
    
    @GetMapping("/rejected/{employeeId}")
    public ResponseEntity<List<Leave>> getRejectedLeave(@PathVariable int employeeId) {
        List<Leave> rejectedLeave = leaveService.getRejectedLeave(employeeId);
        return new ResponseEntity<>(rejectedLeave, HttpStatus.OK);
    }
    
    @GetMapping("/applied/{employeeId}")
    public ResponseEntity<?> getAllLeavesByEmployeeId(@PathVariable int employeeId) {
        List<Leave> leaves = leaveService.getAllLeavesByEmployeeId(employeeId);
        if (leaves.isEmpty()) {
            return new ResponseEntity<>("No leaves found for employee ID: " + employeeId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }
    
    
}
