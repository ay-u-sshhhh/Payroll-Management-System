package com.payroll.api.service;

import java.util.List;

import com.payroll.api.model.ApplyLeave;

public interface ApplyLeaveService {
    ApplyLeave createLeave(ApplyLeave applyLeave);
    ApplyLeave updateLeave(int leaveId, ApplyLeave applyLeave);
    ApplyLeave getLeaveById(int leaveId);
    void deleteLeaveById(int leaveId);
    List<ApplyLeave> getAllLeaves();
}
