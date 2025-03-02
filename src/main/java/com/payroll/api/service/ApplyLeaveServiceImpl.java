package com.payroll.api.service;

import com.payroll.api.entity.ApplyLeaveEntity;
import com.payroll.api.model.ApplyLeave;
import com.payroll.api.repositories.ApplyLeaveDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

    @Autowired
    private ApplyLeaveDao applyLeaveDao;

    @Override
    public ApplyLeave createLeave(ApplyLeave applyLeave) {
        ApplyLeaveEntity entity = new ApplyLeaveEntity();
        BeanUtils.copyProperties(applyLeave, entity);
        ApplyLeaveEntity savedEntity = applyLeaveDao.save(entity);
        ApplyLeave savedLeave = new ApplyLeave();
        BeanUtils.copyProperties(savedEntity, savedLeave);
        return savedLeave;
    }

    @Override
    public ApplyLeave updateLeave(int leaveId, ApplyLeave applyLeave) {
        Optional<ApplyLeaveEntity> optionalEntity = applyLeaveDao.findById(leaveId);
        if (optionalEntity.isPresent()) {
            ApplyLeaveEntity entity = optionalEntity.get();
            BeanUtils.copyProperties(applyLeave, entity);
            ApplyLeaveEntity updatedEntity = applyLeaveDao.save(entity);
            ApplyLeave updatedLeave = new ApplyLeave();
            BeanUtils.copyProperties(updatedEntity, updatedLeave);
            return updatedLeave;
        }
        throw new RuntimeException("Leave with ID " + leaveId + " not found.");
    }

    @Override
    public ApplyLeave getLeaveById(int leaveId) {
        Optional<ApplyLeaveEntity> optionalEntity = applyLeaveDao.findById(leaveId);
        if (optionalEntity.isPresent()) {
            ApplyLeaveEntity entity = optionalEntity.get();
            ApplyLeave leave = new ApplyLeave();
            BeanUtils.copyProperties(entity, leave);
            return leave;
        }
        throw new RuntimeException("Leave with ID " + leaveId + " not found.");
    }

    @Override
    public void deleteLeaveById(int leaveId) {
        applyLeaveDao.deleteById(leaveId);
    }

    @Override
    public List<ApplyLeave> getAllLeaves() {
        List<ApplyLeaveEntity> entities = applyLeaveDao.findAll();
        return entities.stream()
                .map(entity -> {
                    ApplyLeave leave = new ApplyLeave();
                    BeanUtils.copyProperties(entity, leave);
                    return leave;
                })
                .collect(Collectors.toList());
    }
    
    
    
}
