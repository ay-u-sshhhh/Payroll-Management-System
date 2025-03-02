package com.payroll.api.service;

import java.util.List;

import com.payroll.api.model.Leave;

public interface LeaveService {
    Leave createLeave(Leave leave);
    Leave updateLeave(int leaveId, Leave leave);
    Leave getLeaveById(int leaveId);
    void deleteLeaveById(int leaveId);
    List<Leave> getAllLeaves();
    List<Leave> getApprovedLeave(int employeeId);
    List<Leave> getRejectedLeave(int employeeId);
    int getBalanceLeave(int employeeId);
    List<Leave> getAllLeavesByEmployeeId(int employeeId);
}
