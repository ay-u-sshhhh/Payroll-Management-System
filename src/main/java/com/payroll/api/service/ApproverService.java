package com.payroll.api.service;

import java.util.List;

import com.payroll.api.model.Approver;

public interface ApproverService {
    
    void deleteApproverById(int approverId);
    List<Approver> getAllApprovers();
	Approver updateApprover(int approverId, Approver approver);
	Approver createApprover(Approver approver);
	Approver getApproverById(int approverId);
}
