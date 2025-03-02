package com.payroll.api.service;

import com.payroll.api.entity.LeaveEntity;
import com.payroll.api.model.ApplyLeave;
import com.payroll.api.model.Leave;
import com.payroll.api.repositories.LeaveDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class LeaveServiceImpl implements LeaveService {

	private final LeaveDao leaveDao;
	
	@PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public LeaveServiceImpl(LeaveDao leaveDao) {
        this.leaveDao = leaveDao;
    }

    @Override
    public Leave createLeave(Leave leave) {
        LeaveEntity entity = new LeaveEntity();
        BeanUtils.copyProperties(leave, entity);
        LeaveEntity savedEntity = leaveDao.save(entity);
        Leave savedLeave = new Leave();
        BeanUtils.copyProperties(savedEntity, savedLeave);
        return savedLeave;
    }

    @Override
    public Leave updateLeave(int leaveId, Leave leave) {
        Optional<LeaveEntity> optionalEntity = leaveDao.findById(leaveId);
        if (optionalEntity.isPresent()) {
            LeaveEntity entity = optionalEntity.get();

            // Prevent override of leaveId
            int originalLeaveId = entity.getLeaveId();
            
            BeanUtils.copyProperties(leave, entity, "leaveId"); // Exclude `leaveId` from being copied
            entity.setLeaveId(originalLeaveId); // Ensure the original ID is preserved

            LeaveEntity updatedEntity = leaveDao.save(entity);
            Leave updatedLeave = new Leave();
            BeanUtils.copyProperties(updatedEntity, updatedLeave);
            return updatedLeave;
        }
        throw new RuntimeException("Leave with ID " + leaveId + " not found.");
    }

    @Override
    public Leave getLeaveById(int leaveId) {
        Optional<LeaveEntity> optionalEntity = leaveDao.findById(leaveId);
        if (optionalEntity.isPresent()) {
            LeaveEntity entity = optionalEntity.get();
            Leave leave = new Leave();
            BeanUtils.copyProperties(entity, leave);
            return leave;
        }
        throw new RuntimeException("Leave with ID " + leaveId + " not found.");
    }

    @Override
    public void deleteLeaveById(int leaveId) {
    	leaveDao.deleteById(leaveId);
    }
    
    
    @Override
    public List<Leave> getAllLeaves() {
        List<LeaveEntity> entities = leaveDao.findAll();
        return entities.stream()
                .map(entity -> {
                    Leave leave = new Leave();
                    BeanUtils.copyProperties(entity, leave);
                    return leave;
                })
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Leave> getAllLeavesByEmployeeId(int employeeId) {
    	return leaveDao.findByEmployeeId(employeeId);
    }


    @Override
    public List<Leave> getApprovedLeave(int employeeId) {
        return leaveDao.findByEmployeeIdAndStatus(employeeId, "approved");
    }

    @Override
    public List<Leave> getRejectedLeave(int employeeId) {
        return leaveDao.findByEmployeeIdAndStatus(employeeId, "rejected");
    }

    @Override
    public int getBalanceLeave(int employeeId) {
    	// Total available leave days for all employees
        int totalLeave = 25;
        
        // Query the repository to get the total approved leave days for the employee
        List<Leave> approvedLeaves = leaveDao.findByEmployeeIdAndStatus(employeeId, "approved");
        int totalApprovedDays = approvedLeaves.stream().mapToInt(Leave::getTotalDays).sum();
        
        // Calculate the remaining leave balance
        int remainingLeave = totalLeave - totalApprovedDays;
        
        return remainingLeave;
    }
    

    
    
}
