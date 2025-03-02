package com.payroll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.api.model.ApplyLeave;
import com.payroll.api.service.ApplyLeaveService;

import common.Response;

@RestController
@RequestMapping("/applyleaves")
public class ApplyLeaveController {

    @Autowired
    private ApplyLeaveService applyLeaveService;

    @PostMapping
    public ResponseEntity<Response<ApplyLeave>> createLeave(@RequestBody ApplyLeave applyLeave) {
        ApplyLeave createdLeave = applyLeaveService.createLeave(applyLeave);
        Response<ApplyLeave> response = new Response<>("Leave Application added successfully", createdLeave);
        
        
     // Return ResponseEntity with the EmployeeResponse and HTTP status CREATED
        return new ResponseEntity<>(response, HttpStatus.CREATED);
   
    }

    @PutMapping("/{leaveId}")
    public ResponseEntity<Response<ApplyLeave>> updateLeave(@PathVariable int leaveId, @RequestBody ApplyLeave applyLeave) {
        ApplyLeave updatedLeave = applyLeaveService.updateLeave(leaveId, applyLeave);
 
        Response<ApplyLeave> response = new Response<>("Leave Application updated successfully", updatedLeave);
        
        // Return ResponseEntity with the EmployeeResponse and HTTP status CREATED
           return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{leaveId}")
    public ResponseEntity<ApplyLeave> getLeaveById(@PathVariable int leaveId) {
        ApplyLeave leave = applyLeaveService.getLeaveById(leaveId);
        return new ResponseEntity<>(leave, HttpStatus.OK);
    }

    @DeleteMapping("/{leaveId}")
    public ResponseEntity<Response<String>> deleteLeaveById(@PathVariable int leaveId) {
        applyLeaveService.deleteLeaveById(leaveId);
        Response<String> response = new Response<>("Leave Application deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ApplyLeave>> getAllLeaves() {
        List<ApplyLeave> leaves = applyLeaveService.getAllLeaves();
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }
    
    
}
