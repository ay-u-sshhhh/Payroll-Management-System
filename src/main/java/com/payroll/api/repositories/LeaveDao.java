package com.payroll.api.repositories;

import com.payroll.api.entity.LeaveEntity;
import com.payroll.api.model.Leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeaveDao extends JpaRepository<LeaveEntity, Integer> {

	@Query("SELECT new com.payroll.api.model.Leave(l.leaveId, l.type, l.description, l.totalDays, l.startDate, l.endDate, l.employeeId, l.leaveCode, l.status) FROM LeaveEntity l WHERE l.employeeId = :employeeId AND UPPER(l.status) = UPPER(:status)")
    List<Leave> findByEmployeeIdAndStatus(@Param("employeeId") int employeeId, @Param("status") String status);
	
	@Query("SELECT new com.payroll.api.model.Leave(l.leaveId, l.type, l.description, l.totalDays, l.startDate, l.endDate, l.employeeId, l.leaveCode, l.status) FROM LeaveEntity l WHERE l.employeeId = :employeeId")
    List<Leave> findByEmployeeId(@Param("employeeId") int employeeId);
}
