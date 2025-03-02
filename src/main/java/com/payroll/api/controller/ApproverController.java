package com.payroll.api.controller;

import com.payroll.api.model.Approver;
import com.payroll.api.model.Employee;
import com.payroll.api.service.ApproverService;

import common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/approvers")
public class ApproverController {

    @Autowired
    private ApproverService approverService;

    @GetMapping
    public ResponseEntity<List<Approver>> getAllEmployees() {
        List<Approver> approvers = approverService.getAllApprovers();
        return new ResponseEntity<>(approvers, HttpStatus.OK);
    }

    @GetMapping("/{approverId}")
    public ResponseEntity<Approver> getApproverById(@PathVariable int approverId) {
        Approver approver = approverService.getApproverById(approverId);
        if (approver != null) {
            return new ResponseEntity<>(approver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Response<Approver>> createApprover(@RequestBody Approver approver) {
        Approver createdApprover = approverService.createApprover(approver);
        
        Response<Approver> response = new Response<>("Approver added successfully", createdApprover);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{approverId}")
    public ResponseEntity<Response<Approver>> updateApprover(@PathVariable int approverId, @RequestBody Approver approver) {
        Approver updatedApprover = approverService.updateApprover(approverId, approver);
        if (updatedApprover != null) {
        	// Prepare the EmployeeResponse with the success message and created employee
        	Response<Approver> response = new Response<>("Approver updated successfully", updatedApprover);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        	
            
        } else {
        	
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{approverId}")
    public ResponseEntity<Response<String>> deleteApprover(@PathVariable int approverId) {
    	approverService.deleteApproverById(approverId);
    	Response<String> response = new Response<>("Approver Deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    	
        
    }
}
