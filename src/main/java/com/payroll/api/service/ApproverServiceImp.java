package com.payroll.api.service;

import com.payroll.api.entity.ApproverEntity;
import com.payroll.api.model.Approver;
import com.payroll.api.repositories.ApproverDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApproverServiceImp implements ApproverService {

    @Autowired
    private ApproverDao ApproverDao;

    @Override
    public Approver createApprover(Approver approver) {
    	
    	// Check if the employee ID already exists
        Optional<ApproverEntity> existingApprovers = ApproverDao.findById(approver.getEmployeeId());
        if (!existingApprovers.isEmpty()) {
            // Employee ID already exists, return an error response
            throw new RuntimeException("Approver with Employee ID " + approver.getEmployeeId() + " already exists.");
        }
    	
        ApproverEntity entity = new ApproverEntity();
        BeanUtils.copyProperties(approver, entity);
        ApproverEntity savedEntity = ApproverDao.save(entity);
        Approver savedApprover = new Approver();
        BeanUtils.copyProperties(savedEntity, savedApprover);
        return savedApprover;
    }

    @Override
    public Approver updateApprover(int approverId, Approver approver) {
        Optional<ApproverEntity> optionalEntity = ApproverDao.findById(approverId);
        if (optionalEntity.isPresent()) {
            ApproverEntity entity = optionalEntity.get();

            // Prevent override of leaveId
            int originalApproverId = entity.getApproverId();
            
            BeanUtils.copyProperties(approver, entity, "leaveId"); // Exclude `approverId` from being copied
            entity.setApproverId(originalApproverId); // Ensure the original ID is preserved

            ApproverEntity updatedEntity = ApproverDao.save(entity);
            Approver updatedApprover = new Approver();
            BeanUtils.copyProperties(updatedEntity, updatedApprover);
            return updatedApprover;
        }
        throw new RuntimeException("Approver with ID " + approverId + " not found.");
    }

    @Override
    public Approver getApproverById(int approverId) {
        Optional<ApproverEntity> optionalEntity = ApproverDao.findById(approverId);
        if (optionalEntity.isPresent()) {
            ApproverEntity entity = optionalEntity.get();
            Approver approver = new Approver();
            BeanUtils.copyProperties(entity, approver);
            return approver;
        }
        throw new RuntimeException("Approver with ID " + approverId + " not found.");
    }

    @Override
    public void deleteApproverById(int approverId) {
        ApproverDao.deleteById(approverId);
    }

    @Override
    public List<Approver> getAllApprovers() {
        List<ApproverEntity> entities = ApproverDao.findAll();
        return entities.stream()
                .map(entity -> {
                    Approver approver = new Approver();
                    BeanUtils.copyProperties(entity, approver);
                    return approver;
                })
                .collect(Collectors.toList());
    }
}
